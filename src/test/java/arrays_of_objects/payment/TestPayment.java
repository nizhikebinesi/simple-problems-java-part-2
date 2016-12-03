package arrays_of_objects.payment;

import arrays_of_objects.exceptions.DateException;
import arrays_of_objects.exceptions.PaymentException;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by a on 12/3/16.
 */
public class TestPayment {
    private Payment payment;

    @Before
    public void setUp() {

    }

    @Test(expected = DateException.class)
    public void testDateException() throws DateException, PaymentException {
        this.payment = new Payment("Ivanov Ivan", 1, 123, 2, 2);
    }

    @Test(expected = PaymentException.class)
    public void testPaymentException() throws DateException, PaymentException {
        this.payment = new Payment("Ivanov Ivan", 1, 3, 2, -42);
    }
}
