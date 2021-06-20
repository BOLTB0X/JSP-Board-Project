package test.com.company;

public class CompanyVO {

	// num,id,pw,name,tel
	private int num;
	private String id;
	private String pw;
	private String name;
	private String work;
	private String tel;
	private String loca;
	private String salary;
	private String divi;
	private String filename;
	
	public String getDivi() {
		return divi;
	}

	public void setDivi(String divi) {
		this.divi = divi;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getLoca() {
		return loca;
	}

	public void setLoca(String loca) {
		this.loca = loca;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "CompanyVO [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", work=" + work + ", tel="
				+ tel + ", loca=" + loca + ", salary=" + salary + ", divi=" + divi + ", filename=" + filename + "]";
	}

}
