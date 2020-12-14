package com.javaex.ex01;

public class Person {
	//field
	
	private String name;
	private String hp;
	private String company;
	private int number;
	//constructor
	
	public Person(String name, String hp, String company) {
		this();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public Person() {
		number= 0;
	}

	//method g/s
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public void setNumber(int number) {
		this.number+= number;
	}
	
	//method
	
	public void draw() {
		System.out.println(number +".    "+name + "   " + hp + "     "+ company);
		
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
	
	
	
	
	
	
}
