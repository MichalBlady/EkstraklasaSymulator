package pl.edu.pwr.student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team {


    public static List<String> readTeams(){
        List<String> teams = new ArrayList<String>();
        Scanner in;
        try {
            in=new Scanner(new File("src/pl/edu/pwr/student/table"));
            while(in.hasNext()){
                String line = in.nextLine();
                String nameOfTheClub = line;

                teams.add(new String(nameOfTheClub));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return teams;
    }

    public static String yourTeamChosing(List<String> teams){
        String yourClubName;
        Scanner scanner=new Scanner(System.in);

        for(int i=0; i<teams.size();i++){
            System.out.println((i+1)+"."+teams.get(i));
        }
        System.out.println("Podaj nazwę swojego klubu (numer od 1 do 18): ");
        int nr = scanner.nextInt();
        yourClubName=(teams.get(nr-1));
        //System.out.println("Twój klub to "+yourClubName);
        return yourClubName;
    }

    public static List<Player> yourSquadChosing(String yourClubName){
        Club club = new Club(yourClubName);
        List<Player> yourPlayers = club.getPlayers();
        List<Player> yourSquad = new ArrayList<Player>();
        Scanner scanner = new Scanner(System.in);

        Squad squad = new Squad(yourPlayers);
        squad.dividePlayers(yourPlayers);
        for(int i=0;i< squad.getLengthGk();i++){
            System.out.println(i+1+"."+squad.goalkeepers.get(i).getName()+" - "+squad.goalkeepers.get(i).getRating());
        }
        System.out.println("Podaj nr bramkarza: ");
        int nrGk= scanner.nextInt();
    yourSquad.add(squad.goalkeepers.get(nrGk-1));


        System.out.println("Podaj ilu obrońców dodasz do składu(od 3 do 5): ");
        int howManyDef= scanner.nextInt();
        int kDef=0;
        for(int j=0;j<howManyDef;j++) {

            for(int i=0;i< squad.getLengthDef()-kDef;i++){
                System.out.println((i+1)+"."+squad.defenders.get(i).getName()+" - "+squad.defenders.get(i).getRating());
            }
            System.out.println("Podaj nr "+(j+1)+"-ego obrońcy: ");
            int nr = scanner.nextInt();
            yourSquad.add(squad.defenders.get(nr-1));
            squad.defenders.remove(squad.defenders.get(nr-1));
            kDef++;
        }

        System.out.println("Podaj ilu napastników dodasz do składu(od 1 do 3): ");
        int howManyAt= scanner.nextInt();
        int kAt=0;
        for(int j=0;j<howManyAt;j++) {

            for(int i=0;i< squad.getLengthAt()-kAt;i++){
                System.out.println((i+1)+"."+squad.attackers.get(i).getName()+" - "+squad.attackers.get(i).getRating());
            }
            System.out.println("Podaj nr "+(j+1)+"-ego napastnika: ");
            int nr = scanner.nextInt();
            yourSquad.add(squad.attackers.get(nr-1));
            squad.attackers.remove(squad.attackers.get(nr-1));
            kAt++;
        }
        int howManyMid = 10-howManyDef-howManyAt;
        System.out.println("Wybierz "+howManyMid+" pomocników do składu:");

        int kMid=0;
        for(int j=0;j<howManyMid;j++) {

            for(int i=0;i< squad.getLengthMid()-kMid;i++){
                System.out.println((i+1)+"."+squad.midfielders.get(i).getName()+" - "+squad.midfielders.get(i).getRating());
            }
            System.out.println("Podaj nr "+(j+1)+"-ego pomocnika: ");
            int nr = scanner.nextInt();
            yourSquad.add(squad.midfielders.get(nr-1));
            squad.midfielders.remove(squad.midfielders.get(nr-1));
            kMid++;
        }

        return yourSquad;
    }




}
