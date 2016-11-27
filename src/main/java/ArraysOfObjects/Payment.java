package ArraysOfObjects;

/**
 *
 */
public class Payment {
    private String fio;
    private int dd;
    private int mm;
    private int yy;
    private int payment;

    Payment(String s, int payment) {
        this.fio = s;
        this.dd = 1;
        this.mm = 1;
        this.yy = 1;
        this.payment = payment;
    }

    Payment(String s, int dd, int mm, int yy, int payment) {
        this.fio = s;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
        this.payment = payment;
    }

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

    public void setFio(String s) {
        this.fio = s;
    }

    public void setDd(int dd) throws NoFioExeption {
        this.dd = dd;
    }

    public void setMm(int mm) throws NoFioExeption {
        this.mm = mm;
    }

    public void setYy(int yy) throws NoFioExeption {
        this.yy = yy;
    }

    public void setPayment(int payment) throws NoFioExeption {
        this.payment = payment;
    }

    public int getDd() throws NoFioExeption {
        return this.dd;
    }

    public int getMm() throws NoFioExeption {
        return this.mm;
    }

    public int getYy() throws NoFioExeption {
        return this.yy;
    }

    public int getPayment() throws NoFioExeption {
        return this.payment;
    }

    public String getFio() {
        return this.fio;
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
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.fio + " : date:" + this.dd + "." + this.mm + "." + this.yy + " payment = " + this.payment;
    }
}
