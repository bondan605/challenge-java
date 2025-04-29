package challengefinaloop;

import challengefinaloop.hr.Employee;
import challengefinaloop.hr.EmployeeType;

import java.util.List;

public interface HRService {
    List<Employee>  initEmployeeData();

    public void displayEmployee(List<Employee> emps);

    public void getTotalEmployee(List<Employee> emps);
    public void getTotalEmployeeByType(List<Employee> emps, EmployeeType empType);
}
