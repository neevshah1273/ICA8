import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;


public class UrinalsTest {


    @Test
    public void isGoodStringTest(){
        String s1 = "10101001";
        String s2 = "001101110";
        String s3 = "aab";
        Urinals urinals = new Urinals();
        assertTrue(urinals.isGoodString(s1));
        assertFalse(urinals.isGoodString(s2));
        assertFalse(urinals.isGoodString(s3));
        System.out.println("====== Neev Umeshkumar Shah == TEST ONE EXECUTED =======");
    }


    @Test
    public void countUrinalsTest(){
        String s1 = "10101001";
        String s2 = "001101110";
        Urinals urinals = new Urinals();
        assertEquals(0, urinals.countUrinals(s1));
        assertEquals(-1, urinals.countUrinals(s2));
        System.out.println("====== Neev Umeshkumar Shah == TEST TWO EXECUTED =======");
    }

    @Test()
    public void ReadFileTest_FileNotFoundException() {
        Urinals urinals = new Urinals();
        assertThrows(FileNotFoundException.class, () -> urinals.readFile("src/test/resources/test.txt"));
        System.out.println("====== Neev Umeshkumar Shah == TEST THREE EXECUTED =======");
    }

    @Test()
    public void ReadFileTest_FileFound() {
        Urinals urinals = new Urinals();
        assertDoesNotThrow(() -> urinals.readFile("src/test/resources/test1.txt"));
        System.out.println("====== Neev Umeshkumar Shah == TEST FOUR EXECUTED =======");
    }

}
