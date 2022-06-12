package pl.edu.pwr.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Squad {
    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public Squad(List<Player> players) {
        this.players = players;
        lengthOfPlayers= players.size();
    }

    private String nameOfTheClub;


    private List<Player> squad = new ArrayList<Player>();
    private List<Player> players = new ArrayList<Player>();

    private List<Player> goalkeepers = new ArrayList<Player>();
    private List<Player> defenders = new ArrayList<Player>();
    private List<Player> midfielders = new ArrayList<Player>();
    private List<Player> attackers = new ArrayList<Player>();

    private int lengthOfPlayers;

    private int lengthGk;
    private int lengthDef;
    private int lengthMid;
    private int lengthAt;

    public List<Player> getPlayers() {
        return players;
    }



    public void dividePlayers() {
        goalkeepers = new ArrayList<Player>();
        defenders = new ArrayList<Player>();
        midfielders = new ArrayList<Player>();
        attackers = new ArrayList<Player>();

        for (int i = 0; i < lengthOfPlayers; i++) {
Position position = players.get(i).getPosition();
            if (position.equals("GK")) {
                goalkeepers.add(players.get(i));
            } else if (position.equals("DEF")) {
                defenders.add(players.get(i));
            }else if (position.equals("MID")) {
                midfielders.add(players.get(i));
            }else if (position.equals("AT")) {
                attackers.add(players.get(i));
            }
        }
        lengthGk = goalkeepers.size();
        lengthDef = defenders.size();
        lengthMid = midfielders.size();
        lengthAt = attackers.size();
    }

        public int getLengthGk () {
            return lengthGk;
        }

        public void setLengthGk ( int lengthGk){
            this.lengthGk = lengthGk;
        }

        public int getLengthAt () {
            return lengthAt;
        }

        public void setLengthAt ( int lengthAt){
            this.lengthAt = lengthAt;
        }

        public int getLengthMid () {
            return lengthMid;
        }

        public void setLengthMid ( int lengthMid){
            this.lengthMid = lengthMid;
        }

        public int getLengthDef () {
            return lengthDef;
        }

        public void setLengthDef ( int lengthDef){
            this.lengthDef = lengthDef;
        }

        public void squadChosing() {
            squad=new ArrayList<>();
            dividePlayers();
            Random random = new Random();

            int howManyDef = random.nextInt(3, 5);
            int howManyMid = random.nextInt(3, 8 - howManyDef);
            int howManyAt = random.nextInt(1, 10 - howManyDef - howManyMid);

            int nrGk;
            int nrDef;
            int nrMid;
            int nrAt;


                nrGk = random.nextInt(lengthGk);
                squad.add(goalkeepers.remove(nrGk));

            for (int i = 0; i < howManyDef; i++) {
                nrDef = random.nextInt(lengthDef);
                squad.add(defenders.remove(nrDef));
                lengthDef--;
            }

            for (int i = 0; i < howManyMid; i++) {
                nrMid = random.nextInt(lengthMid);
                squad.add(midfielders.remove(nrMid));
                lengthMid--;
            }

            for (int i = 0; i < howManyAt; i++) {
                nrAt = random.nextInt(lengthAt);
                squad.add(attackers.remove(nrAt));
                lengthAt--;
            }
        }


    }
