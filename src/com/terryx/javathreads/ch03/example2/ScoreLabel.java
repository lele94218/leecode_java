package com.terryx.javathreads.ch03.example2;

import com.terryx.javathreads.ch02.CharacterEvent;
import com.terryx.javathreads.ch02.CharacterListener;
import com.terryx.javathreads.ch02.CharacterSource;

import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author taoranxue on 11/15/16 12:37 AM.
 */
public class ScoreLabel extends JLabel implements CharacterListener {
    private volatile int score = 0;
    private int char2type = -1;
    private Lock scoreLock = new ReentrantLock();
    private CharacterSource generator = null;
    private CharacterSource typist = null;


    public ScoreLabel(CharacterSource generator, CharacterSource typist) {
        this.generator = generator;
        this.typist = typist;

        if (generator != null)
            generator.addCharacterListener(this);

        if (typist != null)
            typist.addCharacterListener(this);
    }

    public ScoreLabel() {
        this(null, null);
    }


    public synchronized void resetGenerator(CharacterSource newGenerator) {
        try {
            scoreLock.lock();
            if (generator != null)
                generator.removeCharacterListener(this);

            generator = newGenerator;
            if (generator != null)
                generator.addCharacterListener(this);
        } finally {
            scoreLock.unlock();
        }
    }

    public synchronized void resetTypist(CharacterSource newTypist) {
        try {
            scoreLock.lock();
            if (typist != null)
                typist.removeCharacterListener(this);
            typist = newTypist;
            if (typist != null)
                typist.addCharacterListener(this);
        } finally {
            scoreLock.unlock();
        }
    }

    public synchronized void resetScore() {
        try {
            scoreLock.lock();
            score = 0;
            char2type = -1;
            setScore();
        } finally {
            scoreLock.unlock();
        }
    }

    private synchronized void setScore() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setText(Integer.toString(score));
            }
        });
    }

    @Override
    public void newCharacter(CharacterEvent ce) {
        try {
            scoreLock.lock();
            // Previous character not typed correctly: 1-point penalty
            if (ce.source == generator) {
                if (char2type != -1) {
                    score--;
                    setScore();
                }
                char2type = ce.character;
            }
            // If character is extraneous: 1-point penalty
            // If character does not match: 1-point penalty
            else {
                if (char2type != ce.character) {
                    score--;
                } else {
                    score++;
                    char2type = -1;
                }
                setScore();
            }
        } finally {
            scoreLock.unlock();
        }
    }
}
