package com.afl.ce;

import java.util.List;

public class Result {
    private final List<Player> losers;
    private final Player winner;
    
    public Result(List<Player> losers, Player winner) {
        this.losers = losers;
        this.winner = winner;
	}
    
    public List<Player> getLosers() {
        return losers;
    }

    public Player getWinner() {
        return winner;
    }

}
