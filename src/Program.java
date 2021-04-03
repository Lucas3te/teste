import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employees;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Employees employees;

		List<Employees> lista = new ArrayList<>();

		String name;
		int id, n;
		double salary;
		int increase, idIncrease;

		System.out.print("How many employees will be registered? ");
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + ": ");
			System.out.print("Id: ");
			id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Salary: ");
			salary = sc.nextDouble();
			employees = new Employees(id, name, salary);
			lista.add(employees);
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		idIncrease = sc.nextInt();

		employees = lista.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);

		if (employees == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter de percentage: ");
			increase = sc.nextInt();
			employees.increaseSalary(increase);
		}

		System.out.println();
		System.out.println("List of employees: ");
		for (Employees x : lista) {
			System.out.println(x);
		}

	}

}
