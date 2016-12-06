package arrays_of_objects.writer;

import arrays_of_objects.report.FinanceReport;

import java.io.*;

/**
 *
 */
public class FinanceFileWriter implements IFinanceWriter {

    private OutputStream fileStream;
    private BufferedWriter fileWriter;
    private String path;
    private String name;
    /**
     *
     * @param path is path to File
     * @param name is name of File
     * @throws IOException
     */
    public FinanceFileWriter(String path, String name) throws IOException {
        this.name = name;
        this.path = path;

        File file = new File(path, name);
        this.fileStream = new FileOutputStream(file);
        this.fileWriter = new BufferedWriter(new OutputStreamWriter(fileStream, "utf-8"));
    }

    /**
     *
     * @param str is output string
     * @throws IOException
     */
    private void write(final String str) throws IOException {
        this.fileWriter.write(str);
    }

    public void write(FinanceReport fr) throws IOException {
        String s = "";
        if (fr != null) {
            for (int i = 0; i < fr.countOfPayments(); i++) {
                s = s.concat(fr.getFioIthPayment(i) + "\n" + fr.getDdIthPayment(i) + "\n" + fr.getMmIthPayment(i) + "\n" + fr.getYyIthPayment(i) + "\n" + fr.getPaymentIthPayment(i) + "\n");
            }
        } else {
            s = "None.\n";
        }
        this.fileWriter.write(s);
        this.fileWriter.flush();
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        fileWriter.close();
    }

}
