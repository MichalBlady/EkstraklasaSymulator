package pl.edu.pwr.student;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Symulator Ekstraklasa 2021/2022");
        List<Player> scorers;
        List<Player>finalScorers = new ArrayList<>();
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

                    scorers=(match.match());
                    boolean adding = true;
                   if(scorers.size()!=0) {
                       if (finalScorers.size() == 0) {
                           finalScorers.add(scorers.get(0));
                           for (int l = 1; l < scorers.size(); l++) {

                                       finalScorers.add(scorers.get(l));

                           }
                       } else {
                           for (int l = 0; l < scorers.size(); l++) {
                               for (int k = 0; k < finalScorers.size(); k++) {
                                   if (finalScorers.get(k).equals(scorers.get(l))) {
                                       adding = false;
                                   }
                               }
                               if(adding == true) {
                                   finalScorers.add(scorers.get(l));
                               }
                           }
                       }
                   }



                }


                }

        }
List<Club> allClubs =new ArrayList<>();
        for(int i=0;i<18;i++){
            allClubs.add(Clubs.get(i));
        }


        List<Player> sortedscorers = finalScorers.stream()
                .sorted(Comparator.comparing(Player::getGoalsOfThePlayer).reversed())
                .collect(Collectors.toList());

        List<Club> sortedClubs = allClubs.stream()
                .sorted(Comparator.comparing(Club::getPoints).reversed())
                .collect(Collectors.toList());

        System.out.println("Tabela strzelców:");
        System.out.println("|Lp.|        Zawodnik        | l.goli |");
        for(int i=0;i< 10;i++) {
            System.out.format("|%3d|%24s|%8d|\n",i+1,sortedscorers.get(i).getName(),sortedscorers.get(i).getGoalsOfThePlayer());
        }


        System.out.println("Tabela wyników:");
        System.out.println("|Lp|         Nazwa klubu          | punkty | sg | lg | bg |");
        for(int i=0;i<18;i++){
            System.out.format("|%2d|%30s|%8d|%4d|%4d|%4d|\n",i+1,sortedClubs.get(i).getNameOfTheClub(),sortedClubs.get(i).getPoints(),sortedClubs.get(i).getScoredGoals(),sortedClubs.get(i).getLostGoals(),sortedClubs.get(i).getBalanceOfGoals());


        }

    }

}
