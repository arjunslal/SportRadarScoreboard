package com.sportradar.scoreboard;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Scoreboard to manage live football matches.
 */
public class Scoreboard {

    private final Map<String, Match> matches;

    public Scoreboard() {
        this.matches = new LinkedHashMap<>();
    }

    //To start a match
    public void startMatch(String homeTeam, String awayTeam) {
        startMatch(homeTeam, awayTeam, LocalDateTime.now());
    }

    //Overloaded version for testability with controlled start time.
    public void startMatch(String homeTeam, String awayTeam, LocalDateTime startTime) {

    }

    //Updating the score
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {

    }

    //End Match
    public void finishMatch(String homeTeam, String awayTeam) {

    }

    //Get the summary of ongoing matches
    public List<String> getSummary() {
        return null;//TODO:implement
    }

    private Match getMatch(String homeTeam, String awayTeam) {
        return matches.get(homeTeam + awayTeam);
    }

    private boolean isTeamAlreadyPlaying(String team) {
        if (matches.values().stream().anyMatch(m -> m.getHomeTeam().equals(team))
                || matches.values().stream().anyMatch(m -> m.getAwayTeam().equals(team))) {
            return true;
        } else {
            return false;
        }

    }
}
