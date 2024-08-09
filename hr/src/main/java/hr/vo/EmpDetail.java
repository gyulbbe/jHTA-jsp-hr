package hr.vo;

import java.util.Date;

public class EmpDetail {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private double salary;
	private double commissionPct;
	private String jobId;
	private Date hireDate;
	private int deptId;
	private String deptName;
	private int managerId;
	private String city;
	private double annualSalary;
	private String salaryGrade;
	private String deptManagerFirstName;
	private String deptManagerLastName;
	
	public EmpDetail() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double d) {
		this.salary = d;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int i) {
		this.managerId = i;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double d) {
		this.annualSalary = d;
	}

	public String getSalaryGrade() {
		return salaryGrade;
	}

	public void setSalaryGrade(String salaryGrade) {
		this.salaryGrade = salaryGrade;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDeptManagerFirstName() {
		return deptManagerFirstName;
	}

	public void setDeptManagerFirstName(String deptManagerFirstName) {
		this.deptManagerFirstName = deptManagerFirstName;
	}

	public String getDeptManagerLastName() {
		return deptManagerLastName;
	}

	public void setDeptManagerLastName(String deptManagerLastName) {
		this.deptManagerLastName = deptManagerLastName;
	}

}
