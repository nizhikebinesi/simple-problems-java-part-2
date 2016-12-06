package arrays_of_objects.reader;

import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
import arrays_of_objects.report.FinanceReport;

import java.io.IOException;

/**
 *
 */
public interface IFinanceReader {

    //

    //return Payment
    FinanceReport read() throws IOException, PaymentException, DateException;
    void close() throws IOException;
}
