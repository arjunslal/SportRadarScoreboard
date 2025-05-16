/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sportradar.scoreboard;

import java.time.LocalDateTime;

/**
 * Represents a football match between two teams.
 */
public class Match {

    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final LocalDateTime startTime;

    /**
     * Default constructor using current time.
     */
    public Match(String homeTeam, String awayTeam) {
        this(homeTeam, awayTeam, LocalDateTime.now());
    }

    /**
     * Constructor allowing custom start time (useful for testing).
     */
    public Match(String homeTeam, String awayTeam, LocalDateTime startTime) {
        if (homeTeam == null || awayTeam == null || homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("Invalid or duplicate team names.");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = startTime;
    }

    //Basic Getters
    String getHomeTeam() {
        return homeTeam;
    }

    String getAwayTeam() {
        return awayTeam;
    }

    int getHomeScore() {
        return homeScore;
    }

    int getAwayScore() {
        return awayScore;
    }

    int getTotalScore() {
        return homeScore + awayScore;
    }

    LocalDateTime getStartTime() {
        return startTime;
    }

    //Get the summary of a match
    String getSummary() {
        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }

    //Update the score of an ongoing match
    void updateScore(int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Score values cannot be negative.");
        }
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
