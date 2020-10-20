import java.io.Serializable;

class Student implements Serializable {
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "姓名：" + name + " 年龄：" + age;
	}
}