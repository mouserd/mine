package com.afl.ce;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ResultTest {

    @Test
    public void constructor_GetMethods_MatchesValuesPassedToConstructor() {
        final Player winner = new Player(1);
        final List<Player> losers = new ArrayList<Player>();
        
        final Result result = new Result(losers, winner);
        assertEquals(winner, result.getWinner());
    }

}
