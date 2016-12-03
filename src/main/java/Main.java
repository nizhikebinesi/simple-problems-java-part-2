import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
//import arrays_of_objects.read_write_from_standart_stream.ReaderSt;
//import arrays_of_objects.read_write_from_standart_stream.WriterSt;
import arrays_of_objects.reader.FinanceSystemReader;
import arrays_of_objects.report.FinanceReport;
import arrays_of_objects.writer.FinanceSystemWriter;
import string_processor.*;

import java.io.IOException;
import java.util.Scanner;

import static string_processor.StringProcessor.changeFirstLastWords;
import static string_processor.StringProcessor.fromHexToDec;
import static string_processor.StringProcessor.nCopyOfString;

public class Main {

    public static void main(String[] args) throws StringProcessorException {
        //PrintWriter pr = new PrintWriter(System.out, true);
        //pr.write("SSSSSSSSSSSS");
        //pr.flush();
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

            System.out.println("Arrays of objects");
            System.out.println("*****************");

            System.out.println("Length of array, i-th FIO, i-th dd, i-th mm, i-th yy, i-th payment");

            FinanceReport fr;
            FinanceSystemReader reader = new FinanceSystemReader();
            fr = reader.read();
            //System.out.println(fr);
            FinanceSystemWriter writer = new FinanceSystemWriter(fr);
            writer.write(fr);
            System.out.println("Платежи, начинающиеся на \'C\'(си)");
            writer.write(fr.writePaymentsBeginningOnTheSymbol('C'));
            Scanner sc = new Scanner(System.in);
            System.out.println("Число, меньше которого должен быть платеж, чтобы было нужно вывести информацию о платежах:");
            int n = sc.nextInt();
            System.out.println("Платежи, меньшие чем " + n);
            writer.write(fr.writePaymentsLessThanValue(n));
            System.out.println("Введите год(целое число), чтобы список названий месяцев, в которых не было ни одного платежа в течение этого года:");
            int yy = sc.nextInt();
            System.out.println(fr.monthsWhenWasNoPaymentsThisYear(yy));
            System.out.println("Введите строку с датой в формате dd.mm.yy, чтобы вычислить суммарный платеж за данную дату:");

            writer.close();
            reader.close();

            //writer.write();

            //PrintStream stream = System.out;

            //stream.print("WWWWWWWWWWWWWWWWWWWW");

            //PrintWriter pr = new PrintWriter(System.out);
            //pr.println("AAAAAAAAAAAAAAAAAAAAA");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (PaymentException e) {
            e.printStackTrace();
        } catch (DateException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
