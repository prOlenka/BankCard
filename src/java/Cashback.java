public class Cashback extends BankCard {
    public Cashback() {
    } //Потенциальный кэшбэк 5% от покупок при условии трат больше 5 000 тыс.

    private Integer e = 0;

    private double cashback;

    public double getCashback() {
        return cashback;
    }

    public void setCashback(double cashback) {
        this.cashback = cashback;
    }


    public void countCashback(Integer expenses){
        e += expenses;
        if(e > 5000){
            cashback = e * 0.05;
            setCashback(cashback);
        }

    }

    @Override
    public String fill(Integer sum) {
        return null;
    }

    @Override
    public Boolean payment(Integer sum) {
        return null;
    }

    @Override
    public Integer getBalance() {
        return null;
    }

    @Override
    public String getAllBalance() {
        return null;
    }
}
