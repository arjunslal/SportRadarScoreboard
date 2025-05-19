# Scoreboard

This Java library implements a live football scoreboard system that tracks matches, updates scores, and provides a sorted summary of ongoing games.

---

## Features

-  Start new matches with 0-0 score
-  Update the score of an ongoing match
-  Finish a match and remove it from the scoreboard
-  Retrieve a summary of all matches in progress
-  Non-persistent, Everything runs in memory
-  Matches in the summary are ordered by:
  1. Total score (descending)
  2. If scores are equal, by the most recently started match

---
## Test-Driven Development

This project was written using TDD from the start. The test suite ensures:

- 100% test coverage
- Sorting logic behaves correctly even under score and time conflicts
- General Test cases:
  1. testStartMatch()
  2. testUpdateScore()
  3. testFinishMatch()
  4. testSummaryOrdering()
 
- Edge test cases:
  1. testStartDuplicateMatchThrows()
  2. testSameTeamNamesThrowsException()
  3. testTiedScoresAreOrderedByRecentStartTime()
  4. testUpdateNonExistentMatchThrows()
  5. testFinishNonxistentMatchThrows()
  6. testTeamCannotBeInTwoMatches()
     
---
## Project Structure

```
src/
 └── main/
     └── java/
         └── com/sportradar/scoreboard/
             ├── Match.java
             └── Scoreboard.java
 └── test/
     └── java/
         └── com/sportradar/scoreboard/
             └── ScoreboardTest.java
```

---
## Design Highlights

- **Single Responsibility**: Each class has a focused responsibility
- **Open/Closed Principle**: Easy to extend scoring or sorting rules
- **Deterministic Testing**: Injects `startTime` to ensure predictable sorting
  
---

##  Sorting Rules in Summary

1. Matches with **higher total scores** appear first
2. If multiple matches have the same score, the **most recently started** one appears first

**Example:**

```
Uruguay 6 - Italy 6   ← started more recently
Spain 10 - Brazil 2   ← same score, but started earlier
```

## How to Run

### Using IntelliJ/Netbeans or Eclipse
1. Open the project
2. Add JUnit 5 library to the classpath
3. Run tests in `ScoreboardTest.java`

---

## 🗒️ Assumptions made

- Team names are unique per match
- One match per team at a time
- Two matches do not start at the exact same time and progress with the exact same total score (can be handled by adding more granularity to the parameters, but seems like overkill)
- Match start time is captured or injected (for testability)

---
