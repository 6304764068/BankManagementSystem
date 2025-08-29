package com.bank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankManagementSystemApplication.class, args);	
		
		

		List<Employee> li = Arrays.asList(
				new Employee(100, "ashok", "male"),
				new Employee(200, "kumar", "male"),
				new Employee(150, "rani", "female"),
				new Employee(200, "roja", "female"),
				new Employee(210, "lakshmi", "female")
				);
		
		Stream<Employee> female = li.stream().filter((emp)->emp.getGender().equals("female"));
		
//		Stream<Employee> sorted = female.sorted(Comparator.comparing(Employee :: getSal));
		
		Stream<Employee> emp = female.sorted(new Employee());
		System.out.println(emp.findFirst());
		
//		sorted.forEach(n->System.out.println(n));
		
		
//		Optional<Employee> res =  female.max(Comparator.comparing(Employee :: getSal));
//		System.out.println(res.get());
		
	}

}


class Employee implements Comparator<Employee>{
	private int sal;
	private String gender;
	private String name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(int sal, String name, String gender) {
		this.sal = sal;
		this.name=name;
		this.gender= gender;
	}

	@Override
	public String toString() {
		return "Employee [sal=" + sal + ", gender=" + gender + ", name=" + name + "]";
	}


	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getSal()-o1.getSal();
	}



	
}
