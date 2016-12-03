package arrays_of_objects.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
import arrays_of_objects.payment.Payment;
import arrays_of_objects.reader.FinanceFileReader;
import arrays_of_objects.report.FinanceReport;
import arrays_of_objects.writer.FinanceFileWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

//import java.io.File;

/**
 *
 */
public class TestFinanceFileWriter {

    private String path;
    private String name;
    private FinanceFileReader input1;
    private FinanceFileWriter output1;
    private FinanceReport fr;

    @Before
    public void setUp() throws IOException, PaymentException, DateException {
        this.name = "test0.txt";
        this.path = "/home/a/IdeaProjects/simple-problems-java-part-2/";
        this.output1 = new FinanceFileWriter(path, name);
        this.input1 = new FinanceFileReader(path, name);
        Payment[] payments = new Payment[2];
        payments[0] = new Payment("Ivanov Ivan Ivanovich", 2, 12, 1998, 342);
        payments[1] = new Payment("Neiman John", 1, 2, 3006, 233333);
        this.fr = new FinanceReport(payments);
    }

    @Test
    public void testFinanceFileReader() throws IOException, PaymentException, DateException {
        this.output1.write(this.fr);
        this.output1.close();
        FinanceReport fr1 = this.input1.read();

        //System.out.println(fr1);

        this.input1.close();
        //this.output1.close();

        //System.out.println(fr);
        //System.out.println();
        //System.out.println(fr1);

        //if (fr1.equals(fr)) {
        //    System.out.println("YES!");
        //}

        //assertTrue("AAAA!", this.fr.equals(fr1));
        //assertEquals(this.fr, fr1);
        assertEquals(fr1, this.fr);
    }
}
