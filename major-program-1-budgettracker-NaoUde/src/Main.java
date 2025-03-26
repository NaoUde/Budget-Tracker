import java.io.File;

/**
 * Naomi Udenze
 * 4/15/25
 * Section 001
 * Main file to test the populating and display of all other attached files.
 */

public class Main {
    public static void main(String[] args) {
        Client jack = new Client("john", "Sprat");
        jack.setContact(new Contact("1345 Maple Avenue, Greensboro, NC 27408\n", "336-375-2446\n", "jsprat@ncat.edu\n"));
        jack.setBudget(new Budget());

        jack.loadClientFile(new File("budgetdataV3.txt"));
        jack.saveClientFile(new File("testfile.txt"));

        //System.out.println(jack.getTransactionReport());
        System.out.println(jack.getBudgetReport());


    }
}