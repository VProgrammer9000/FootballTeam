package ch.bzz.footballTeam.util;

import java.time.LocalDate;

/**
 * Converter for Programm FootballTeam
 */
public class Converter {
    /**
     * Converts a Sting to a LocalDate
     * @param date to convert
     * @return date as LocalDate
     */
    public static LocalDate stringToLocalDate(String date){
        String[] array=new String[3];
        int counter=0;
        for (int i = 0; i < array.length; i++) {
            array[i]="";
            while (date.charAt(counter)!='-'){
                array[i]+=date.charAt(counter);
                counter++;
                if (date.length()<=counter){
                   break;
                }
            }
            counter++;
        }
        int year=Integer.parseInt(array[0]);
        int month=Integer.parseInt(array[1]);
        int day=Integer.parseInt(array[2]);
        return LocalDate.of(year,month,day);
    }
}
