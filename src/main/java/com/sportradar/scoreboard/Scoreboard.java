package com.sportradar.scoreboard;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Scoreboard to manage live football matches.
 */
public class Scoreboard {

    private final Map<String, Match> matches;

    public Scoreboard() {
        this.matches = new LinkedHashMap<>();
    }

    //To start a match
    void startMatch(String homeTeam, String awayTeam) {
        startMatch(homeTeam, awayTeam, LocalDateTime.now());
    }

    //Overloaded version for testability with controlled start time.
    void startMatch(String homeTeam, String awayTeam, LocalDateTime startTime) {
        if (isTeamAlreadyPlaying(homeTeam) || isTeamAlreadyPlaying(awayTeam)) {
            throw new IllegalStateException("One or both teams are already playing.");
        }
        String key = homeTeam + "-" + awayTeam;
        matches.put(key, new Match(homeTeam, awayTeam, startTime));
    }

    //Updating the score
    void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Match match = getMatch(homeTeam, awayTeam);
        match.updateScore(homeScore, awayScore);
    }

    //End Match
    void finishMatch(String homeTeam, String awayTeam) {
        String key = homeTeam + "-" + awayTeam;
        if (!matches.containsKey(key)) {
            throw new NoSuchElementException("Match not found.");
        }
        matches.remove(key);
    }

    //Get the summary of ongoing matches
    List<String> getSummary() {
        return matches.values().stream()
                .sorted(Comparator.comparingInt(Match::getTotalScore)
                        .thenComparing(Match::getStartTime).reversed())
                .map(Match::getSummary)
                .collect(Collectors.toList());
    }

    Match getMatch(String homeTeam, String awayTeam) {
        String key = homeTeam + "-" + awayTeam;
        if (!matches.containsKey(key)) {
            throw new NoSuchElementException("Match not found.");
        }
        return matches.get(key);
    }

    boolean isTeamAlreadyPlaying(String team) {
        if (matches.values().stream().anyMatch(m -> m.getHomeTeam().equals(team))
                || matches.values().stream().anyMatch(m -> m.getAwayTeam().equals(team))) {
            return true;
        } else {
            return false;
        }

    }
}
