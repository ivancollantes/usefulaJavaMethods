import org.junit.Test;

import static org.junit.Assert.*;

public class UsefulMethodsTest {

    @Test
    public void findDayOf20170814isMONDAY() {
        int year = 2017;
        int month = 8;
        int day = 14;
        String expectedDay = "MONDAY";
        String obtainedDay = UsefulMethods.findDay(month, day, year);
        assertEquals(obtainedDay, expectedDay);
    }

    @Test
    public void isValidIPAddress() {
        String ip = "192.168.0.156";
        assertTrue(UsefulMethods.isValidIPAddress(ip));
    }

    @Test
    public void badFormattedIPAddressIsNotValid() {
        String ip = "192-168.0.156";
        assertFalse(UsefulMethods.isValidIPAddress(ip));
    }

    @Test
    public void outOfRangeIPAddressIsNotValid() {
        String ip = "192.168.456.156";
        assertFalse(UsefulMethods.isValidIPAddress(ip));
    }

    @Test
    public void removesDuplicatedWords(){
        String sentence = "Goodbye bye bye world world world";
        String expectedSentence = "Goodbye bye world";
        String fixedSentence = UsefulMethods.removeDuplicatedWordsByRegex(sentence);
        assertEquals(fixedSentence,expectedSentence);
    }

    @Test
    public void computeCheckDigitTest() {
        String ean13_0 = "629104150021";
        int expectedControlDigit0 = 3;
        int resultingControlDigit0 = UsefulMethods.computeCheckDigit(ean13_0);
        assertEquals(expectedControlDigit0, resultingControlDigit0);

        String ean13_1 = "220000001818";
        int expectedControlDigit1 = 2;
        int resultingControlDigit1 = UsefulMethods.computeCheckDigit(ean13_1);
        assertEquals(expectedControlDigit1, resultingControlDigit1);

        String ean13_2 = "220000000034";
        int expectedControlDigit2 = 7;
        int resultingControlDigit2 = UsefulMethods.computeCheckDigit(ean13_2);
        assertEquals(expectedControlDigit2, resultingControlDigit2);

        String ean8_0 = "6291041";
        int expectedControlDigit3 = 5;
        int resultingControlDigit3 = UsefulMethods.computeCheckDigit(ean8_0);
        assertEquals(expectedControlDigit3, resultingControlDigit3);

        String ean8_1 = "2201818";
        int expectedControlDigit4 = 2;
        int resultingControlDigit4 = UsefulMethods.computeCheckDigit(ean8_1);
        assertEquals(expectedControlDigit4, resultingControlDigit4);

        String ean8_2 = "2000034";
        int expectedControlDigit5 = 9;
        int resultingControlDigit5 = UsefulMethods.computeCheckDigit(ean8_2);
        assertEquals(expectedControlDigit5, resultingControlDigit5);
    }

    @Test
    public void getEanWithControlDigitTest() {
        String ean = "220000000034";
        String expectedEan = "2200000000347";
        String resultingEan = UsefulMethods.getEanWithControlDigit(ean);
        assertEquals(expectedEan, resultingEan);
    }
}
