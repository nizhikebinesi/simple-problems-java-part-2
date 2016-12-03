package arrays_of_objects.reader;

import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
import arrays_of_objects.payment.Payment;
import arrays_of_objects.report.FinanceReport;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 */
public class FinanceSystemReader implements IFinanceReader {

    private InputStream systemStream;
    private Scanner sc;
    //private Reader systemReader;
    /**
     *
     * @throws IOException
     */
    public FinanceSystemReader() throws IOException {
        this.systemStream = System.in;
        //this.systemReader = new InputStreamReader(this.systemStream);
        this.sc = new Scanner(this.systemStream);
    }

    /**
     * @return int variable
     * @throws  IOException
     */
    public FinanceReport read() throws IOException, PaymentException, DateException {
        int n = this.sc.nextInt();
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
        return new FinanceReport(ar);
    }

    /**
     *
     * @throws IOException
     */
    public void close() throws IOException {
        this.sc.close();
    }
}
