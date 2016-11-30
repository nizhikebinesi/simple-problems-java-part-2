package ArraysOfObjects.writer;

import ArraysOfObjects.exceptions.DateException;
import ArraysOfObjects.report.FinanceReport;

import java.io.*;

/**
 *
 */
public class FinanceFileWriter extends FinanceWriter implements IFinanceWriterChild {

    private OutputStream fileStream;
    private Writer fileWriter;
    private String path;
    private String name;
    /**
     *
     * @param path is path to File
     * @param name is name of File
     * @throws IOException
     */
    public FinanceFileWriter(FinanceReport fr, String path, String name) throws IOException {
        this.name = name;
        this.path = path;

        File file = new File(path, name);
        this.fileStream = new FileOutputStream(file);
        this.fileWriter = new OutputStreamWriter(fileStream, "utf-8");

        super.fr = fr;

    }

    /**
     *
     * @param str is output string
     * @throws IOException
     */
    private void write(final String str) throws IOException {
        this.fileWriter.write(str);
    }

    @Override
    public void write(FinanceReport fr) throws IOException {
        String s = "";
        for (int i = 0; i < fr.countOfPayments(); i++) {
            s = s.concat(fr.getFioIthPayment(i) + "\n" + fr.getDdIthPayment(i) + "\n" + fr.getMmIthPayment(i) + "\n" + fr.getYyIthPayment(i) + "\n" + fr.getPaymentIthPayment(i) + "\n");
        }
        this.fileWriter.write(s);
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        fileWriter.close();
    }

    public void writePaymentsBeginningOnChar(char ch) throws IOException {
        this.write(super.writePaymentsBeginningOnTheSymbol(ch));
    }

    public void writePaymentsLessThanVal(int value) throws IOException {
        this.write(super.writePaymentsLessThanValue(value));
    }

    public void writeSumOfPaymentsOnTheDate(String ddmmyy) throws DateException, IOException {
        this.write(super.writeSumOfPaymentsOnThisDate(ddmmyy));
    }

    public void monthsWhenWasNoPaymentsTheYear(int yy) throws IOException {
        this.write(super.monthsWhenWasNoPaymentsThisYear(yy));
    }

}
