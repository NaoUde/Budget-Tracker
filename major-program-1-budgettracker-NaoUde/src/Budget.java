/**
 * Naomi Udenze
 * 4/28/25
 * Section 001
 * Budget class to store all information related to the client's budget, including
 * the amounts allocated to expenses, the total income, and all recorded categories
 */

import java.util.ArrayList;

public class Budget {
    private ArrayList<BudgetCategory> categories = new ArrayList<BudgetCategory>();
    private double totalAllocated;
    private double totalIncome;

    /**
     * no-arg Budget Constructor, sets with default values
     */
    public void Budget(){
        categories = new ArrayList<BudgetCategory>();
        totalAllocated = 0;
        totalIncome = 0;
    }

    /**
     *
     * @return the total balance
     */
    public double getAllocationBalance(){
        return(totalIncome-totalAllocated);
    }

    /**
     * @return a list of all budget categories and the total amount
     */
    public String toString(){
        String inc = "";
        String exp = "";
        for(BudgetCategory budCat : categories){
            if(budCat.getCategoryType() == 0) {
                inc += budCat.toString() + ": " + budCat.getAmount() + "\n";
            } else{
                exp += budCat.toString() + ": " + budCat.getAmount() + "\n";
            }
        }
        return (inc + "\n" + exp);
    }


    //ArrayList mutators/accessors
    public int getCategoriesSize() {
        return categories.size();
    }

    public BudgetCategory getCategories(int index) {
        return (categories.get(index));
    }

    public void setCategories(int index, BudgetCategory item) {
        categories.set(index, item);
    }

    public void addCategory(BudgetCategory item){
        categories.add(item);
        if(item.getCategoryType() == 0){
            totalAllocated += item.getAmount();
        } else {
            totalIncome += item.getAmount();
        }
    }

    public BudgetCategory removeCategory(int index){
        return (categories.remove(index));
    }


    //encapsulation mutators/accessors
    public double getTotalAllocated() {
        return totalAllocated;
    }

    public void setTotalAllocated(double totalAllocated) {
        this.totalAllocated = totalAllocated;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }
}
