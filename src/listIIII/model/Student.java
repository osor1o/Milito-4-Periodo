package listIIII.model;

public class Student {

	private int id;
	private String name;
	private String email;
	private String cellPhone;
	
	public Student(int id, String name, String email, String cellPhone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cellPhone = cellPhone;
	}

	public Student(String name, String email, String cellPhone) {
		super();
		this.name = name;
		this.email = email;
		this.cellPhone = cellPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public int getId() {
		return id;
	}
	
}
