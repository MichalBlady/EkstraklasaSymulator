package pl.edu.pwr.student;

public class Player {
    private final String name;
    private final String club;
    private Position position;
    private final int rating;
    private int goalsOfThePlayer;

    public Player(String name, String club, Position position, int rating) {
        this.name = name;
        this.club = club;
        this.position = position;
        this.rating = rating;
        this.goalsOfThePlayer = 0;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public Position getPosition() {
        return position;
    }

    public int getRating() {
        return rating;
    }

    public int getGoalsOfThePlayer() {
        return goalsOfThePlayer;
    }

    public void setGoalsOfThePlayer(int goalsOfThePlayer) {
        this.goalsOfThePlayer = goalsOfThePlayer;
    }
}