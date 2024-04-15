import java.util.Objects;
import java.util.Scanner;

public class BankCardApplication {
    public static void main(String[] args) {
        String answer = "Д";
        CreditCard creditCard = new CreditCard();


        while(answer.equalsIgnoreCase("Д")){

            System.out.println("Введите номер услуги, которую необходимо выполнить" +
                    "\n1  -  Пополнить" + "\n2  -  Оплатить" + "\n3  -  Получить информацию о балансе" + "\n4  -  Получить информацию о доступных средствах");
            Scanner console = new Scanner(System.in);
            String digit = console.nextLine();

            int sum = 0;
            switch (Integer.parseInt(digit)) {
                case 1:
                    System.out.println("Введите сумму на которую вы бы хотели пополнить счёт");
                    sum = Integer.parseInt(console.nextLine());
                    System.out.println("1" + sum);
                    creditCard.fill(sum);
                    break;
                case 2:
                    System.out.println("Введите сумму оплаты");
                    sum = Integer.parseInt(console.nextLine());
                    creditCard.payment(sum);
                    break;
                case 3:
                    System.out.println("Баланс = " +  creditCard.getBalance());;
                    break;
                case 4:
                    System.out.println(creditCard.getAllBalance());
                    break;
            }

            answer = console();
        }
    }


    private static String console(){
        System.out.println("Хотите ли вы продолжить операции со счётом? Д / Н");
        return new Scanner(System.in).nextLine();
    }
}