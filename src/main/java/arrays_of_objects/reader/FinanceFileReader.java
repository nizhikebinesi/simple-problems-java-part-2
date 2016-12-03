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
        //FinanceReport fr = null;
        /*char buf[] = new char[fileStream.available()];
        byte cbuf[] = new byte[fileStream.available()];
        this.fileStream.read(cbuf, 0, fileStream.available());
        //this.fileReader.read(buf);
        //this.fileReader.read(buf);

        for (int i = 0; i < cbuf.length; i++) {
            buf[i] = (char) cbuf[i];
            System.out.println(cbuf[i]);
            //System.out.println(buf[i]);
        }

        //Payment[] ar = new Payment[];
        //String[] fio = new String[]
        ArrayList<Payment> al = new ArrayList<>();

        int j = 0;
        int start = 0;
        int finish = 0;

        while (j < buf.length) {
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

        }*/
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
    public void close() throws IOException {
        fileReader.close();
    }
}
