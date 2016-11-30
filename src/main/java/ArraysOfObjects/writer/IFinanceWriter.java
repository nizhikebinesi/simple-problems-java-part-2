package ArraysOfObjects.writer;

import ArraysOfObjects.report.FinanceReport;

import java.io.IOException;

/**
 * Created by a on 11/29/16.
 */
public interface IFinanceWriter {
    void write(FinanceReport fr) throws IOException;
    void close() throws IOException;
}
