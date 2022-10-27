/*
* Author : Neev Umeshkumar Shah
* ASURITE I'd : nshah83
* ASU I'd : 1226570932
* */

public class Urinals {

    public boolean isGoodString(String string){
        for (int i = 0; i < string.length()-1; i++) {
            if(string.charAt(i)=='1' && string.charAt(i+1)=='1'){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
