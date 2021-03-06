package customer.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import customer.vo.CustomerVO;



@Repository
public class CustomerDAO {
	
	static SqlSessionFactory factory;
	static {
		String resource = "customer/conf/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// static end

	public List<CustomerVO> getAll() {

		SqlSession session = factory.openSession();
		List<CustomerVO> all = null;
		try {
			all = session.selectList("customerMapper.CustomerAll");
		} finally {
			session.close();
		}
		return all;
	}
	
	//insert
	public int getInsert(CustomerVO cus) {
		SqlSession session = factory.openSession();
		int all = 0;
		System.out.println(cus);
		try {
			all = session.insert("customerMapper.CustomerInsert",cus);
			if(all > 0)
				session.commit();
		}catch(Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return all;
		
	}
	//delete
	public int getDelete(String id) {
		SqlSession session = factory.openSession();
		int all = 0;
		try {
			all = session.delete("customerMapper.CustomerDelete",id);
			if(all > 0)
				session.commit();
		}catch(Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return all;
		
	}
	
	
	//update 
	
	public int getUpdate(CustomerVO pro) {
		SqlSession session = factory.openSession();
		int all = 0;
		try {
			if(pro.getC_pw() != null)
				all = session.update("customerMapper.CustomerUpdatePw",pro);
			if(pro.getC_nic_name() != null)
				all = session.update("customerMapper.CustomerUpdateNic",pro);
			if(pro.getC_email() != null)
				all = session.update("customerMapper.CustomerUpdateEmail",pro);
			if(pro.getC_phone() != null)
				all = session.update("customerMapper.CustomerUpdatePhone",pro);
			
			if(all > 0)
				session.commit();
		}catch(Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return all;
		
	}
	
	public CustomerVO getLogin(CustomerVO Vo) {

		SqlSession session = factory.openSession();
		CustomerVO VO = null;	
		try {
			VO = session.selectOne("customerMapper.CustomerLoginCheck",Vo);
			if(VO != null) {
				VO = session.selectOne("customerMapper.CustomerLogin",Vo);
				if(VO == null) {
					
				}
			}
				
		} finally {
			session.close();
		}
		return VO;
	}
	
	//getCustomer
	public CustomerVO getCustomer(String id) {

		SqlSession session = factory.openSession();
		CustomerVO VO = null;
		try {
			VO = session.selectOne("customerMapper.CustomerSelect", id);
		} finally {
			session.close();
		}
		return VO;
	}
	
	
}
