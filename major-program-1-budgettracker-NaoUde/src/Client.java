/**
 * Naomi Udenze
 * 4/15/25
 * Section 001
 * Client file to track all Client unique information, contains instances
 * of Budget, Tracker, and Contact class
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    private String firstName;  //Client's first name
    private String lastName;  //Client's last name
    private Contact contact;  //Contact object containing all client information
    private Budget budget;  //The client's budget for the period
    private Tracker tracker;  //The object used to track

    /**
     * No-arg Client constructor.  Sets all vars to default values
     */
    public Client(){
        firstName = null;
        lastName = null;
        contact = new Contact();
        budget = new Budget();
        tracker = new Tracker();
    }

    /**
     * @param fname - client's first name
     * @param lname - client's last name
     */
    public Client(String fname, String lname){
        firstName = fname;
        lastName = lname;
        contact = new Contact();
        budget = new Budget();
        tracker = new Tracker();
    }

    /**
     * Reads the file into the program and respective classes
     * @param filename - the file to source information
     */
    public void loadClientFile(File filename){
        try {
            Scanner file = new Scanner(filename);
            this.firstName = file.nextLine();
            this.lastName = file.nextLine();
            contact.setHomeAddress(file.nextLine());
            contact.setPhone(file.nextLine());
            contact.setEmail(file.nextLine());

            double amnt = file.nextDouble();
            int type;
            String name;
            String description;
            BudgetCategory bud;
            Transaction tr;

            String date;

            while(amnt != 0.0){
                type = file.nextInt();
                name = file.nextLine();
                description = file.nextLine();
                bud = (new BudgetCategory(name,description, amnt, type));
                budget.addCategory(bud);

                amnt = file.nextDouble();
            }
            file.nextLine();

            while(file.hasNext()){
                name = file.nextLine();
                tr = (new Transaction(file.next(), file.nextDouble(), file.nextLine()+file.nextLine()));
                tracker.addTransaction(tr);
                tr.setCategory(name);
            }

            file.close();

        } catch(FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    /**
     * Formats all transactions into a single report
     * @return a string containing the report
     */
        public String getTransactionReport(){
        String str = "Transaction Report\n" + firstName + "" + lastName + "\n" + contact.toString() + "\n";
        String tran;
        String cat;
        double amnt = 0;

        for(int i = 0; i < budget.getCategoriesSize(); i++) {
            cat = budget.getCategories(i).getCatName().strip();
            str += "\nBudget Category: " + cat + "\nAllocated Budget Amount: " + budget.getCategories(i).getAmount() + "\n";

            for(int sep = 0; sep < 50; sep++){str += "-";}
            str += (String.format("%-" + 15 + "s","\nDate") + String.format("%-" + 10 + "s","Amount") + "Description\n");
            for(int sep = 0; sep < 50; sep++){str += "-";}
            str += "\n";

            for (int t = 0; t < tracker.getTransactionsSize(); t++) {
                tran = tracker.getTransaction(t).getCategory().strip();
                if (tran.equals(cat)) {
                    str += (String.format("%-" + 15 + "s",tracker.getTransaction(t).getDate())
                            +String.format("%-" + 10 + "s",String.format("%.2f",tracker.getTransaction(t).getAmount()))
                            +tracker.getTransaction(t).getDescription()+ "\n");
                    amnt += tracker.getTransaction(t).getAmount();
                }
            }
            str += "Remaining Balance for " + cat + ": " + String.format("%.2f",budget.getCategories(i).getAmount() - amnt) + "\n";
            amnt = 0;
        }

        return str;
    }

    /**
     * Writes all information for a client into a file
     * @param filename - the name of the file to be updated
     */
    public void saveClientFile(File filename){
        try {
            FileWriter file = new FileWriter(filename);
            file.write(this.firstName + "\n" + this.lastName  + "\n" + contact.getHomeAddress()
                    + "\n" + contact.getPhone() + "\n" + contact.getEmail() + "\n");
            for(int i = 0; i < budget.getCategoriesSize(); i++){
                file.write(budget.getCategories(i).toString() + "\n");
            }
            file.write("0" + "\n");

            for(int i = 0; i < tracker.getTransactionsSize(); i++){
                file.write(tracker.getTransaction(i).toString() + "\n");
            }

            file.close();

        } catch (IOException ex) {
            System.out.println("An error has occurred!");
        }
    }

    /**
     * Formats all the budget categories into a single report containing relevant balances and total balances
     * @return the string containing the report
     */
    public String getBudgetReport(){
        String str = firstName + " " + lastName + "\n" + contact.toString() + "\n";
        for(int sep = 0; sep < 50; sep++){str += "-";}

        String exp = "\nExpenses\n";
        String inc = "\nIncome\n";

        for(int i = 0; i < budget.getCategoriesSize(); i++) {
            if (budget.getCategories(i).getCategoryType() == 0) {
                exp += String.format("%-" + 15 + "s",budget.getCategories(i).getCatName()) + String.format("%" + 10 + "s  ",String.format("%.2f",budget.getCategories(i).getAmount()))
                        + budget.getCategories(i).getCatDescription() + "\n";
            } else {
                inc += String.format("%-" + 15 + "s",budget.getCategories(i).getCatName()) + String.format("%" + 10 + "s  ",String.format("%.2f",budget.getCategories(i).getAmount()))
                        + budget.getCategories(i).getCatDescription() + "\n";
            }
        }
        str += exp + "Total Allocated: $" + budget.getTotalAllocated() + "\n";

        for(int sep = 0; sep < 50; sep++){str += "-";}
        str += inc + "Total Income: $" + String.format("%.2f",budget.getTotalIncome()) + "\n\n" + "Total Balance: $" + String.format("%.2f",tracker.getBalance());

        return str;
    }

    /**
     * Formats the client information into one string to be viewed
     * @return a string containing all categories and transactions
     */
    public String toString(){
        String str = firstName + System.lineSeparator() + lastName + System.lineSeparator() + this.getContact().toString() + System.lineSeparator();
        for(int i = 0; i < budget.getCategoriesSize(); i++){
            str += budget.getCategories(i).toString() + "\n";
        }
        str += "0" + System.lineSeparator();
        for(int i = 0; i < tracker.getTransactionsSize(); i++) {
            str+= tracker.getTransaction(i).toString() + "\n";
        }
        return str;
    }


    //Accessors and Mutators
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
