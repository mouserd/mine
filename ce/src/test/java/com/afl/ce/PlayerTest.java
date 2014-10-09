package com.afl.ce;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void Constructor_GetId_MatchesValuePassedToConstructor() {
        final int id = 1;
        final Player p = new Player(id);
        
        assertEquals(id, p.getId());
    }
}
