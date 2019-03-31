package bbs.entity;

import java.sql.Date;

public class BbsEntity {
	private int bbs_no;
	private String bbs_tit;
	private String bbs_user;
	private Date bbs_date;
	private String bbs_con;
	private int bbs_up;
	private int bbs_do;
	
	
	
	public BbsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BbsEntity(int bbs_no, String bbs_tit, String bbs_user, Date bbs_date, String bbs_con, int bbs_up,
			int bbs_do) {
		super();
		this.bbs_no = bbs_no;
		this.bbs_tit = bbs_tit;
		this.bbs_user = bbs_user;
		this.bbs_date = bbs_date;
		this.bbs_con = bbs_con;
		this.bbs_up = bbs_up;
		this.bbs_do = bbs_do;
	}

	public int getBbs_no() {
		return bbs_no;
	}

	public void setBbs_no(int bbs_no) {
		this.bbs_no = bbs_no;
	}

	public String getBbs_tit() {
		return bbs_tit;
	}

	public void setBbs_tit(String bbs_tit) {
		this.bbs_tit = bbs_tit;
	}

	public String getBbs_user() {
		return bbs_user;
	}

	public void setBbs_user(String bbs_user) {
		this.bbs_user = bbs_user;
	}

	public Date getBbs_date() {
		return bbs_date;
	}

	public void setBbs_date(Date bbs_date) {
		this.bbs_date = bbs_date;
	}

	public String getBbs_con() {
		return bbs_con;
	}

	public void setBbs_con(String bbs_con) {
		this.bbs_con = bbs_con;
	}

	public int getBbs_up() {
		return bbs_up;
	}

	public void setBbs_up(int bbs_up) {
		this.bbs_up = bbs_up;
	}

	public int getBbs_do() {
		return bbs_do;
	}

	public void setBbs_do(int bbs_do) {
		this.bbs_do = bbs_do;
	}

	@Override
	public String toString() {
		return "BbsEntity [bbs_no=" + bbs_no + ", bbs_tit=" + bbs_tit + ", bbs_user=" + bbs_user + ", bbs_date="
				+ bbs_date + ", bbs_con=" + bbs_con + ", bbs_up=" + bbs_up + ", bbs_do=" + bbs_do + "]";
	}
	
	
	
}
