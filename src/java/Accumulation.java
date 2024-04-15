public class Accumulation extends BankCard { //Накопление в размере 0.005% от суммы пополнений.
    private double accumulation = 0;

    public double getAccumulation() {
        return accumulation;
    }

    public void setAccumulation(double accumulation) {
        this.accumulation = accumulation;
    }

    public void countAccumulation(Integer income){
        accumulation += (income * 0.005)/100;
        setAccumulation(accumulation);
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
