package arrays_of_objects.writer;

import arrays_of_objects.report.FinanceReport;

import java.io.*;

import static java.lang.Character.toUpperCase;

/**
 *
 */
public class FinanceSystemWriter implements IFinanceWriter {

    private OutputStream systemStream;
    private Writer systemWriter;
    /**
     *
     * @throws IOException
     */
    public FinanceSystemWriter(FinanceReport fr) throws IOException {
        this.systemStream = new PrintStream(System.out);//FileOutputStream(file);
        this.systemWriter = new PrintWriter(this.systemStream);
    }

    public void write(FinanceReport fr) throws IOException {
        //((PrintWriter)this.systemWriter).print(super.fr.toString());
        //((PrintWriter)systemWriter).print("ffffffffuuuuuuuucccckkk!!!");
        String s = "";
        if (fr != null) {
            s = fr.toString();
        } else {
            s = "None.\n";
        }
        this.systemWriter.write(s);
        this.systemWriter.flush();

    }

    /**
     *
     * @throws IOException
     */
    public void close() throws IOException {
        this.systemWriter.close();
    }
}
