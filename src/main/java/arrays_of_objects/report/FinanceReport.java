package arrays_of_objects.report;

import arrays_of_objects.Month;
import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
import arrays_of_objects.payment.Payment;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Character.toUpperCase;

/**
 *
 */
public class FinanceReport implements Cloneable {
    private Payment[] arr;
    //конструктор по размеру
    //private IFinanceWriter writer;
    //private IFinanceReader reader;
/*
    public FinanceReport(Payment[] arr, FinanceFileReader reader) throws IOException {
        this.arr = arr;
    //    this.reader = reader;
    //    this.writer = new FinanceSystemWriter();
    }

    public FinanceReport(Payment[] arr, FinanceFileWriter writer) throws IOException {
        this.arr = arr;
    //    this.writer = writer;
    //    this.reader = new FinanceSystemReader();
    }

    public FinanceReport(Payment[] arr, FinanceFileWriter writer, FinanceFileReader reader) {
        this.arr = arr;
    //    this.writer = writer;
    //    this.reader = reader;
    }
*/

    public  FinanceReport(int count) throws PaymentException, DateException {
        if (count > 0) {
            this.arr = new Payment[count];
            for (int i = 0; i < count; i++) {
                this.arr[i] = new Payment("John Brown", 1, 1, 2001, 1);
            }
        }
    }

    public FinanceReport(Payment[] arr) {
        this.arr = arr;
    //    this.writer = new FinanceSystemWriter();
    //    this.reader = new FinanceSystemReader();
    }
    //clone

    // констуктор копирования
    public FinanceReport (FinanceReport fr) throws PaymentException, DateException {
        int n = fr.countOfPayments();
        this.arr = new Payment [n];

        for (int i = 0; i < n; i++) {
            this.arr[i] = new Payment(fr.getIthPayment(i));
        }
    }

    public int countOfPayments() {
        return arr.length;
    }

    public void setFioIthPayment(int i, String fio) {
        arr[i].setFio(fio);
    }

    public void setDdIthPayment(int i, int dd) throws DateException {
        arr[i].setDd(dd);
    }

    public void setMmIthPayment(int i, int mm) throws DateException {
        arr[i].setMm(mm);
    }

    public void setYyIthPayment(int i, int yy) throws DateException {
        arr[i].setYy(yy);
    }

    public void setPaymentIthPayment(int i, int payment) throws PaymentException {
        arr[i].setPayment(payment);
    }

    public String getFioIthPayment(int i) {
        return arr[i].getFio();
    }

    public int getDdIthPayment(int i) {
        return arr[i].getDd();
    }

    public int getMmIthPayment(int i) {
        return arr[i].getMm();
    }

    public int getYyIthPayment(int i) {
        return arr[i].getYy();
    }

    public int getPaymentIthPayment(int i) {
        return arr[i].getPayment();
    }

    public Payment getIthPayment(int i) {
        return this.arr[i];
    }

    public void setIthPayment(int i, Payment p) {
        arr[i] = p;
    }

    @Override
    public String toString() {
        String ss = "";
        if (this.countOfPayments() > 0) {
            ss = ss.concat("Finance Report:\n");
        }
        for (int i = 0; i < this.countOfPayments(); i++) {
            ss = ss.concat(this.arr[i].toString() + "\n");
        }
        //ss = ss.concat("\n");
        return ss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinanceReport that = (FinanceReport) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(arr, that.arr);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    public FinanceReport clone() {
        try {
            FinanceReport clone = (FinanceReport)super.clone();
            clone.arr = this.arr.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public FinanceReport writePaymentsBeginningOnTheSymbol(char ch) {
        int n = this.countOfPayments();
        FinanceReport fr = null;

        ArrayList<Payment> al = new ArrayList<>();

        int j = 0;

        for (int i = 0; i < n; i++) {
            if (toUpperCase((this.getFioIthPayment(i)).charAt(0)) == toUpperCase(ch)) {
                al.add(this.arr[i]);
                j++;
            }
        }

        if (al.size() > 0) {
            Payment[] p = new Payment [j];
            al.toArray(p);
            fr = new FinanceReport(p);
        }

        return fr;
    }

    public FinanceReport writePaymentsLessThanValue(int value) {
        int n = this.countOfPayments();

        FinanceReport fr = null;

        ArrayList<Payment> al = new ArrayList<>();

        int j = 0;

        for (int i = 0; i < n; i++) {
            if (this.getPaymentIthPayment(i) < value) {
                al.add(this.arr[i]);
                j++;
            }
        }

        if (al.size() > 0) {
            Payment[] p = new Payment [j];
            al.toArray(p);
            fr = new FinanceReport(p);
        }

        return fr;
    }

    public int writeSumOfPaymentsOnThisDate(String ddmmyy) throws DateException {
        int n = this.countOfPayments();

        char[] a = ddmmyy.toCharArray();

        int j = 0;

        //dd
        int dd;
        String sdd = "";
        while (a[j] != '.') {
            sdd = sdd.concat(a[j] + "");
            j++;
        }
        j++;
        dd = Integer.parseInt(sdd);


        //mm
        int mm;
        String smm = "";
        while (a[j] != '.') {
            smm = smm.concat(a[j] + "");
            j++;
        }
        j++;
        mm = Integer.parseInt(smm);


        //yy
        int yy;
        String syy = "";
        while (j < ddmmyy.length()) {
            syy = syy.concat(a[j] + "");
            j++;
        }

        yy = Integer.parseInt(syy);

        String check = dayCheck(dd, mm, yy);

        if (!check.equals("OK")) {
            throw new DateException(check);
        }

        FinanceReport fr = null;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (this.getDdIthPayment(i) == dd && this.getMmIthPayment(i) == mm && this.getYyIthPayment(i) == yy) {
                sum += this.getPaymentIthPayment(i);
            }
        }

        return sum;
    }

    private String dayCheck(int dd, int mm, int yy) {
        String s = "OK";
        if (yy == 0) {
            return "Year is equal to 0";
        }
        if (mm > 12 || mm < 1) {
            return "Month is less than 1 or more than 12";
        }
        if ((28 + (mm + Math.floor(mm / 8)) % 2 + 2 % mm + 2 * Math.floor(1 / mm) < dd && !(mm == 2 && dd == 29 && (yy % 4 == 0 && yy > 0 || (Math.abs(yy) - 1 % 4 == 0) && yy < 0)) || dd < 1)) {
            System.out.println(dd);
            return "Day is more than count of days in " + mm + " month or less than 1";
        }
        return s;
    }

    public String monthsWhenWasNoPaymentsThisYear(int yy) {
        String s = "";

        int n = this.countOfPayments();

        s = s.concat("Список названий месяцев, в которых не было ни одного платежа:\n");

        boolean b = true;

        boolean months[] = new boolean[12];
        for (int i = 0; i < 12; i++) {
            months[i] = true;
        }

        for (int i = 0; i < n; i++) {
            if (this.getYyIthPayment(i) == yy) {
                months[this.getMmIthPayment(i) - 1] = false;
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

        //s = s.concat("\n");

        return s;
    }
}
