import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class urinalsTest {


    @Test
    public void isGoodStringTest(){
        String s1 = "10101001";
        String s2 = "001101110";
        Urinals urinals = new Urinals();
        assertTrue(urinals.isGoodString(s1));
        assertFalse(urinals.isGoodString(s2));
        System.out.println("");
    }
}
