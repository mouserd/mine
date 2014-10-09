package com.afl.ce;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest 
{
    private Game game;
    
    @Before
    public void setup() {
        game = new Game();
    }
    
    @Test
    public void Run_Less1NumberAs1stParam_ExceptionThrown() {
        try {
            game.run(0, 1);
            fail("fail"); 
        } catch (IllegalArgumentException e) { 
            assertEquals("n must be more than 1", e.getMessage()); 
        } 
   }
    
    @Test
    public void Run_Less1NumberAs2stParam_ExceptionThrown() {
        try {
            game.run(1, -1);
            fail("fail"); 
        } catch (IllegalArgumentException e) { 
            assertEquals("k must be more than 1", e.getMessage()); 
        } 
    }
    
    @Test
    public void Run_InputCase1_Correct () {
        final int n = 1;
        final int k = 1;
        
        final Result result = game.run(n, k);
        
        assertEquals(0, result.getWinner().getId());
        assertEquals(0, result.getLosers().size());
    }

    @Test
    public void Run_InputCase2_Correct () {
        final int n = 2;
        final int k = 1;
        
        final Result result = game.run(n, k);
        
        assertEquals(1, result.getWinner().getId());
        assertEquals(1, result.getLosers().size());
        assertEquals(0, result.getLosers().get(0).getId());
    }

    @Test
    public void Run_InputCase3_Correct () {
        final int n = 3;
        final int k = 4;
        
        final Result result = game.run(n, k);
        
        assertEquals(1, result.getWinner().getId());
        assertEquals(2, result.getLosers().size());
        assertEquals(0, result.getLosers().get(0).getId());
        assertEquals(2, result.getLosers().get(1).getId());
    }

}
