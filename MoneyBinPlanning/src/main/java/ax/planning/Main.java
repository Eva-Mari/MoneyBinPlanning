package ax.planning;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String filepath = "prospects.txt";
        FileHandler fileHandler = new FileHandler(filepath);

        List<String> result = fileHandler.readFromFile();
        List<Customer> customers = fileHandler.createCustomerList(result);

        int counter = 1;

        for (Customer customer : customers) {


            System.out.println("*******************************************************************************************");
            System.out.print("\nProspect " + counter + ": " + customer.getName() + " wants to borrow "
                    + customer.getTotalLoan() + "€ for a period of " + customer.getYears() + " years and pay ");
            customer.setMonthlyPayment();
            System.out.printf("%.2f", customer.getMonthlyPayment());
            System.out.println(" each month.\n");
            counter++;

        }

        System.out.println("*******************************************************************************************");
    }
}
