package ArraysOfObjects.reader;

import ArraysOfObjects.exceptions.DateException;
import ArraysOfObjects.exceptions.PaymentException;
import ArraysOfObjects.payment.Payment;
import ArraysOfObjects.report.FinanceReport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FinanceFileReader implements IFinanceReader {

    private InputStream fileStream;
    private Reader fileReader;
    private String path;
    private String name;
    /**
     *
     * @param pathS is path to file
     * @throws IOException
     */
    public FinanceFileReader(final String pathS, final String nameS) throws IOException {
        this.name = nameS;
        this.path = pathS;

        File file = new File(path.concat(name));
        this.fileStream = new FileInputStream(file);
        this.fileReader = new InputStreamReader(fileStream, "utf-8");

    }

    /**
     * @return int variable
     * @throws IOException
     */
    public FinanceReport read() throws IOException, PaymentException, DateException {
        //FinanceReport fr = null;
        char buf[] = new char[fileStream.available()];
        this.fileReader.read(buf);

        //Payment[] ar = new Payment[];
        //String[] fio = new String[]
        ArrayList<Payment> al = new ArrayList<Payment>();

        int j = 0;
        int start = 0;
        int finish = 0;

        while (buf[j] != -1) {
            start = j;
            while(buf[j] != '\n') {
                //String fio;
                j++;
                finish++;
            }
            String fio = String.copyValueOf(buf, start, finish - start);

            start = j;
            while(buf[j] != '\n') {
                //String fio;
                j++;
                finish++;
            }
            int dd = Integer.parseInt(String.copyValueOf(buf, start, finish - start));

            start = j;
            while(buf[j] != '\n') {
                //String fio;
                j++;
                finish++;
            }
            int mm = Integer.parseInt(String.copyValueOf(buf, start, finish - start));

            start = j;
            while(buf[j] != '\n') {
                //String fio;
                j++;
                finish++;
            }
            int yy = Integer.parseInt(String.copyValueOf(buf, start, finish - start));

            start = j;
            while(buf[j] != '\n') {
                //String fio;
                j++;
                finish++;
            }
            int payment = Integer.parseInt(String.copyValueOf(buf, start, finish - start));

            al.add(new Payment(fio, dd, mm, yy, payment));
            //al.append(new Payment(fio))

        }

        Payment[] ar = new Payment[al.size()];
        al.toArray(ar);

        return new FinanceReport(ar);
    }

    /**
     *
     * @throws IOException
     */
    public void close() throws IOException {
        fileReader.close();
    }
}
