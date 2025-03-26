import java.util.ArrayList;

/**
 * Naomi Udenze
 * 4/15/25
 * Section 001
 * Budget Category file used to provide categories for each type of transaction
 * as well as related information to classify them
 */

public class BudgetCategory {
    //declare all variables privately before assignment
    private String catName;
    private String catDescription;
    private double amount;
    private int categoryType;

    /**+
     * if no parameters are provided, each variable is given the default value
     */
    public BudgetCategory(){
        catName = null;
        catDescription = null;
        amount = 0;
        categoryType = 0;
    }

    /**+
     * parameters, if provided, are used to then populate the current class object
     * @param cn
     * @param cd
     * @param amt
     * @param type
     */
    public BudgetCategory(String cn, String cd, double amt, int type){
        catName = cn;
        catDescription = cd;
        amount = amt;
        categoryType = type;
    }

    //to avoid direct changes, instance vars can only be used through the accessor methods

    /**+
     *
     * @return
     */
    public String getCatName() {
        return catName;
    }

    /**+
     *
     * @param catName
     */
    public void setCatName(String catName) {
        this.catName = catName;
    }

    /**+
     *
     * @return
     */
    public String getCatDescription() {
        return catDescription;
    }

    /**+
     *
     * @param catDescription
     */
    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    /**+
     *
     * @return
     */
    public double getAmount() {
        return amount;
    }

    /**+
     *
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**+
     *
     * @return
     */
    public int getCategoryType() {
        return categoryType;
    }

    /**+
     *
     * @param categoryType
     */
    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    //returns the object information presented on lines as a string
    /**+
     *
     * @return
     */
    public String toString(){
        return (amount + " " + categoryType + " " + catName + "\n" + catDescription);
    }
}
