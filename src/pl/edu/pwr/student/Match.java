package pl.edu.pwr.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

public class Match {
    public Match(List<Player> squad1, List<Player> squad2, int score1, int score2) {
        this.squad1 = squad1;
        this.squad2 = squad2;
        this.score1 = score1;
        this.score2 = score2;
    }

    public List<Player> getSquad1() {
        return squad1;
    }

    public List<Player> getSquad2() {
        return squad2;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    List<Player> squad1 = new ArrayList<Player>();
    List<Player> squad2 = new ArrayList<Player>();

    private int score1=0;
    private int score2=0;
    Random random = new Random();

  public void scoreSym() {

      int rand1 = random.nextInt(100);
      int rand2 = random.nextInt(100);

      if (rand1 < 25) {
          score1 = 0;
      } else if (rand1 < 50 && rand1>=25) {
          score1 = 1;
      } else if (rand1 < 70 && rand1>=50) {
          score1 = 2;
      } else if (rand1 < 80 && rand1>=70) {
          score1 = 3;
      } else if (rand1 < 85 && rand1>=80) {
          score1 = 4;
      } else if (rand1 < 89 && rand1>=85) {
          score1 = 5;
      } else if (rand1 < 92 && rand1>=89) {
          score1 = 6;
      } else if (rand1 < 95 && rand1>=92) {
          score1 = 7;
      } else if (rand1 < 98 && rand1>=95) {
          score1 = 8;
      } else if (rand1 < 99 && rand1>=98) {
          score1 = 9;
      } else if (rand1 == 99) {
          score1 = 10;
      }

      if (rand2 < 25) {
          score2 = 0;
      } else if (rand2 < 50 && rand2>=25) {
          score2 = 1;
      } else if (rand2 < 70 && rand2>=50) {
          score2 = 2;
      } else if (rand2 < 80 && rand2>=70) {
          score2 = 3;
      } else if (rand2 < 85 && rand2>=80) {
          score2 = 4;
      } else if (rand2 < 89 && rand2>=85) {
          score2 = 5;
      } else if (rand2 < 92 && rand2>=89) {
          score2 = 6;
      } else if (rand2 < 95 && rand2>=92) {
          score2 = 7;
      } else if (rand2 < 98 && rand2>=95) {
          score2 = 8;
      } else if (rand2 < 99 && rand2>=98) {
          score2 = 9;
      } else if (rand2 == 99) {
          score2 = 10;
      }
  }


private int o1=0;
private int o2=0;
private int overall1=o1/11;
private int overall2=o2/11;
public void overallGetting() {
    for (int i = 0; i < 11; i++) {
        o1 = o1 + squad1.get(i).getRating();
        o2 = o2 + squad2.get(i).getRating();
    }
}

public void winnerChosing(){
    int r=abs(overall1-overall2);
    int drawChance = 50 - r*5;
    int loseChance = (100-drawChance)/(r+2);
    int winChance = 100-drawChance-loseChance;

    int result = random.nextInt(100);

    if(result<drawChance){
        score1=min(score1,score2);
        score2=min(score1,score2);
    }else if(result>=drawChance&&result<drawChance+loseChance){
        score1=min(score1,score2);
        score2=max(score1,score2);
    }else {
        score1=max(score1,score2);
        score2=min(score1,score2);
    }


}

    public void goalScorerChosing(){
       List<Player>goalkeepers1 = new ArrayList<Player>();
       List<Player>defenders1 = new ArrayList<Player>();
       List<Player>midfielders1 = new ArrayList<Player>();
       List<Player>attackers1 = new ArrayList<Player>();

        List<Player>goalkeepers2 = new ArrayList<Player>();
        List<Player>defenders2 = new ArrayList<Player>();
        List<Player>midfielders2 = new ArrayList<Player>();
        List<Player>attackers2 = new ArrayList<Player>();

        for (int i = 0; i < 11; i++) {
            Position position = squad1.get(i).getPosition();
            if (position.equals("GK")) {
                goalkeepers1.add(squad1.get(i));
            } else if (position.equals("DEF")) {
                defenders1.add(squad1.get(i));
            }else if (position.equals("MID")) {
                midfielders1.add(squad1.get(i));
            }else if (position.equals("AT")) {
                attackers1.add(squad1.get(i));
            }
        }
        for (int i = 0; i < 11; i++) {
            Position position = squad2.get(i).getPosition();
            if (position.equals("GK")) {
                goalkeepers2.add(squad2.get(i));
            } else if (position.equals("DEF")) {
                defenders2.add(squad2.get(i));
            }else if (position.equals("MID")) {
                midfielders2.add(squad2.get(i));
            }else if (position.equals("AT")) {
                attackers2.add(squad2.get(i));
            }
        }
        for(int i=0; i<score1; i++){
            int whichPosition = random.nextInt(100);
            int nr=0;
            if(whichPosition<60) {
                nr=random.nextInt(attackers1.size());
                attackers1.get(nr).setGoalsOfThePlayer(attackers1.get(nr).getGoalsOfThePlayer() + 1);
            }else if(whichPosition>=60 && whichPosition<90){
                nr=random.nextInt(midfielders1.size());
                midfielders1.get(nr).setGoalsOfThePlayer(midfielders1.get(nr).getGoalsOfThePlayer() + 1);
            }else if(whichPosition>=90 && whichPosition<99){
                nr=random.nextInt(defenders1.size());
                defenders1.get(nr).setGoalsOfThePlayer(defenders1.get(nr).getGoalsOfThePlayer() + 1);
            }else{
                goalkeepers1.get(0).setGoalsOfThePlayer(goalkeepers1.get(0).getGoalsOfThePlayer() + 1);
            }
        }

        for(int i=0; i<score2; i++){
            int whichPosition = random.nextInt(100);
            int nr=0;
            if(whichPosition<60) {
                nr=random.nextInt(attackers2.size());
                attackers2.get(nr).setGoalsOfThePlayer(attackers2.get(nr).getGoalsOfThePlayer() + 1);
            }else if(whichPosition>=60 && whichPosition<90){
                nr=random.nextInt(midfielders2.size());
                midfielders2.get(nr).setGoalsOfThePlayer(midfielders2.get(nr).getGoalsOfThePlayer() + 1);
            }else if(whichPosition>=90 && whichPosition<99){
                nr=random.nextInt(defenders2.size());
                defenders2.get(nr).setGoalsOfThePlayer(defenders2.get(nr).getGoalsOfThePlayer() + 1);
            }else{
                goalkeepers2.get(0).setGoalsOfThePlayer(goalkeepers2.get(0).getGoalsOfThePlayer() + 1);
            }
        }

    }

}
