/*
* Author : Neev Umeshkumar Shah
* ASURITE I'd : nshah83
* ASU I'd : 1226570932
* */

public class Urinals {

    public boolean isGoodString(String string){
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

    public int countUrinals(String string){
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

    }
}
