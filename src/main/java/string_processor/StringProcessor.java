package string_processor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class StringProcessor {

    private static final Map<String, String> myMap = new HashMap<String, String>(){{
        put("1", "один");
        put("2", "два");
        put("3", "три");
    }};
/*
    private static final Map<Character, Integer> changing = new HashMap<Character, Integer>(){{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
    }};
*/
    static {
        myMap.put("4", "четыре");
    }

    private static final int count = 8;

    public static String nCopyOfString(String s, int N)/* throws StringProcessorException */{
        StringBuilder result = new StringBuilder("");
        if (N < 0) {
            throw new IllegalArgumentException("");
            //throw new StringProcessorException("N < 0");
        }

        for (int i = 0; i < N; i++) {
            result.append(s);
        }

        return result.toString();
    }

    //ava code conventions

    public static int countOfFirstInSecondString(String s1, String s2) {
        int count = 0;
        String ss = s1;
        while (ss.contains(s2)) {
            ss = ss.substring(ss.indexOf(s2) + s2.length());
            count++;
        }
        return count;
    }

    public static String change3FirstDigitsToWords(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String original = "" + s.charAt(i);
            if (myMap.containsKey(original)) {
                result = result.concat(myMap.get(original));
            } else {
                result = result.concat(original);
            }
            //for(Map.Entry<String, String> entry : myMap.entrySet()) {
            //    String key = entry.getKey();
            //    if (original.equals(key)) {
            //        result = result.concat(myMap.get(key));
            //        bi |= true;
            //    }
            }
            //if (!bi) {
            //    result = result.concat(original);
            //}


        return result;
    }

    public static void modifyStringBuilder(StringBuilder s) {
        int len = (s.length() % 2 == 1)?(s.length() - 2):(s.length() - 1);
        for (int i = len; i > 0; i -= 2) {
            s.deleteCharAt(i);
        }
    }

    public static void changeFirstLastWords(StringBuilder s) {

        int begin1 = 0;
        int end1;
        while (begin1 < s.length() && (s.charAt(begin1) == ' ')) {
            begin1++;
        }
        end1 = begin1;
        while (end1 < s.length() && (s.charAt(end1) != ' ')) {
            end1++;
        }
        String first = s.substring(begin1, end1);
        int begin2 = s.length() - 1;
        int end2;
        do {
            begin2--;
        } while (begin2 > -1 && (s.charAt(begin2 - 1) == ' '));
        end2 = begin2;
        do {
            end2--;
        } while (end2 > -1 && (s.charAt(end2 - 1) != ' '));
        String last = s.substring(end2, begin2);
        s.delete(end2, begin2);
        s.insert(end2,first);
        s.delete(begin1, end1);
        s.insert(begin1, last);
    }

    private static final String id = "0x";

    public static String fromHexToDec (String s) {
        String result = "";

        StringBuilder ss = new StringBuilder(s);
        while (ss.length() != 0) {
            result = result.concat(ss.substring(0, ss.indexOf(id)));
            ss.delete(0, ss.indexOf(id));
            try {
                result = result.concat((Integer.parseInt(ss.substring(2, 10), 16)) + "");
                ss.delete(0, 10);
                //0x2 0x
            } catch (StringIndexOutOfBoundsException e) {
                result = result.concat(ss.substring(0, ss.length()));
                ss.delete(0, ss.length());
            } catch (NumberFormatException e) {
                result = result.concat(ss.substring(0, 10));
                ss.delete(0, 10);
            }
        }
        return result;
    }
}
