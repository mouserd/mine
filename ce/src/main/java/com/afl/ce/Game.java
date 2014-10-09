package com.afl.ce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Fei.You
 *
 */
public class Game 
{
    public Result run(int n, int k) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be more than 1");
        }
        
        if (k < 1) {
            throw new IllegalArgumentException("k must be more than 1");
        }
        
        List<Player> players = initPlayers(n);
        List<Player> losers = new ArrayList<Player>();

        int offset = 0;
        for (int size = n; size > 1; size = players.size()) {
            int loserIndex = (offset + k - 1) % size;
            Player loser = players.get(loserIndex);
            
            int starterIndex = loserIndex + 1 == size ? 0 : loserIndex + 1;
            Player starter = players.get(starterIndex);
            players.remove(loser);
            offset = players.indexOf(starter);  
            
            losers.add(loser);
        }

        final Player winner = players.get(0);
        return new Result(losers, winner);
    }
    
    private List<Player> initPlayers(final int n) {
        List<Player> players = new LinkedList<Player>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(i));
        }
        
        return players;
    }
    
}
