/**
 * Naomi Udenze
 * 4/15/25
 * Section 001
 * Transaction Category to record every unique transaction, as well
 * as all related information.
 */

public class Transaction {
    //declare all variables privately before assignment
    private String category;
    private String date;
    private double amount;
    private String description;

    /**
     * Transaction constructor
     * If no parameters are provided, each variable is given the default value
     */
    public Transaction(){
        category = null;
        date = null;
        amount = 0;
        description = null;
    }

    /**+
     * Transaction constructor (Populated)
     * If no parameters are provided, each variable is given the default value
     * @param dt - date
     * @param amt - amount in transaction
     * @param desc - transaction description
     */
    //parameters, if provided, are used to then populate the current class object
    public Transaction(String dt, double amt, String desc){
        category = null;
        date = dt;
        amount = amt;
        description = desc;
    }

    /**+
     * to avoid direct changes, instance vars can only be used through the accessor method
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**+
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**+
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**+
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
    public String getDescription() {
        return description;
    }

    /**+
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**+
     * returns the object information presented on lines as a string
     * @return
     */
    public String toString(){
        return (category + "\n" + date + " " + amount + "\n" + description);
    }
}
