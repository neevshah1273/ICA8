import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UrinalsTest {


    @Test
    public void isGoodStringTest(){
        String s1 = "10101001";
        String s2 = "001101110";
        String s3 = "aab";
        assertTrue(Urinals.isGoodString(s1));
        assertFalse(Urinals.isGoodString(s2));
        assertFalse(Urinals.isGoodString(s3));
        System.out.println("====== Neev Umeshkumar Shah == TEST ONE EXECUTED =======");
    }


    @Test
    public void countUrinalsTest(){
        String s1 = "10101001";
        String s2 = "001101110";
        assertEquals(0, Urinals.countUrinals(s1));
        assertEquals(-1, Urinals.countUrinals(s2));
        System.out.println("====== Neev Umeshkumar Shah == TEST TWO EXECUTED =======");
    }

    @Test()
    public void ReadFileTest_FileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> Urinals.readFile("src/test/resources/test.txt"));
        System.out.println("====== Neev Umeshkumar Shah == TEST THREE EXECUTED =======");
    }

    @Test()
    public void ReadFileTest_FileFound() {
        assertDoesNotThrow(() -> Urinals.readFile("src/test/resources/test1.txt"));
        System.out.println("====== Neev Umeshkumar Shah == TEST FOUR EXECUTED =======");
    }

    @Test
    public void IsEmptyFile() {
        assertThrows(Exception.class, ()-> Urinals.parseFile(Urinals.readFile("src/test/resources/empty.txt")));
        System.out.println("====== Neev Umeshkumar Shah == TEST FIVE EXECUTED =======");
    }

    @Test
    public void IsDuplicateFileName(){
        assertTrue(Urinals.isDuplicate("src/main/resources/test1.txt"));
    }

    @Test
    public void createFileTest() throws IOException {
        List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(4);
        assertTrue(Urinals.writeFileIn("newFile.txt", array));
        System.out.println("====== Neev Umeshkumar Shah == TEST FIVE EXECUTED =======");
    }

}
