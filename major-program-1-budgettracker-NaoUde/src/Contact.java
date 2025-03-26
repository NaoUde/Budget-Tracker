/**
 * Naomi Udenze
 * 4/15/25
 * Section 001
 * Contact file containing all client personal information, including home address,
 * email, and phone number.
 */

public class Contact {
    //declare all variables privately before assignment
    private String homeAddress;
    private String phone;
    private String email;


    /**+
     * any provided information is used to then populate the current class object
     * @param hmAddress - home address
     * @param phone - phone number
     * @param email - contact email
     */
    public Contact(String hmAddress, String phone, String email){
        homeAddress = hmAddress;
        this.phone = phone;
        this.email = email;
    }

    //if no parameters are provided, each variable is given the default value
    public Contact(){
        homeAddress = null;
        phone = null;
        email = null;
    }
    /**+
     * to avoid direct changes, they can only be used through the accessor methods
     * @return - returns the contacts address
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**+
     *
     * @param homeAddress - provides a new home address
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**+
     *
     * @return - returns the contact's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**+
     *
     * @param phone - provides a new phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**+
     *
     * @return - returns the contact's email
     */
    public String getEmail() {
        return email;
    }

    /**+
     *
     * @param email - provides a new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**+
     * returns the object information presented on lines as a string
     * @return - returns a string form of the information
     */
    public String toString(){
        return(homeAddress + System.lineSeparator() + phone + System.lineSeparator() + email);
    }
}
