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
    public void run_Less1NumberAs1stParam_ExceptionThrown() {
        try {
            game.run(0, 1);
            fail("fail"); 
        } catch (IllegalArgumentException e) {  
            assertEquals("n must be more than 1", e.getMessage()); 
        } 
   }
    
    @Test
    public void run_Less1NumberAs2stParam_ExceptionThrown() {
        try {
            game.run(1, -1);
            fail("fail"); 
        } catch (IllegalArgumentException e) { 
            assertEquals("k must be more than 1", e.getMessage()); 
        } 
    }
    
    @Test
    public void run_1ChildAnd1Count_ExpectedResultReturn () {
        final int n = 1;
        final int k = 1;
        
        final Result result = game.run(n, k);
        
        assertEquals(0, result.getWinner().getId());
        assertEquals(0, result.getLosers().size());
    }

    @Test
    public void run_2ChildrenAnd1Count_ExpectedResultReturn () {
        final int n = 2;
        final int k = 1;
        
        final Result result = game.run(n, k);
        
        assertEquals(1, result.getWinner().getId());
        assertEquals(1, result.getLosers().size());
        assertEquals(0, result.getLosers().get(0).getId());
    }

    @Test
    public void run_3ChildrenAnd4Count_ExpectedResultReturn () {
        final int n = 3;
        final int k = 4;
        
        final Result result = game.run(n, k);
        
        assertEquals(1, result.getWinner().getId());
        assertEquals(2, result.getLosers().size());
        assertEquals(0, result.getLosers().get(0).getId());
        assertEquals(2, result.getLosers().get(1).getId());
    }

    @Test
    public void run_6ChildrenAnd2Count_ExpectedResultReturn () {
        final int n = 6;
        final int k = 2;
        
        final Result result = game.run(n, k);
        
        assertEquals(4, result.getWinner().getId());
        assertEquals(5, result.getLosers().size());
        assertEquals(1, result.getLosers().get(0).getId());
        assertEquals(3, result.getLosers().get(1).getId());
        assertEquals(5, result.getLosers().get(2).getId());
        assertEquals(2, result.getLosers().get(3).getId());
        assertEquals(0, result.getLosers().get(4).getId());
    }

    @Test
    public void run_6ChildrenAnd6Count_ExpectedResultReturn () {
        final int n = 6;
        final int k = 6;
        
        final Result result = game.run(n, k);
        
        assertEquals(3, result.getWinner().getId());
        assertEquals(5, result.getLosers().size());
        assertEquals(5, result.getLosers().get(0).getId());
        assertEquals(0, result.getLosers().get(1).getId());
        assertEquals(2, result.getLosers().get(2).getId());
        assertEquals(1, result.getLosers().get(3).getId());
        assertEquals(4, result.getLosers().get(4).getId());
    }
}
