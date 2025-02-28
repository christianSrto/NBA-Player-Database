-- CREATE TABLE Players (
--     playerID INTEGER PRIMARY KEY AUTOINCREMENT,
--     playerName TEXT NOT NULL,
--     position TEXT NOT NULL,
--     height REAL NOT NULL,
--     weight REAL NOT NULL,
--     teamID INTEGER,
--     UNIQUE(playerName)  
-- );

-- CREATE TABLE Teams (
--     teamID INTEGER PRIMARY KEY AUTOINCREMENT,
--     teamName TEXT NOT NULL,
--     city TEXT NOT NULL,
--     UNIQUE(teamName) 
-- );

-- CREATE TABLE PlayerStats (
--     statID INTEGER PRIMARY KEY AUTOINCREMENT,
--     playerID INTEGER NOT NULL,
--     seasonYear INTEGER NOT NULL,
--     gamesPlayed INTEGER NOT NULL,
--     pointsPerGame REAL NOT NULL,
--     assistsPerGame REAL NOT NULL,
--     reboundsPerGame REAL NOT NULL,
--     fieldGoalPercentage REAL NOT NULL,
--     FOREIGN KEY (playerID) REFERENCES Players(playerID)
-- );

-- CREATE TABLE Awards (
--     awardID INTEGER PRIMARY KEY AUTOINCREMENT,
--     awardName TEXT NOT NULL,
--     UNIQUE(awardName)  
-- );

-- CREATE TABLE PlayerAwards (
--     playerID INTEGER NOT NULL,
--     awardID INTEGER NOT NULL,
--     awardYear INTEGER NOT NULL,
--     PRIMARY KEY (playerID, awardID, awardYear),
--     FOREIGN KEY (playerID) REFERENCES Players(playerID),
--     FOREIGN KEY (awardID) REFERENCES Awards(awardID)
-- );

CREATE TABLE Coaches (
    coachID INTEGER PRIMARY KEY AUTOINCREMENT,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    wins INTEGER NOT NULL,
    losses INTEGER NOT NULL,
    winLossRatio REAL GENERATED ALWAYS AS (CASE WHEN losses = 0 THEN wins ELSE wins * 1.0 / losses END) STORED
);

