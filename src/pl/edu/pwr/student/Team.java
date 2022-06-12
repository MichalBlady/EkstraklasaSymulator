package pl.edu.pwr.student;

public class Team {
    private String nameOfTheClub;
    private int points=0;
    private int scoredGoals=0;
    private int lostGoals=0;
    private int balanceOfGoals=scoredGoals-lostGoals;

    public Team(String nameOfTheClub, int points, int scoredGoals, int lostGoals, int balanceOfGoals) {
        this.nameOfTheClub = nameOfTheClub;
        this.points = points;
        this.scoredGoals = scoredGoals;
        this.lostGoals = lostGoals;
        this.balanceOfGoals = balanceOfGoals;
    }

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public int getPoints() {
        return points;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public int getLostGoals() {
        return lostGoals;
    }

    public int getBalanceOfGoals() {
        return balanceOfGoals;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLostGoals(int lostGoals) {
        this.lostGoals = lostGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public void setBalanceOfGoals(int balanceOfGoals) {
        this.balanceOfGoals = balanceOfGoals;
    }
}
