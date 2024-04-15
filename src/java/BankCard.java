import java.io.IOException;

public abstract class BankCard {

    public abstract String fill(Integer sum);
    public abstract Boolean payment(Integer sum);
    public abstract Integer getBalance();
    public abstract String getAllBalance();
}