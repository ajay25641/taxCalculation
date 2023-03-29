import java.util.ArrayList;
import java.util.HashMap;

public class CalculateTax {
    static HashMap<String,Double> taxSlab=new HashMap<>();
    static{
        taxSlab.put("delhi",10d);
        taxSlab.put("up",25d);
        taxSlab.put("bihar",15d);
        taxSlab.put("goa",30d);
        taxSlab.put("rajasthan",12d);
    }
    public void calculateTax(ArrayList<Employee> arr){
        for(Employee emp:arr){
            Double tax = taxSlab.get(emp.state);
            if(tax==null) continue;
            double bonusPercent=emp.bonus;
            double salary=emp.salary;

            //bonus calculation
            double bonusAmount=salary*bonusPercent/100;
            double bonusAfterTax=bonusAmount*(1-0.32);

            //salary calculation
            double salaryAfterTax=salary*(1-tax/100);


            //tax calculation
            double totalTax=(salary-salaryAfterTax) + (bonusAmount-bonusAfterTax);

            emp.salaryAfterTax=salaryAfterTax;
            emp.totalTax=totalTax;
        }
    }
}
