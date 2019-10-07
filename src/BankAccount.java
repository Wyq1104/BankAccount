import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount extends Measurable {
    private float balance;
    private float rate;

    public BankAccount(float rate) {
        this.balance = 0;
        this.rate = rate;
    }

    public BankAccount(float balance, float rate) {
        this.balance = balance;
        this.rate = rate;
    }

    public float processYear() {
        this.balance = balance * (1 + rate);
        return this.balance;
    }

    public float processNYears(int n) {
        for (int i = 0; i < n; i++) {
            processYear();
        }
        return this.balance;
    }

    @Override
    public float getMeasure() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Balance: "+ balance+" Rate: "+ rate;
    }
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount(1000, .1f);
        BankAccount account2 = new BankAccount(2000, .1f);
        BankAccount account3 = new BankAccount(3000, .1f);

        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(account2);
        bankAccounts.add(account1);
        bankAccounts.add(account3);
        Collections.sort(bankAccounts);
        System.out.println(bankAccounts);
        float average = Measurable.average(bankAccounts);
        System.out.println(average);
    }
}
