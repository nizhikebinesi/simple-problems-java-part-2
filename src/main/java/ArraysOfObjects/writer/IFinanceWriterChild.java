package ArraysOfObjects.writer;

import ArraysOfObjects.exceptions.DateException;

import java.io.IOException;

/**
 *
 */
public interface IFinanceWriterChild extends IFinanceWriter {
    public void writePaymentsBeginningOnChar(char ch) throws IOException;
    public void writePaymentsLessThanVal(int value) throws IOException;
    public void writeSumOfPaymentsOnTheDate(String ddmmyy) throws DateException, IOException;
    public void monthsWhenWasNoPaymentsTheYear(int yy) throws IOException;
}
