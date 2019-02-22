package kr.or.ddit.rangers.model;

public class RangerVo {
	private String name; 
	private String alias;
	private int    age;	  
	
	public RangerVo() {
		
	}
	
	public RangerVo(String name, String alias, int age) {
		this.name = name;
		this.alias = alias;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "RangerVo [name=" + name + ", alias=" + alias + ", age=" + age
				+ "]";
	}

	public String getTest() {
		return this.alias;
	}
}