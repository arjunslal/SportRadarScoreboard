/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sportradar.scoreboard;

/**
 * Test class for the Scoreboard system using JUnit 5.
 */
import org.junit.Before;
import org.junit.Test;

public class ScoreboardTest {

    //Initialize tests
    @Before
    public void init() {
    }
    //Basic Testcases

    //Test that a match can be started
    @Test
    public void testStartMatch() {
    }

    //Test that score can be updated
    @Test
    public void testUpdateScore() {
    }

    //Test that a match can be ended
    @Test
    public void testFinishMatch() {
    }

    //Test that a the scores are sorted in descending order and that the most recent match will be higher in the order if the total score is the same
    @Test
    public void testSummaryOrdering() {

    }

    //Corner/edge cases (paranoia fuel)
    //Test that startMatch()cannot be called on an existing match 
    @Test
    public void testStartDuplicateMatchThrows() {
    }

    //Test that a match has to exist before updating the scores
    @Test
    public void testUpdateNonExistentMatchThrows() {
    }
    //Test that a match has to exist before finishing

    @Test
    public void testFinishNonExistentMatchThrows() {
    }

    //Test in case of tied score(total), that the recently started one will be higher up(TODO: redundant?)
    @Test
    public void testTiedScoresAreOrderedByRecentStartTime() {
    }

    //Test that a team cannot play itself
    @Test
    public void testSameTeamNamesThrowsException() {
    }

    //Test that a match cannot be started with a team that is already in a match
    @Test
    public void testTeamCannotBeInTwoMatches() {
    }
}
