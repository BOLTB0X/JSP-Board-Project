package test.com.sboard;

import java.util.Date;

public class SboardVO {
	private int num;
	private String title;
	private String content;
	private String writer;
	private Date wdate;
	private String str_wdate;
	private int cnt;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getStr_wdate() {
		return str_wdate;
	}
	public void setStr_wdate(String str_wdate) {
		this.str_wdate = str_wdate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "SboardVO [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer + ", wdate="
				+ wdate + ", str_wdate=" + str_wdate + ", cnt=" + cnt + "]";
	}
	
	
}//end
