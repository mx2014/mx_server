package pojo;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="emp")
public class Emp {

	private String name;  
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	

}
