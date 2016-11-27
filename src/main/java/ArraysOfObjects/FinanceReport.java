package ArraysOfObjects;

import java.io.ObjectInputStream;

/**
 *
 */
public class FinanceReport {
    private Payment[] arr;

    public int countOfPayments() {
        return arr.length;
    }

    public void setFioIthPayment(int i, String fio) {
        arr[i].setFio(fio);
    }

    public void setDdIthPayment(int i, int dd) throws NoFioExeption {
        arr[i].setDd(dd);
    }

    public void setMmIthPayment(int i, int mm) throws NoFioExeption {
        arr[i].setMm(mm);
    }

    public void setYyIthPayment(int i, int yy) throws NoFioExeption {
        arr[i].setYy(yy);
    }


    public void setPaymentIthPayment(int i, int payment) throws NoFioExeption {
        arr[i].setPayment(payment);
    }
}
