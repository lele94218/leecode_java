package com.terryx.javathreads.ch03.example1;

import com.terryx.javathreads.ch02.CharacterEvent;
import com.terryx.javathreads.ch02.CharacterListener;
import com.terryx.javathreads.ch02.CharacterSource;

import javax.swing.*;

/**
 * @author taoranxue on 11/14/16 2:43 AM.
 */
public class ScoreLabel extends JLabel implements CharacterListener {
    private volatile int score = 0;
    private int char2type = -1;
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
        if (generator != null)
            generator.removeCharacterListener(this);
        generator = newGenerator;
        if (generator != null)
            generator.addCharacterListener(this);
    }

    public synchronized void resetTypist(CharacterSource newTypist) {
        if (typist != null)
            typist.removeCharacterListener(this);

        typist = newTypist;

        if (typist != null)
            typist.addCharacterListener(this);
    }

    public synchronized void resetScore() {
        score = 0;
        char2type = -1;
        setScore();
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
    }
}
