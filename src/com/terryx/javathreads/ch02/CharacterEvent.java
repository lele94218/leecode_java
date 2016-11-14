package com.terryx.javathreads.ch02;

/**
 * @author taoranxue on 11/13/16 8:28 PM.
 */
public class CharacterEvent {
    public CharacterSource source;
    public int character;


    public CharacterEvent(CharacterSource cs, int c) {
        source = cs;
        character = c;
    }
}
