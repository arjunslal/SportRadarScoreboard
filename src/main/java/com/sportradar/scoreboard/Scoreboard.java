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
}
