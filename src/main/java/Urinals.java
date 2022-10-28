/*
* Author : Neev Umeshkumar Shah
* ASURITE I'd : nshah83
* ASU I'd : 1226570932
* */

import java.util.Scanner;

public class Urinals {

    public static boolean isGoodString(String string){
        if(string.charAt(string.length()-1)>'1' || string.charAt(string.length()-1)<'0')return false;
        for (int i = 0; i < string.length()-1; i++) {
            if(string.charAt(i)>'1' || string.charAt(i)<'0'){
                System.out.println(string.charAt(i));
                return false;
            }
            if(string.charAt(i)=='1' && string.charAt(i+1)=='1'){
                return false;
            }
        }
        return true;
    }

    public static int countUrinals(String string){
        int count = 0;
        if(isGoodString(string)){
            for(int i=0;i<string.length();i++){
                if(string.charAt(i)=='0' && i==string.length()-1 ){
                    count++;
                }
                else if(i<string.length()-1 && string.charAt(i)=='0' && string.charAt(i+1)=='0'){
                    count++;
                    i++;
                }
                else if(string.charAt(i)=='1'){
                    i++;
                }
            }
            return count;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("Hello! How would you like to test");
        System.out.println("1. Input File");
        System.out.println("2. Interactive Console");
        Scanner scanner = new Scanner(System.in);
        String inputChoice = scanner.nextLine();
        if(inputChoice.equals("1")){

        }
        else if(inputChoice.equals("2")){
            System.out.println("Enter a String");
            String string = scanner.nextLine();
            Integer urinalCount = countUrinals(string);
            System.out.println(urinalCount.toString());
        }
    }
}
