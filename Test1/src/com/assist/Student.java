package com.assist;

public class Student {
	
	private int age;
	private String name;
	public void Student(){}
	public void Student(int age,String name)
	{
		this.age=age;
		this.name=name;
	}
	/* £¨·Ç Javadoc£©
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", toString()=" + super.toString() + "]";
	}
	
	
}
