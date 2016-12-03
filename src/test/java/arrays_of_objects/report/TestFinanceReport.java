package arrays_of_objects.report;

import static arrays_of_objects.Month.month;
import static org.junit.Assert.assertEquals;

import arrays_of_objects.Month;
import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
import arrays_of_objects.payment.Payment;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by a on 11/29/16.
 */
public class TestFinanceReport {
    private FinanceReport fr;
    private final int N = 7;
    private  static final Map<Integer, String> month1 = new HashMap<Integer, String>(){{
        put(2, "Февраль");
        put(3, "Март");
        put(4, "Апрель");
        put(5, "Май");
        put(6, "Июнь");
        put(7, "Июль");
        put(8, "Август");
        put(9, "Сентябрь");
        put(10, "Октябрь");
        put(11, "Ноябрь");
        put(12, "Декабрь");
    }};

    @Before
    public void setUp() throws PaymentException, DateException {
        this.fr = new FinanceReport(N);
    }

    @Test
    public void testWritePaymentsBeginningOnTheSymbol1() {
        FinanceReport fr1 = this.fr.writePaymentsBeginningOnTheSymbol('J');
        assertEquals(this.fr, fr1);
    }

    @Test
    public void testWritePaymentsBeginningOnTheSymbol2() throws PaymentException, DateException {
        Payment[] payments = new Payment[3];
        payments[0] = new Payment("a", 1, 1, 2000, 2390);
        payments[1] = new Payment("b", 2, 3, 2000, 21);
        payments[2] = new Payment("c", 5, 7, 1999, 1);
        this.fr = new FinanceReport(payments);
        FinanceReport fr1 = this.fr.writePaymentsBeginningOnTheSymbol('a');
        Payment[] payments1 = new Payment[1];
        payments1[0] = payments[0];
        FinanceReport fr2 = new FinanceReport(payments1);
        assertEquals(fr2, fr1);
    }

    @Test
    public void testWriteSumOfPaymentsOnThisDate() throws DateException {
        int value = this.fr.writeSumOfPaymentsOnThisDate("1.1.2001");
        assertEquals(N + "", value + "");
    }

    @Test
    public void testMonthsWhenWasNoPaymentsThisYear() {
        StringJoiner sj = new StringJoiner("\n");

        sj.add("Список названий месяцев, в которых не было ни одного платежа:");

        for (Integer key : month1.keySet()) {
            sj.add(month1.get(key));
        }

        sj.add("");

        assertEquals(sj.toString(), this.fr.monthsWhenWasNoPaymentsThisYear(2001));
    }
}
