import java.io.*;
import java.util.Scanner;

class Employee implements Serializable{
	enum Designation {software_engg , senior_software_engg, lead_engg, head};
	int emp_id, salary;
	String name, vertical, team_name;
	Employee rm, buddy;
	public Employee()
	{
		this.name="name";
		this.emp_id=0;
		this.vertical="vertical";
		this.team_name="team_name";
		this.salary=0;
	}
	public Employee( String name, int emp_id, String vertical, String team_name, int salary)
	{
		this.name=name;
		this.emp_id=emp_id;
		this.vertical=vertical;
		this.team_name=team_name;
		this.salary=salary;
	}

	public void set(String name, int emp_id, String vertical, String team_name, int salary)
	{
		this.name=name;
		this.emp_id=emp_id;
		this.vertical=vertical;
		this.team_name=team_name;
		this.salary=salary;
	}

	public void show()
	{
		System.out.println("Employee name : " + name +"Employee id : "+emp_id+ "Vertical : "+vertical +"Team name : " +team_name+ "salary : "+salary);
	}

	public void setRM_Buddy(Employee rm, Employee buddy)
	{
		this.rm= rm;
		this.buddy= buddy;
	}

	public void showRM_Buddy()
	{
		System.out.println("RM for Employee "+ " " + name + ": "+ rm.name + "and buddy: "+buddy.name );
	}


	

	public void addEmployee(Employee e) throws Exception
	{
		FileOutputStream fos= new FileOutputStream("C:/Users/User/Desktop/java/Airtel/"+e.name+"txt");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(e);
		oos.close();
		System.out.println("Employee Added!");
	}

	public static void removeEmployee(String e) throws Exception
	{
		new FileOutputStream("C:/Users/User/Desktop/java/Airtel/"+e+"txt").close();
		File f=new File("C:/Users/User/Desktop/java/Airtel/"+e+"txt");
		if(f.delete())
		{
			System.out.println("Employee Removed!");
		}
	}

	
	// public void getEmployee() throws Exception
	// {
	// 	FileInputStream fis= new FileInputStream("airtel.txt");
	// 	ObjectInputStream ois= new ObjectInputStream(fis);

	// 	Employee x;
	// 	x= (Employee) ois.readObject();
	// 	x.show();
	// 	ois.close();
	// }
}

public class Airtel{
	public static void main(String args[]) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("If you want to add a employee press 1 or if you want to remove the employee press 2");
		int val=sc.nextInt();

		if(val==1)
		{
			System.out.println("Please enter employee's name, id, vertical, team name and salary");
			String name, vertical, team_name;
			int id, salary;
			name= sc.next();
			id= sc.nextInt();
			vertical =sc.next();
			team_name = sc.next();
			salary = sc.nextInt();
			Employee emp= new Employee(name, id, vertical, team_name, salary);
			emp.addEmployee(emp);

		}

		else if(val==2)
		{
			System.out.println("Please enter the employee name to remove");
			String name=sc.next();
			Employee.removeEmployee(name);
		}

		else
		{
			System.out.println("Please enter valid no.");
		}


	
	}
}