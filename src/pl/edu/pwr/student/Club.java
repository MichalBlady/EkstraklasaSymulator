package pl.edu.pwr.student;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Club {
    private String nameOfTheClub;
    private List<Player> players = new ArrayList<Player>();

    public Club(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
        readPlayers();
    }

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

private void readPlayers(){
        Scanner in;
        try {
            in=new Scanner(new File("src/pl/edu/pwr/student/clubs/"+nameOfTheClub+".txt"));
            while(in.hasNext()){
                String line = in.nextLine();
                String[] text = line.split(",");
                String nameOfThePlayer = text[0];
                String nameOfTheClub = text[1];
                String pos = text[2];
                Position position = Position.MID;
                switch (pos){
                    case "GK" :
                        position = Position.GK;
                        break;
                    case "DEF" :
                        position = Position.DEF;
                        break;
                    case "MID" :
                        position = Position.MID;
                        break;
                    case "AT" :
                        position = Position.AT;
                        break;
                }
                int rating = Integer.parseInt(text[3]);
                players.add(new Player(nameOfThePlayer, nameOfTheClub, position, rating));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
}


}
