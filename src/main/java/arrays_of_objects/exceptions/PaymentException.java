package arrays_of_objects.exceptions;

/**
 * Created by a on 11/29/16.
 */
public class PaymentException extends Exception {
    PaymentException () {
        super();
    }

    public PaymentException(String s) {
        super(s);
    }
}
