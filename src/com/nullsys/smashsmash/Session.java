package com.nullsys.smashsmash;

/**
 * Model class holding all data related to a single game session.
 */
public class Session {

    public float stageSecondsDuration = 30f;
    public float stageSecondsElapsed = 0;

    public float combosLastDelta = 0;
    public int combosCurrent = 0;
    public int combosMax = 0;
    public int combosTotal = 0;

    public int lifePoints = 3;
    public int score = 0;
    public int smashedAliens = 0;
}