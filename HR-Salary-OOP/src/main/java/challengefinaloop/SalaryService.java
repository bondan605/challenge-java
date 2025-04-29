package challengefinaloop;

import challengefinaloop.hr.Employee;
import challengefinaloop.hr.EmployeeType;

import java.util.List;

public interface SalaryService {

    public void generateOvertime(List<Employee> emps);
    public void generateInsurance(List<Employee> emps);
    public void generateOperational(List<Employee> emps);
    public void generateTax(List<Employee> emps);


    public void generateSalary(List<Employee> emps);
    public void getTotalAllowances(List<Employee> emps);
    public void getTotalSalaryByType(List<Employee> emps, EmployeeType empType);
}
