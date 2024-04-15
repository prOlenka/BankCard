import java.util.Objects;

public class CreditCard extends BankCard{
    private Integer limit = 10000;
    private Integer creditBalance = limit;
    DebitCard debitCard = new DebitCard();
    Bonus bonus = new Bonus();
    Cashback cashback = new Cashback();
    Accumulation accumulation = new Accumulation();
    private Integer debitBalance = debitCard.getBalance();
    private Integer a;


    @Override
    public String fill(Integer income){                 // «Пополнить» — пополняет карту на переданную сумму;
        accumulation.countAccumulation(income);
        try {
            a = limit - creditBalance;
            if(creditBalance < limit) {
                if (income <= a) {
                    creditBalance = creditBalance + income;
                }else {
                    income = income - a;
                    creditBalance = creditBalance + a;

                    debitBalance = Integer.valueOf(debitCard.fill(income));
                    debitCard.setBalance(debitBalance);
                }
                a = 0;
            }else if (Objects.equals(creditBalance, limit)){
                debitBalance = Integer.valueOf(debitCard.fill(income));
                debitCard.setBalance(debitBalance);
            }
        }catch (IllegalArgumentException e){
            return ("Произошла ошибка. Попробуйте повторить операцию ещё раз");
        }
        return ("Баланс кредитной карты = " + creditBalance + "\nБаланс дебитовой карты = " + debitBalance);
    }

    @Override
    public Boolean payment(Integer income){             //«Оплатить» — списывает с карты переданную сумму и возвращает результат типа Boolean;
        bonus.countBonus(income);
        cashback.countCashback(income);
        try {
            if(debitBalance >= income) {
                if(new DebitCard().payment(income)) {
                    debitBalance = new DebitCard().getBalance();
                    debitCard.setBalance(debitBalance);
                    return true;
                }else return false;
            }else{
                income = income - debitBalance;
                creditBalance = creditBalance - income;
                return true;
                }
        }catch (IllegalArgumentException e){
            return false;
        }
    }


    @Override
    public Integer getBalance() {
        return debitBalance;
    }

    @Override
    public String getAllBalance() {                    //«Получить информацию о доступных средствах» — возвращает информацию о балансе, кредитном лимите и любых других средствах.
        return ("Доступные средства на дебитовой карте = " + debitBalance + "\nДоступные средства на кредитной карте = " + creditBalance + "\nБонус = " + bonus.getBonus() + "\nКэшБэк = " + cashback.getCashback() + "\nНакопления = " + String.format("%.2f",accumulation.getAccumulation()));
    }
}
