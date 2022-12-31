package ax.planning;
public class Customer {

    private String name;
    private double totalLoan;
    private double interest;
    private double years;

    private double monthlyPayment;

    private MortgageModel mortgageModel;

    public Customer(){}

    public Customer(String name, double totalLoan, double interest, double years){

        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
        mortgageModel = new MortgageModel(interest, totalLoan, years);
        monthlyPayment = mortgageModel.calculateMortgageFormula();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getYears() {
        return years;
    }

    public void setYears(double years) {
        this.years = years;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment() {
        mortgageModel = new MortgageModel(interest, totalLoan, years);
        monthlyPayment = mortgageModel.calculateMortgageFormula();
    }

    @Override
    public String toString(){
        return "Prospect "+name+": Total loan: "+totalLoan+", interest: "+interest +", years: "+years
                +" monthly payment: "+monthlyPayment;
    }
}
