package bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import bbs.entity.BbsEntity;

@Repository
public class BbsDAO implements IBbs {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int getInsertBbs(BbsEntity entity) {	
		// 다운 캐스팅 해서 게시판 늘릴 것 Object
		return jdbcTemplate.update(insert_bbs,  new Object[] {entity.getBbs_tit(),entity.getBbs_user(),entity.getBbs_con()}); 
	}
	
	public List<BbsEntity> getAll() {

		List<BbsEntity> all = jdbcTemplate.query(all_bbs, new RowMapper<BbsEntity>() {

			@Override
			public BbsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new BbsEntity(rs.getInt("bbs_no"), rs.getString("bbs_tit"), rs.getString("bbs_user"), rs.getDate("bbs_date"),rs.getString("bbs_con"), rs.getInt("bbs_up"), rs.getInt("bbs_do"));
			}
		});
		
		return all;
	}

	public BbsEntity getEntity(int no) {
		
		
		BbsEntity entity = jdbcTemplate.queryForObject(select_bbs, new Object[] {no}, new RowMapper<BbsEntity>() {

			@Override
			public BbsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				BbsEntity e = new BbsEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
				return e;
			}
		});
		
		return entity;
	}
	
}
