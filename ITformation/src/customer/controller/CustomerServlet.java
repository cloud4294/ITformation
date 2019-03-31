package customer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import customer.biz.CustomerBIZ;
import customer.vo.CustomerVO;

@Controller("CustomerController")
public class CustomerServlet {

	@Autowired
	CustomerBIZ customer_biz;

	@RequestMapping("/selectAll.do")
	public String selectAllAdmin(Model m) {
		List<CustomerVO> all = customer_biz.getAll();
		m.addAttribute("all", all);	
		return "WEB-INF/view/customer/cus_control.jsp";
	}

	@RequestMapping("/delete.do")
	public String deleteAdmin(@RequestParam("del_name") String name) {
		int res = customer_biz.getDelete(name);
		if (res > 0)
			return "/selectAll.do";
		return "";
	}

	@RequestMapping(value = "/customer/join.do", method = RequestMethod.GET)
	public ModelAndView customerJoin() {
		CustomerVO VO = new CustomerVO();
		ModelAndView mav = new ModelAndView("/WEB-INF/view/customer/join.jsp","customer",VO);
		return mav;
		
	}	

	@RequestMapping(value = "/customer/join.do", method = RequestMethod.POST)
	public ModelAndView MyInsert(@ModelAttribute("customer") CustomerVO customer,Errors result) {
		int r = 0;
		customer_biz.validate(customer, result);
		if(result.hasErrors()) {  	
			return new ModelAndView("/WEB-INF/view/customer/join.jsp");
		}
		ModelAndView mav = new ModelAndView("/WEB-INF/view/customer/redirect.jsp");
		System.out.println(customer);
		r = customer_biz.getInsert(customer);
		System.out.println(r);
		mav.addObject("msg", "가입이 완료되었습니다.");
		mav.addObject("url", "/ITformation/index.jsp");
		return mav;

	}

	/*
	 * 회원가입시 중복아이디 - 체크 프론트 버튼 활성화 비밀번호 , 비밀번호 확인 동일한지 확인
	 * 
	 * 로그인시 유효성검사 - id가 있는지 검사 - id가 없을 경우 alert 없는아이디입니다 . - 있을 경우 - pw가 안맞는 경우 -
	 * alert 로그인 실패 하였습니다. - pw가 있는 경우 - 로그인 성공,객체값 넘겨 주기
	 * 
	 * 
	 */

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("userID") String userID,
			@RequestParam("userPassword") String userPassword) {
		CustomerVO vo = new CustomerVO();
		vo.setC_id(userID);
		vo.setC_pw(userPassword); // http session
		CustomerVO r = customer_biz.getLogin(vo);
		System.out.println(r);
		return new ModelAndView("/index.jsp", "customer", r);

	}

	@RequestMapping("/myPage.do")
	public ModelAndView mypage(HttpSession session) {
		String id = (String) session.getAttribute("userID");
		CustomerVO vo = customer_biz.getCustomer(id);
		return new ModelAndView("WEB-INF/view/customer/myPage.jsp", "CustomInfo", vo);
	}

	@RequestMapping(value = "/updateCustomer.do", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute CustomerVO user) {
		int r = customer_biz.getUpdate(user);
		System.out.println(r);
		//CustomerVO vo = customer_biz.getCustomer(user.getC_id());
		
		return "/myPage.do";

	}

	@RequestMapping(value = "/deleteCustomer.do", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam("userID") String userID) {
		int res = customer_biz.getDelete(userID);

		return new ModelAndView("/index.jsp");

	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index.jsp";
	}

}
