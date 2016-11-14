package com.terryx.javathreads.ch02.example3;

import com.terryx.javathreads.ch02.CharacterEventHandler;
import com.terryx.javathreads.ch02.CharacterListener;
import com.terryx.javathreads.ch02.CharacterSource;

import java.util.Random;

/**
 * @author taoranxue on 11/13/16 8:33 PM.
 */
public class RandomCharacterGenerator extends Thread implements CharacterSource {
    static char[] chars;
    static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";

    static {
        chars = charArray.toCharArray();
    }

    private volatile boolean done = false;
    Random random;
    CharacterEventHandler handler;


    public RandomCharacterGenerator() {
        random = new Random();
        handler = new CharacterEventHandler();
    }

    public void setDone() {
        this.done = true;
    }

    public int getPauseTime() {
        return (int) (Math.max(1000, 5000 * random.nextDouble()));
    }

    public void addCharacterListener(CharacterListener cl) {
        handler.addCharacterListener(cl);
    }

    public void removeCharacterListener(CharacterListener cl) {
        handler.removeCharacterListener(cl);
    }

    public void nextCharacter() {
        handler.fireNewCharacter(this,
                (int) chars[random.nextInt(chars.length)]);
    }

    public void run() {
        while (!done) {
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            } catch (InterruptedException ie) {
                return;
            }
        }
    }
}