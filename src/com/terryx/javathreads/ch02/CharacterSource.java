package com.terryx.javathreads.ch02;

/**
 * @author taoranxue on 11/13/16 8:27 PM.
 */
public interface CharacterSource {
    public void addCharacterListener(CharacterListener cl);

    public void removeCharacterListener(CharacterListener cl);

    public void nextCharacter( );
}
