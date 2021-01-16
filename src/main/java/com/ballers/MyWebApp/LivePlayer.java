package com.ballers.MyWebApp;

public class LivePlayer {
    private int age;
    private int assists;
    private int attempted_field_goals;
    private int attempted_free_throws;
    private int attempted_three_point_field_goals;
    private int blocks;
    private int defensive_rebounds;
    private int games_played;
    private int games_started;
    private int made_field_goals;
    private int made_free_throws;
    private int made_three_point_field_goals;
    private int minutes_played;
    private String name;
    private int offensive_rebounds;
    private int personal_fouls;
    private int points;
    private String[] positions;
    private String slug;
    private int steals;
    private String team;
    private int turnovers;

    LivePlayer() {
        this.age = 0;
        this.assists = 0;
        this.attempted_field_goals = 0;
        this.attempted_free_throws = 0;
        this.attempted_three_point_field_goals = 0;
        this.blocks = 0;
        this.defensive_rebounds = 0;
        this.games_played = 0;
        this.games_started = 0;
        this.made_field_goals = 0;
        this.made_free_throws = 0;
        this.made_three_point_field_goals = 0;
        this.minutes_played = 0;
        this.name = "";
        this.offensive_rebounds = 0;
        this.personal_fouls = 0;
        this.points = 0;
        this.positions = null;
        this.slug = "";
        this.steals = 0;
        this.team = "";
        this.turnovers = 0;
    }
    LivePlayer(int age, int assists, int attempted_field_goals, int attempted_free_throws, int attempted_three_point_field_goals,
            int blocks, int defensive_rebounds, int games_played, int games_started, int made_field_goals,
            int made_free_throws, int made_three_point_field_goals, int minutes_played, String name, int offensive_rebounds,
            int personal_fouls, int points, String[] positions, String slug, int steals, String team, int turnovers) {
        this.age = age;
        this.assists = assists;
        this.attempted_field_goals = attempted_field_goals;
        this.attempted_free_throws = attempted_free_throws;
        this.attempted_three_point_field_goals = attempted_three_point_field_goals;
        this.blocks = blocks;
        this.defensive_rebounds = defensive_rebounds;
        this.games_played = games_played;
        this.games_started = games_started;
        this.made_field_goals = made_field_goals;
        this.made_free_throws = made_free_throws;
        this.made_three_point_field_goals = made_three_point_field_goals;
        this.minutes_played = minutes_played;
        this.name = name;
        this.offensive_rebounds = offensive_rebounds;
        this.personal_fouls = personal_fouls;
        this.points = points;
        this.positions = positions;
        this.slug = slug;
        this.steals = steals;
        this.team = team;
        this.turnovers = turnovers;
    }

    public int getAge() {
        return age;
    }
    public int getAssists() {
        return assists;
    }
    public int getAttempted_field_goals() {
        return attempted_field_goals;
    }
    public int getAttempted_free_throws() {
        return attempted_free_throws;
    }
    public int getAttempted_three_point_field_goals() {
        return attempted_three_point_field_goals;
    }
    public int getBlocks() {
        return blocks;
    }
    public int getDefensive_rebounds() {
        return defensive_rebounds;
    }
    public int getGames_played() {
        return games_played;
    }
    public int getGames_started() {
        return games_started;
    }
    public int getMade_field_goals() {
        return made_field_goals;
    }
    public int getMade_free_throws() {
        return made_free_throws;
    }
    public int getMade_three_point_field_goals() {
        return made_three_point_field_goals;
    }
    public int getMinutes_played() {
        return minutes_played;
    }
    public String getName() {
        return name;
    }
    public int getOffensive_rebounds() {
        return offensive_rebounds;
    }
    public int getPersonal_fouls() {
        return personal_fouls;
    }
    public int getPoints() {
        return points;
    }
    public String[] getPositions() {
        return positions;
    }
    public String getSlug() {
        return slug;
    }
    public int getSteals() {
        return steals;
    }
    public String getTeam() {
        return team;
    }
    public int getTurnovers() {
        return turnovers;
    }
}
