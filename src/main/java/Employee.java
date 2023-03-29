class Employee{
    String name;
    int id;
    String state;
    Double salary;
    Double bonus;
    Double totalTax;
    Double salaryAfterTax;

    Employee(String name,String state,Double salary,Double bonus,int id){
        this.name=name;
        this.bonus=bonus;
        this.id=id;
        this.salary=salary;
        this.state=state;
        this.totalTax=0.0;
        this.salaryAfterTax=0.0;
    }
}
