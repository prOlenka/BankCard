public class Bonus extends BankCard { //Бонусные баллы в размере 1% от покупок.
    private double bonus = 0;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void countBonus(Integer expenses){
        bonus += expenses * 0.01;
        setBonus(bonus);
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
