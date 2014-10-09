package com.afl.ce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    /**
     * Run game and return result
     * 
     * @param n number of children
     * @param k count number
     * @return result which contains winner and losers.
     */
    public Result run(final int n, final int k) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be more than 1");
        }
        
        if (k < 1) {
            throw new IllegalArgumentException("k must be more than 1");
        }
        
        List<Player> players = initPlayers(n);
        List<Player> losers = new ArrayList<Player>();

        int starterIndex = 0;
        for (int size = n; size > 1; size = players.size()) {
            //Find out the loser and add it into the loser list 
            final int loserIndex = (starterIndex + k - 1) % size;
            final Player loser = players.get(loserIndex);
            losers.add(loser);
            
            //Find out the next starter 
            final int nextStarterIndex = loserIndex + 1 == size ? 0 : loserIndex + 1;
            final Player nextStarter = players.get(nextStarterIndex);
            
            //Remove the loser from the player list 
            players.remove(loser);

            //Reset the index of the starter for the next loop
            starterIndex = players.indexOf(nextStarter);  
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
    
    public static void main (final String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please enter n :");
        final int n = Integer.parseInt(br.readLine());
        
        System.out.println("Please enter k :");
        final int k = Integer.parseInt(br.readLine());
        
        final Result result = new Game().run(n, k);
        
        System.out.println("Winner : " + result.getWinner());
        System.out.println("Losers : " + result.getLosers());
    }
    
}
