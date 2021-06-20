package test.com.seeker;

public class SeekerVO {

	// seeker 
	private int num;
	private String id;
	private String pw;
	private String name;
	private String gen;
	private String lang;
	private String home;
	private String career;
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

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}
	
	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	@Override
	public String toString() {
		return "SeekerVO [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", gen=" + gen + ", lang="
				+ lang + ", home=" + home + ", career=" + career + ", divi=" + divi + ", filename=" + filename + "]";
	}
	
	

}//endvo
