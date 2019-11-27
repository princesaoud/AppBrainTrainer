package com.example.appbraintrainer;

public class Game_profile {
    private int total;
    private int score;
    private int solution;

    public Game_profile(int total, int score, int solution) {
        this.total = total;
        this.score = score;
        this.solution = solution;
    }

    public Game_profile() {
        this.total = 0;
        this.score = 0;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total += total;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }
}
