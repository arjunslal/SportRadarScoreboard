/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sportradar.scoreboard;

/**
 * Test class for the Scoreboard system using JUnit 5.
 */
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ScoreboardTest {

    private Scoreboard scoreboard;

    //Initialize tests
    @Before
    public void init() {
        scoreboard = new Scoreboard();

    }
    
    //Basic Testcases
    //Test that a match can be started
    @Test
    public void testStartMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        assertEquals(1, scoreboard.getSummary().size());
    }

    //Test that score can be updated
    @Test
    public void testUpdateScore() {
        scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore("Germany", "France", 2, 2);
        assertTrue(scoreboard.getSummary().contains("Germany 2 - France 2"));
    }

    //Test that a match can be ended
    @Test
    public void testFinishMatch() {
        scoreboard.startMatch("Italy", "Portugal");
        scoreboard.finishMatch("Italy", "Portugal");
        assertEquals(0, scoreboard.getSummary().size());
    }

    //Test that a the scores are sorted in descending order and that the most recent match will be higher in the order if the total score is the same
    @Test
    public void testSummaryOrdering() {

    }

    //Corner/edge cases (paranoia fuel)
    //Test that startMatch()cannot be called on an existing match 
    @Test
    public void testStartDuplicateMatchThrows() {
        scoreboard.startMatch("Spain", "Brazil");
        assertThrows(IllegalStateException.class, () -> scoreboard.startMatch("Spain", "Brazil"));
    }

    //Test that a match has to exist before updating the scores
    @Test
    public void testUpdateNonExistentMatchThrows() {
        assertThrows(NoSuchElementException.class, () -> scoreboard.updateScore("Germany", "Brazil", 1, 1));

    }

    //Test that a match has to exist before finishing
    @Test
    public void testFinishNonExistentMatchThrows() {
        assertThrows(NoSuchElementException.class, () -> scoreboard.finishMatch("Spain", "Portugal"));

    }

    //Test in case of tied score(total), that the recently started one will be higher up(TODO: redundant?)
    @Test
    public void testTiedScoresAreOrderedByRecentStartTime() {
    }

    //Test that a team cannot play itself
    @Test
    public void testSameTeamNamesThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("Argentina", "Argentina"));

    }

    //Test that a match cannot be started with a team that is already in a match
    @Test
    public void testTeamCannotBeInTwoMatches() {
        scoreboard.startMatch("Spain", "Brazil");
        assertThrows(IllegalStateException.class, () -> scoreboard.startMatch("Spain", "Germany"));
        assertThrows(IllegalStateException.class, () -> scoreboard.startMatch("France", "Brazil"));
    }
}
