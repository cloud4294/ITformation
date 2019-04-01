package bbs.biz;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbs.dao.BbsDAO;
import bbs.entity.BbsEntity;
import bbs.vo.BbsVo;

@Service
public class BbsBiz {

	@Autowired
	BbsDAO bbsDao;

	public int getInsertBbs(BbsVo vo,String userID) {
		
		BbsEntity entity = new BbsEntity();
		entity.setBbs_con(vo.getBbs_con());
		entity.setBbs_tit(vo.getBbs_tit());
		entity.setBbs_user(userID);
		
		return bbsDao.getInsertBbs(entity);
	}
	
	
	
	public List<BbsEntity> getAll(){
		List<BbsEntity> list = bbsDao.getAll();
		Collections.sort(list, new Comparator<BbsEntity>() {

			@Override
			public int compare(BbsEntity o1, BbsEntity o2) {
				return o2.getBbs_no() - o1.getBbs_no();
			}
		});
		
		return list;
	}
	
	public BbsEntity getEntity(int no) {
		return bbsDao.getEntity(no);
	}
	
	
}
