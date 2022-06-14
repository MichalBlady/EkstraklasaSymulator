package pl.edu.pwr.student;

import java.util.ArrayList;
import java.util.List;

public class Clubs {
    private static List<Club> clubs = new ArrayList<>();
    public static void add(Club club){
        clubs.add(club);

    }
    public static Club get(String club){
        for(int i=0; i< clubs.size();i++){
            if(club.equals(clubs.get(i).getNameOfTheClub())){
                return clubs.get(i);
            }
        }
        return null;
    }
    public static Club get(int i){
        return clubs.get(i);
    }
}
