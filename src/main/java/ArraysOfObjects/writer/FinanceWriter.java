package ArraysOfObjects.writer;

import ArraysOfObjects.Month;
import ArraysOfObjects.exceptions.DateException;
import ArraysOfObjects.report.FinanceReport;

import java.io.IOException;

import static java.lang.Character.toUpperCase;

/**
 * Created by a on 11/29/16.
 */
public class FinanceWriter implements IFinanceWriter {

    protected FinanceReport fr;

    public void write(FinanceReport fr) throws IOException {

    }

    public void close() throws IOException {

    }



    //private void write(String s) throws IOException {
    //    systemWriter.write(s);
    //}

    protected String writePaymentsBeginningOnTheSymbol(char ch) {
        int n = fr.countOfPayments();
        String s = "";

        boolean b = true;

        s = s.concat("Все платежи, имена всех плательщиков начинаются на" + " \'" + ch + "\':\n");

        for (int i = 0; i < n; i++) {
            if (toUpperCase((fr.getFioIthPayment(i)).charAt(0)) == toUpperCase(ch)) {
                b &= false;
                s = s.concat(String.format("«%1s» дата: %2$d.%3$d.%4$d сумма: %5$d руб. %6$d коп.\n", fr.getFioIthPayment(i), fr.getDdIthPayment(i), fr.getMmIthPayment(i), fr.getYyIthPayment(i), fr.getPaymentIthPayment(i) / 100, fr.getPaymentIthPayment(i) % 100));
            }
        }

        if (b) {
            s = s.concat("None.\n");
        }

        s = s.concat("\n");

        return s;
    }

    protected String writePaymentsLessThanValue(int value) {
        int n = fr.countOfPayments();
        String s = "";

        boolean b = true;

        s = s.concat("Платежи, меньшие чем " + value + " коп. :\n");

        for (int i = 0; i < n; i++) {
            //System.out.println("Why?!");
            if (fr.getPaymentIthPayment(i) < value) {
                b &= false;
                s = s.concat(String.format("«%1s» дата: %2$d.%3$d.%4$d сумма: %5$d руб. %6$d коп.\n", fr.getFioIthPayment(i), fr.getDdIthPayment(i), fr.getMmIthPayment(i), fr.getYyIthPayment(i), fr.getPaymentIthPayment(i) / 100, fr.getPaymentIthPayment(i) % 100));
            }
        }

        if (b) {
            s = s.concat("None.\n\n");
        }

        return s;
    }

    protected String writeSumOfPaymentsOnThisDate(String ddmmyy) throws DateException {
        int n = fr.countOfPayments();

        char[] a = ddmmyy.toCharArray();

        int j = 0;

        //dd
        int dd;
        String sdd = "";
        while (a[j] != '.') {
            System.out.println(a[j] + " = j");
            sdd = sdd.concat(a[j] + "");
            j++;
        }
        j++;
        dd = Integer.parseInt(sdd);


        //mm
        int mm;
        String smm = "";
        while (a[j] != '.') {
            System.out.println(a[j] + " = j");
            smm = smm.concat(a[j] + "");
            j++;
        }
        j++;
        mm = Integer.parseInt(smm);


        //yy
        int yy;
        String syy = "";
        while (j < ddmmyy.length()) {
            System.out.println(a[j] + " = j");
            syy = syy.concat(a[j] + "");
            j++;
        }

        yy = Integer.parseInt(syy);

        String check = dayCheck(dd, mm, yy);

        if (!check.equals("OK")) {
            throw new DateException(check);
        }

        String s = "";

        s = s.concat("Суммарный платеж за " + ddmmyy + ":\n");

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (fr.getDdIthPayment(i) == dd && fr.getMmIthPayment(i) == mm && fr.getYyIthPayment(i) == yy) {
                sum += fr.getPaymentIthPayment(i);
            }
            s = s.concat(sum + " коп.\n");
        }

        s = s.concat("\n");

        return s;
    }

    private String dayCheck(int dd, int mm, int yy) {
        String s = "OK";
        if (yy <= 0) {
            return "Year is less than 0 or equals to 0";
        }
        if (mm > 12 || mm < 1) {
            return "Month is less than 1 or more than 12";
        }
        int x = mm;
        if (!((28 + (x + Math.floor(x / 8)) % 2 + 2 % x + 2 * Math.floor(1 / x) < dd || (x == 2 && dd == 29)) && dd > 1)) {
            return "Day is more than count of days in " + x + " month or less than 1";
        }
        return s;
    }

    protected String monthsWhenWasNoPaymentsThisYear(int yy) {
        String s = "";

        int n = fr.countOfPayments();

        s = s.concat("Список названий месяцев, в которых не было ни одного платежа:\n");

        boolean b = true;

        boolean months[] = new boolean[12];
        for (int i = 0; i < 12; i++) {
            months[i] = true;
        }

        for (int i = 0; i < n; i++) {
            if (fr.getYyIthPayment(i) == yy) {
                months[fr.getMmIthPayment(i) - 1] = false;
            }
        }

        for (int i = 0; i < 12; i++) {
            if (months[i]) {
                b &= false;
                s = s.concat(Month.month.get((i + 1)) + "\n");
            }
        }

        if (b) {
            s = s.concat("None.\n");
        }

        s = s.concat("\n");

        return s;
    }

}
