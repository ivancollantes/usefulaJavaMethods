import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsefulMethods {
    /**********/
    /* TESTED */
    /**********/

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING of: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY or SUNDAY
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */
    public static String findDay(int month, int day, int year) {
        Calendar date = Calendar.getInstance();
        date.set(year, month - 1, day); // Calendar months start in 0
        return date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
    }

    public static boolean isValidIPAddress(String ipAddress) {
        String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        return ipAddress.matches(pattern);
    }

    public static String removeDuplicatedWordsByRegex(String sentence) {
        String regex = "(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);
        String result = sentence;
        while (matcher.find()) {
            result = result.replaceAll(matcher.group(), matcher.group().split(" ")[0]);
        }
        return result;
    }

    // https://www.gs1.org/services/how-calculate-check-digit-manually
    public static int computeCheckDigit(String ean) {
        int evens = 0;
        int odds = 0;
        int checkSum;

        for(int i = 0; i < ean.length(); i++) {
            int currentNumber = Character.getNumericValue(ean.charAt(i));
            int position = i + 1; // As indexes start at 0, we add 1 to recreate the actual position
            if(position % 2 == 0) {
                evens += currentNumber;
            } else {
                odds += currentNumber;
            }
        }

        if(ean.length() % 2 == 0) {
            evens = evens * 3;
        } else {
            odds = odds * 3;
        }

        int total = odds + evens;

        if (total % 10 == 0){
            checkSum = 0;
        } else {
            checkSum = 10 - (total % 10); //subtract the ones digit from 10 to find the checksum
        }

        return checkSum;
    }

    public static String getEanWithControlDigit(String ean) {
        return ean + computeCheckDigit(ean);
    }



    /**************/
    /* NOT TESTED */
    /**************/
    public static String filterOutNonAlphaCharacters(String text) {
        return text.trim().replaceAll("[^a-zA-Z]","");
    }

    public static String padRight(int amount, String fillChar) {
        return String.format("%-" + amount + "s", fillChar);
    }

    public static String padRightWithBlanks(int amount) {
        return padRight(amount, "");
    }

    public static String padLeft(int amount, String fillChar) {
        return String.format("%" + amount + "s", fillChar);
    }

    public static String padLeftWithBlanks(int amount) {
        return padLeft(amount, "");
    }

    public static String pruneString(String text, int desiredLength) {
        return text.substring(0, Math.min(desiredLength, text.length()));
    }

    public static boolean stringContainsItemFromList(String inputString, List<String> items) {
        return items.stream().parallel().anyMatch(inputString::contains);
    }

    public static boolean stringContainsItemFromArray(String inputStr, String[] items) {
        return Arrays.stream(items).parallel().anyMatch(inputStr::contains);
    }
}
