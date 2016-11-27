import StringProcessor.*;
import static StringProcessor.StringProcessor.changeFirstLastWords;
import static StringProcessor.StringProcessor.fromHexToDec;
import static StringProcessor.StringProcessor.nCopyOfString;

public class Main {

    public static void main(String[] args) throws StringProcessorException {
        try {
            //String f = nCopyOfString("1_2_", -1);
            //System.out.println(f);
            String s = nCopyOfString("abc", 3);
            System.out.println(s);
            System.out.println();
            int count = StringProcessor.countOfFirstInSecondString("   aaa aa ", " a");
            System.out.println(count);
            String ss = StringProcessor.change3FirstDigitsToWords("1_бЕда_2-thISSSS 3  4 eee");
            System.out.println(ss + " : after changing");
            StringBuilder sss = new StringBuilder("1");
            System.out.println(sss + " : before changing");
            StringProcessor.modifyStringBuilder(sss);
            System.out.println(sss + " : after changing");
            StringBuilder sb = new StringBuilder("  first abc_d f last   ");
            changeFirstLastWords(sb);
            System.out.println(sb);
            String hex = "I think 0xE 0x0000000F 0x0000000V 0x00000001 0xf";
            System.out.println(fromHexToDec(hex));
        } catch (Exception e) {
            System.err.println("There was not StringProcessorException");
        }
    }
}
