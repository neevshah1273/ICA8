/*
* Author : Neev Umeshkumar Shah
* ASURITE I'd : nshah83
* ASU I'd : 1226570932
* */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Urinals {

    public static Map<String, Integer> fileNameCounter = new HashMap<>();

    private static final String NEW_LINE = System.lineSeparator();

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

    public static FileReader readFile(String filepath) throws FileNotFoundException {
        return new FileReader(filepath);
    }

    public static List<String> parseFile(FileReader fileReader) throws IOException {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while (!(line = br.readLine()).equals("EOF")) {
                stringList.add(line);
            }
        }
        return stringList;
    }

    public static boolean writeFileIn(String fileName, List<Integer> ansList) throws IOException {
        fileNameCounter.put(fileName, fileNameCounter.getOrDefault(fileName, -1)+1);
        while (isDuplicate("src/main/resources/"+ fileName.substring(0,fileName.length()-4) + fileNameCounter.get(fileName)+".txt")){
            fileNameCounter.put(fileName, fileNameCounter.getOrDefault(fileName, -1)+1);
        }
        Path path = Paths.get("src/main/resources/"+ fileName.substring(0,fileName.length()-4) + fileNameCounter.get(fileName)+".txt");
        StringBuilder ansString = new StringBuilder();
        for (Integer integer : ansList) {
            ansString.append(integer.toString());
            ansString.append(NEW_LINE);
        }
        writeFile(path, ansString.toString());
        return true;
    }

    private static void writeFile(Path path, String content)
            throws IOException {
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
    }

    public static Boolean isDuplicate(String pathname){
        File f = new File(pathname);
        if(f.exists() && !f.isDirectory()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello! How would you like to test");
        System.out.println("1. Input File");
        System.out.println("2. Interactive Console");
        Scanner scanner = new Scanner(System.in);
        String inputChoice = scanner.nextLine();
        if(inputChoice.equals("1")){
            System.out.println("Enter your File in src->main->resources & Enter FileName");
            String filepath = scanner.nextLine();
            try {
                FileReader fileReader = readFile("src/main/resources/"+filepath);
                List<String> inputStrings = parseFile(fileReader);
                List<Integer> answerList = new ArrayList<>();
                for (String inputString : inputStrings) {
                    answerList.add(countUrinals(inputString));
                }
                boolean success = writeFileIn(filepath, answerList);
                if (success){
                    System.out.println("File Created successfully");
                }
                else {
                    System.out.println("Eh, Some Error Occurred");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(inputChoice.equals("2")){
            System.out.println("Enter a String");
            String string = scanner.nextLine();
            int urinalCount = countUrinals(string);
            System.out.println(urinalCount);
        }
    }
}
