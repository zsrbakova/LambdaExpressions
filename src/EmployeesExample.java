import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeesExample {


    public static void main(String []args)
    {

        List<Employee> employeeList = GenerateEmployees.generateEmployees(30);

        //filter the employees that have salary> 900 euros and live in Skopje
        //show them grouped by their working position

        Map<String,List<Employee>> map=employeeList.stream()
            .filter(employee -> employee.getCity().equals("Bitola") && employee.getSalary()>800)
            .collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));

        System.out.println(map.entrySet()
            .stream()
            .map(entry->entry.getKey()+" - "+entry.getValue().toString())
            .collect(Collectors.joining("\n","","\n")));

    }
}

