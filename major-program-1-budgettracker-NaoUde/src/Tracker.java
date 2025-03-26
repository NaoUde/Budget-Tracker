import java.util.ArrayList;
/**
 * Naomi Udenze
 * 4/28/25
 * Section 001
 * Tracker class to record all transactions loaded into the client as well as the final balance of the account
 */
public class Tracker {
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private double balance;

    /**
     * No-arg constructor to set the default balance to 0
     */
    public void Tracker(){
        balance = 0;
    }

    //Encapsulation accessors and mutators
    public int getTransactionsSize() {
        return transactions.size();
    }

    public Transaction getTransaction(int index) {
        return (transactions.get(index));
    }

    public void setTransactions(int index, Transaction item) {
        transactions.set(index, item);
    }

    public void addTransaction(Transaction item){
        transactions.add(item);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * toString method to return a list of all stored transactions in the Tracker class
     * @returns a string format of the list
     */
    public String toString(){
        String str = "";
        for(Transaction transaction : transactions){
            str += transaction.toString() + "\n";
        }

        return(str);
    }
}
