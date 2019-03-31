package bbs.vo;

import java.sql.Date;

/*
 * 
 *  CREATE TABLE BBS (
 	BBS_NO NUMBER(20), 
 	BBS_TIT VARCHAR2(100), 
 	BBS_USER VARCHAR2(30), 
 	BBS_DATE DATE, 
 	BBS_CON VARCHAR2(2000), 
 	BBS_UP NUMBER(10), 
 	BBS_DO NUMBER(10)
 	);
 	
 */

public class BbsVo {
	
	private String bbs_tit;
	private String bbs_con;
	public BbsVo() {
		super();
	}
	public BbsVo(String bbs_tit, String bbs_con) {
		super();
		this.bbs_tit = bbs_tit;
		this.bbs_con = bbs_con;
	}
	public String getBbs_tit() {
		return bbs_tit;
	}
	public void setBbs_tit(String bbs_tit) {
		this.bbs_tit = bbs_tit;
	}
	public String getBbs_con() {
		return bbs_con;
	}
	public void setBbs_con(String bbs_con) {
		this.bbs_con = bbs_con;
	}

	
	
	
	
}
