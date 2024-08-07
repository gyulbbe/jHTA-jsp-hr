package hr.vo;

public class DeptList {

	private int id;
	private String name;
	private String managerName;
	private String city;
	private int cnt;
	
	public DeptList() {}

	public DeptList(int id, String name, String managerName, String city, int cnt) {
		this.id = id;
		this.name = name;
		this.managerName = managerName;
		this.city = city;
		this.cnt = cnt;
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

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}