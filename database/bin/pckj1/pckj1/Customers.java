package pckj1;

public class Customers implements Comparable<Customers> {

	private int id;
	private String name;
	private int age;
	private String address;
	private int salary;

	public Customers() {

	}

	public Customers(int id, String name, int age, String address, int salary) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;

	}

	public int compareTo(Customers other) {

		return Integer.compare(this.id, other.id);

		// Alternativa
		// return
		// Integer.valueOf(this.intValue).compareTo(Integer.valueOf(other.intValue));

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", age=" + age + ", indirizzo=" + address + ", salario="
				+ salary + "]";
	}

}
