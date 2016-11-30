import ArraysOfObjects.exceptions.DateException;
import ArraysOfObjects.exceptions.PaymentException;
//import ArraysOfObjects.read_write_from_standart_stream.ReaderSt;
//import ArraysOfObjects.read_write_from_standart_stream.WriterSt;
import ArraysOfObjects.reader.FinanceSystemReader;
import ArraysOfObjects.report.FinanceReport;
import ArraysOfObjects.writer.FinanceSystemWriter;
import StringProcessor.*;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws StringProcessorException {
        //PrintWriter pr = new PrintWriter(System.out, true);
        //pr.write("SSSSSSSSSSSS");
        //pr.flush();
        try {
            //String f = nCopyOfString("1_2_", -1);
            //System.out.println(f);
/*            String s = nCopyOfString("abc", 3);
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
*/
            System.out.println("Arrays of objects");
            System.out.println("*****************");

            System.out.println("Length of array, i-th FIO, i-th dd, i-th mm, i-th yy, i-th payment");

            FinanceReport fr;
            FinanceSystemReader reader = new FinanceSystemReader();
            fr = reader.read();
            //System.out.println(fr);
            FinanceSystemWriter writer = new FinanceSystemWriter(fr);
            writer.write(fr);
            writer.write();
            writer.writePaymentsBeginningOnChar('R');
            writer.monthsWhenWasNoPaymentsTheYear(2000);
            //writer.write();

            //PrintStream stream = System.out;

            //stream.print("WWWWWWWWWWWWWWWWWWWW");

            //PrintWriter pr = new PrintWriter(System.out);
            //pr.println("AAAAAAAAAAAAAAAAAAAAA");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PaymentException e) {
            e.printStackTrace();
        } catch (DateException e) {
            e.printStackTrace();
        }
    }
}
