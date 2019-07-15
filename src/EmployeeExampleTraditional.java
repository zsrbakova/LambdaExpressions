import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeExampleTraditional {


    private static boolean checkCondition(Employee e)
    {

        return e.getCity().equals("Bitola") && e.getSalary()>=800;
    }

    private static boolean checkConditionTwo(Employee e)
    {

        return e.getCity().equals("Skopje");
    }



    public static void main(String []args)
    {
        int counter=0;
        int SumOfSalaries=0;
        List<Employee> employeeList=GenerateEmployees.generateEmployees(30);

        //filter the employees that have salary> 900 euros and live in Skopje
        //show them grouped by their working position

        Map<String,List<Employee>> employeesByPosition=new HashMap<>();
        Map<String,List<Employee>> employeesByPosition2=new HashMap<>();
        Map<String,List<Employee>> employeesByPosition3=new HashMap<>();

        for(int i=0;i<employeeList.size();++i) {


            Employee e = employeeList.get(i);
            for(int j=0;j<employeeList.size();++j) {
                Employee e1 = employeeList.get(j);
                if (e.getSalary() > e1.getSalary()) {

                    String name1=e.getName();
                    e.setName(e1.getName());
                    String city1=e.getCity();
                    e.setCity(e1.getCity());
                    int salary1=e.getSalary();
                    e.setSalary(e1.getSalary());
                    String working1=e.getWorkingPosition();
                    e.setWorkingPosition(e1.getWorkingPosition());
                    e1.setName(name1);
                    e1.setCity(city1);
                    e1.setSalary(salary1);
                    e1.setWorkingPosition(working1);


                }
                else
                {
                    ;;
                }
            }

                if (!employeesByPosition3.containsKey(e.getWorkingPosition())) {
                    employeesByPosition3.put(e.getWorkingPosition(), new ArrayList<>());
                }

                employeesByPosition3.get(e.getWorkingPosition()).add(e);


        }
            for(int i=0;i<employeeList.size();++i)
            {


                Employee e=employeeList.get(i);
            if(checkConditionTwo(e))
            {

                if(!employeesByPosition2.containsKey(e.getWorkingPosition()))
                {
                    employeesByPosition2.put(e.getWorkingPosition(),new ArrayList<>());
                }

                employeesByPosition2.get(e.getWorkingPosition()).add(e);
                SumOfSalaries+=e.getSalary();

            }
        }

        for(int i=0;i<employeeList.size();++i) {

            Employee e = employeeList.get(i);
            if (checkCondition(e)) {
                counter++;
                if (!employeesByPosition.containsKey(e.getWorkingPosition())) {
                    employeesByPosition.put(e.getWorkingPosition(), new ArrayList<>());
                }

                employeesByPosition.get(e.getWorkingPosition()).add(e);

            }
        }


        for(Map.Entry<String,List<Employee>> entry :employeesByPosition.entrySet())
    {
        System.out.println(entry.getKey()+" - "+entry.getValue());

    }
        System.out.println("The number of emplyees that live in Bitola and have salary greather than 800e is: "+counter);
        System.out.println("\n");
        for(Map.Entry<String,List<Employee>> entry :employeesByPosition2.entrySet())
        {
            System.out.println(entry.getKey()+" - "+entry.getValue());

        }
        System.out.println("The sum of the salaries of all employees who live in Skopje is: "+SumOfSalaries);
        System.out.println("\n");
        System.out.println("The employees sorted by salaries in ascending order: ");
        for(Map.Entry<String,List<Employee>> entry :employeesByPosition3.entrySet())
        {
            System.out.println(entry.getKey()+" - "+entry.getValue());

        }

    }
}