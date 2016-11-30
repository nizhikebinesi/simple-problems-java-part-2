package ArraysOfObjects.writer;

import ArraysOfObjects.exceptions.DateException;
import ArraysOfObjects.report.FinanceReport;

import java.io.*;

import static java.lang.Character.toUpperCase;

/**
 *
 */
public class FinanceSystemWriter extends FinanceWriter implements IFinanceWriterChild {

    private OutputStream systemStream;
    private Writer systemWriter;
    //private FinanceReport fr;
    /**
     *
     * @throws IOException
     */
    public FinanceSystemWriter(FinanceReport fr) throws IOException {
        this.systemStream = new PrintStream(System.out);//FileOutputStream(file);
        this.systemWriter = new PrintWriter(this.systemStream);
        //PrintWriter pr = new PrintWriter(System.out);
        //pr.println("HELLO!");
        //systemWriter = new PrintWriter(System.out);
        super.fr = fr;
    }

    @Override
    public void write(FinanceReport fr) throws IOException {
        //((PrintWriter)this.systemWriter).print(super.fr.toString());
        //((PrintWriter)systemWriter).print("ffffffffuuuuuuuucccckkk!!!");
        this.systemWriter.write(fr.toString());
        this.systemWriter.flush();
    }

    public void write() throws IOException {
        //((PrintWriter)this.systemWriter).write(super.fr.toString());
        //((PrintWriter)systemWriter).print("ffffffffuuuuuuuucccckkk!!!");
        this.systemWriter.write(super.fr.toString());
        this.systemWriter.flush();
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        this.systemWriter.close();
    }

    private void write(String s) throws IOException {
        //((PrintWriter)this.systemWriter).print(s);
        this.systemWriter.write(s);
        this.systemWriter.flush();
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
