package arrays_of_objects.reader;

import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
import arrays_of_objects.payment.Payment;
import arrays_of_objects.report.FinanceReport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 */
public class FinanceSystemReader implements IFinanceReader {

    private InputStream systemStream;
    private BufferedReader systemReader;
    //private Scanner sc;
    //private Reader systemReader;
    /**
     *
     * @throws IOException
     */
    public FinanceSystemReader() throws IOException {
        this.systemStream = System.in;
        this.systemReader = new BufferedReader(new InputStreamReader(System.in));
        //this.systemReader = new InputStreamReader(this.systemStream);
        //this.sc = new Scanner(this.systemStream);

    }

    /**
     * @return int variable
     * @throws  IOException
     */
    public FinanceReport read() throws IOException, PaymentException, DateException {
        /*int n = this.sc.nextInt();
        Payment[] ar = new Payment[n];
        for (int i = 0; i < n; i++) {
            this.sc.nextLine();
            String fio = this.sc.nextLine().trim();
            int dd = this.sc.nextInt();
            int mm = this.sc.nextInt();
            int yy = this.sc.nextInt();
            int payment = this.sc.nextInt();
            ar[i] = new Payment(fio, dd, mm, yy, payment);
        }
        return new FinanceReport(ar);*/
        System.out.println("Enter new Payments\' array for new FinanceReport:");
        int n = Integer.parseInt(this.systemReader.readLine());
        Payment[] ar = new Payment[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter name of " + (i + 1) +  "-th payer:");
            String fio = this.systemReader.readLine().trim();
            System.out.println("Enter day of " + (i + 1) + "-th payment:");
            int dd = Integer.parseInt(this.systemReader.readLine());
            System.out.println("Enter month of " + (i + 1) + "-th payment:");
            int mm = Integer.parseInt(this.systemReader.readLine());
            System.out.println("Enter year of " + (i + 1) + "-th payment:");
            int yy = Integer.parseInt(this.systemReader.readLine());
            System.out.println("Enter value of " + (i + 1) + "-th payment:");
            int payment = Integer.parseInt(this.systemReader.readLine());
            ar[i] = new Payment(fio, dd, mm, yy, payment);
        }

        return new FinanceReport((ar));
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        this.systemReader.close();
    }
}
