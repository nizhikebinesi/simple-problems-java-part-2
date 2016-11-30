package ArraysOfObjects.reader;

import ArraysOfObjects.exceptions.DateException;
import ArraysOfObjects.exceptions.PaymentException;
import ArraysOfObjects.report.FinanceReport;

import java.io.IOException;

/**
 *
 */
public interface IFinanceReader {

    //

    //return Payment
    FinanceReport read() throws IOException, PaymentException, DateException;
}
