package ax.planning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final File file;

    /**
     * Constructor.
     * @param pathName, the path name for the file.
     * */

    public FileHandler(String pathName){
        file = new File(pathName);
    }

    /**
     * Method to read content from file, and adds the strings read into a list.
     * Uses a fileReader and BufferedReader.
     * The method will also remove any "" found.
     * @return fileinputList, a List<String> containing the input from the file.
     * */

    public List<String> readFromFile(){

        List<String> fileinputList = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String resultLine;

            while ((resultLine = bufferedReader.readLine()) != null) {

                if(resultLine.contains("\"")){
                    resultLine = resultLine.replaceAll("\"", "");
                }

                fileinputList.add(resultLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileinputList;

    }

    /**
     * Method to remove unnecessary input, create customer-objects,
     * and add them to a list of customers.
     * @return List<Customer> prospectList
     * */

    public List<Customer> createCustomerList(List<String> fileinputList){

        List<Customer> prospectList = new ArrayList<>();

        //  Should remove the first line, since it doesn't contain any relevant info

        for(int i = 1; i < fileinputList.size(); i++) {

            if(!fileinputList.get(i).isBlank() && !fileinputList.get(i).equals(".")) {
                String[] resultString = fileinputList.get(i).split(",");

                Customer customer = new Customer();

                String name = resultString[0];

                //If there are fist- and lastname (separated) in file
                if(!Character.isDigit(resultString[1].charAt(1))){

                    name = name+" "+resultString[1];
                    customer.setName(name);
                    customer.setTotalLoan(Double.parseDouble(resultString[2]));
                    customer.setInterest(Double.parseDouble(resultString[3]));
                    customer.setYears(Double.parseDouble(resultString[4]));

                }else {

                    customer.setName(name);
                    customer.setTotalLoan(Double.parseDouble(resultString[1]));
                    customer.setInterest(Double.parseDouble(resultString[2]));
                    customer.setYears(Double.parseDouble(resultString[3]));
                }

                prospectList.add(customer);

            }
        }

        return prospectList;

    }

}