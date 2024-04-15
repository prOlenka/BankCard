public class DebitCard extends BankCard{
    private Integer balance = 100;


    @Override
    public String fill(Integer sum){                 // «Пополнить» — пополняет карту на переданную сумму;
        try {
            balance = balance + sum;
        }catch (IllegalArgumentException e){
            return ("Произошла ошибка. Попробуйте повторить операцию ещё раз");
        }
        return String.valueOf(balance);
    }

    @Override
    public Boolean payment(Integer sum){             //«Оплатить» — списывает с карты переданную сумму и возвращает результат типа Boolean;
        try {
            balance = balance - sum;
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    @Override
    public Integer getBalance() {                       //«Получить информацию о балансе»;
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String getAllBalance() {
        return null;
    }
}
