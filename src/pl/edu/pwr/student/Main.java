package pl.edu.pwr.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Symulator Ekstraklasa 2021/2022");
        List<Club> tab = new ArrayList<>();
        List<Player> scorers = new ArrayList<>();
        List<String> teams = Team.readTeams();
        for (int i = 0; i < 18; i++) {
            Club club = new Club(teams.get(i));
            Clubs.add(club);

        }
        String yourClubName = Team.yourTeamChosing(teams);
        List<Player> yourSquad = Team.yourSquadChosing(yourClubName);
        Club club = new Club(yourClubName);

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 18; j++) {
                if (j != i) {
                    List<Player> squad1, squad2;
                    if (!Clubs.get(i).getNameOfTheClub().equals(yourClubName)) {
                        Squad squad = new Squad(Clubs.get(i).getPlayers());

                        squad.squadChosing();
                        squad1 = squad.getSquad();
                    } else {
                        squad1 = yourSquad;
                    }
                    if (!Clubs.get(j).getNameOfTheClub().equals(yourClubName)) {
                        Squad squad = new Squad(Clubs.get(j).getPlayers());
                        squad.squadChosing();
                        squad2 = squad.getSquad();
                    } else {
                        squad2 = yourSquad;
                    }

                    Match match = new Match(squad1, squad2);

                    match.match();

                    //tab.get(i).points = tab.get(i).points+ club.getPoints(match.winnerChosing());



                }


                }
            }
        System.out.println(tab.get(1).points);
        /*
TO DO:
1.wypisanie tabel drużyn i strzelców z sortowaniem
2.gradle
*/

    }

}
