package arrays_of_objects.reader;

import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
import arrays_of_objects.payment.Payment;
import arrays_of_objects.report.FinanceReport;

import java.io.*;
import java.util.ArrayList;

/**
 *
 */
public class FinanceFileReader implements IFinanceReader {

    private InputStream fileStream;
    private BufferedReader fileReader;
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
        //this.fileStream = new FileInputStream(file);
        this.fileReader = new BufferedReader(new FileReader(file));
        //= new InputStreamReader(fileStream, "utf-8");

    }

    /**
     * @return int variable
     * @throws IOException
     */
    public FinanceReport read() throws IOException, PaymentException, DateException {
        ArrayList<Payment> al = new ArrayList<>();

        String line = this.fileReader.readLine().trim();
        ///System.out.println("AAAAAAFFFFF");
        ///System.out.println(line);
        ///System.out.println(this.fileReader.read());
        while (line != null) {
            String fio = line;
            line = this.fileReader.readLine();
            int dd = Integer.parseInt(line);
            line = this.fileReader.readLine();
            int mm = Integer.parseInt(line);
            line = this.fileReader.readLine();
            int yy = Integer.parseInt(line);
            line = this.fileReader.readLine();
            int payment = Integer.parseInt(line);
            line = this.fileReader.readLine();

            /*System.out.println(fio);
            System.out.println(dd);
            System.out.println(mm);
            System.out.println(yy);
            System.out.println(payment);
            */
            al.add(new Payment(fio, dd, mm, yy, payment));
        }

        //System.out.println(line + "fffffffffff");


        Payment[] ar = new Payment[al.size()];
        al.toArray(ar);

        return new FinanceReport(ar);
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        fileReader.close();
    }
}
