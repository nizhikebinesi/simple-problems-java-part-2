package ArraysOfObjects.report;

import ArraysOfObjects.exceptions.DateException;
import ArraysOfObjects.exceptions.PaymentException;
import ArraysOfObjects.payment.Payment;

import java.io.IOException;

/**
 *
 */
public class FinanceReport {
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
    public FinanceReport(Payment[] arr) throws IOException {
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
        return arr[i];
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
        ss = ss.concat("\n");
        return ss;
    }

    public void paymentsFromSurname() {

    }
}
