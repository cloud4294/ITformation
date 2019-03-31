package bbs.dao;

public interface IBbs {

	String insert_bbs = "insert into bbs values(BBSNO.NEXTVAL,?,?,sysdate,?,0,0)";
	String all_bbs = "select * from bbs";
	String select_bbs = "select * from bbs where bbs_no = ?";
	/*String delete_bbs = "delete from bbs where name=?";
	String find_bbs = "select * from myscore where name=?";
	String update_bbs = "update bbs set kor=?, mat=?, eng=?,tot=?,avg=?,grade=? where name = ?";
	String select_bbs = "select * from bbs";
	*/
}
