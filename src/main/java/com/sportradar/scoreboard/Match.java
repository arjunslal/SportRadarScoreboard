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

    /**
     * Default constructor using current time.
     */
    public Match(String homeTeam, String awayTeam) {
    }

    /**
     * Constructor allowing custom start time (useful for testing).
     */
    public Match(String homeTeam, String awayTeam, LocalDateTime startTime) {

    }
}
