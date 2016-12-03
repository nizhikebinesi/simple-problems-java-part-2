package arrays_of_objects.payment;

import arrays_of_objects.exceptions.*;

/**
 *
 */
public class Payment implements Cloneable {
    private String fio;
    private int dd;
    private int mm;
    private int yy;
    private int payment;
/*
    Payment(String s, int payment) {
        this.fio = s;
        this.dd = 1;
        this.mm = 1;
        this.yy = 1;
        this.payment = payment;
    }
*/
    public Payment(String s, int dd, int mm, int yy, int payment) throws DateException, PaymentException {
        if (s == null || s.trim().equals("")) {
            throw new IllegalArgumentException("Fio is null or is equal to \"\" ");
        }
        this.fio = s.trim();

        String check = dayCheck(dd, mm, yy);

        if (!check.equals("OK")) {
            throw new DateException(check);
        }

        this.dd = dd;
        this.mm = mm;
        this.yy = yy;

        if (payment <= 0) {
            throw new PaymentException("Payment <= 0");
        }

        this.payment = payment;
    }

    public Payment() {
        this.fio = "John Brown";
        this.dd = 1;
        this.mm = 1;
        this.yy = 2001;
        this.payment = 1;
    }

    public Payment(Payment p) throws DateException, PaymentException {
        this.setFio(p.getFio().trim());
        this.setPayment(p.getPayment());
        this.setDd(p.getDd());
        this.setMm(p.getMm());
        this.setYy(p.getYy());
    }

    //clone

    private String dayCheck(int dd, int mm, int yy) {
        String s = "OK";
        if (yy <= 0) {
            return "Year is less than 0 or equals to 0";
        }
        if (mm > 12 || mm < 1) {
            return "Month is less than 1 or more than 12";
        }
        int x = mm;
        if (28 + (x + Math.floor(x/8)) % 2 + 2 % x + 2 * Math.floor(1/x) < dd && x != 2 || dd < 1) {
            return "Day is more than count of days in " + x +  " month or less than 1";
        }
        return s;
    }
/*
    Payment(String s, int mm, int yy, int payment) {
        this.fio = s;
        this.dd = 1;
        this.mm = mm;
        this.yy = yy;
        this.payment = payment;
    }

    Payment(String s, int yy, int payment) {
        this.fio = s;
        this.dd = 1;
        this.mm = 1;
        this.yy = yy;
        this.payment = payment;
    }
*/
    public void setFio(String s) {
        this.fio = s;
    }

    public void setDd(int dd) throws DateException {
        int x = this.mm;
        if (28 + (x + Math.floor(x/8)) % 2 + 2 % x + 2 * Math.floor(1/x) < dd && x != 2 || dd < 1) {
            throw new DateException("Day is more than count of days in " + x +  " month or less than 1");
        }
        this.dd = dd;
    }

    public void setMm(int mm) throws DateException {
        if (this.mm > 12 || this.mm < 1) {
            throw new DateException("Month is less than 1 or more than 12");
        }
        this.mm = mm;
    }

    public void setYy(int yy) throws DateException {
        if (yy <= 0) {
            throw new DateException("Year is less than 0 or equals to 0");
        }
        this.yy = yy;
    }

    public void setPayment(int payment) throws PaymentException {
        if (this.payment <= 0) {
            throw new PaymentException("Payment <= 0");
        }
        this.payment = payment;
    }

    public int getDd() {
        return this.dd;
    }

    public int getMm() {
        return this.mm;
    }

    public int getYy() {
        return this.yy;
    }

    public int getPayment() {
        return this.payment;
    }

    public String getFio() {
        return this.fio;
    }

    @Override
    public Payment clone() throws CloneNotSupportedException {
        try {
            Payment clone = (Payment)super.clone();
            clone.fio = this.fio;
            clone.dd = this.dd;
            clone.mm = this.mm;
            clone.yy = this.yy;
            clone.payment = this.payment;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Payment)) {
            return false;
       }
       if (!this.fio.equals(((Payment) obj).fio)) {
           return false;
       }
       if (this.dd != ((Payment)obj).dd) {
           return false;
       }
       if (this.mm != ((Payment)obj).mm) {
           return false;
       }
       if (this.yy != ((Payment)obj).yy) {
           return false;
       }
       return this.payment == ((Payment) obj).payment;
    }

    @Override
    public int hashCode() {
        final int p = 37;
        final int q = 13;
        int hash = q;
        hash = hash * p + this.dd;
        hash = hash * p + this.mm;
        hash = hash * p + this.yy;
        hash = hash * p + this.payment;
        hash = hash * p + this.fio.hashCode();
        return hash;
        //return super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("«%1s» дата: %2$d.%3$d.%4$d сумма: %5$d руб. %6$d коп.", this.fio, this.dd, this.mm, this.yy, this.payment / 100, this.payment % 100);
        //return "fio: " + this.fio + "; date:" + this.dd + "." + this.mm + "." + this.yy + "; payment = " + this.payment + " коп.";
    }
}
