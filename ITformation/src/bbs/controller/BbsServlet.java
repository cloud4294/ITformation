package bbs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bbs.biz.BbsBiz;
import bbs.entity.BbsEntity;
import bbs.vo.BbsVo;

@Controller("BbsController")
public class BbsServlet {

	@Autowired
	BbsBiz bbs_biz;
	
	
	@RequestMapping("/selectAllBbs.do")
	public ModelAndView selectAllBbs() {
		List<BbsEntity> all = bbs_biz.getAll();
		ModelAndView mav = new ModelAndView("WEB-INF/view/bbs/bbs.jsp", "AllBbs", all);
		return mav;
	}
	
	@RequestMapping(value = "/insertBbs.do", method = RequestMethod.POST)
	public String write(@ModelAttribute BbsVo bbsVo,HttpSession session) {
		
		String userID = (String)session.getAttribute("userID");
		int r = 0;
		if(userID == null) {
			return  "redirect:selectAllBbs.do";
		}
	
			r = bbs_biz.getInsertBbs(bbsVo,userID);
			
		return "redirect:selectAllBbs.do";

	}
	
	@RequestMapping("/board/view.do")
	public ModelAndView view(@RequestParam int bbs_no) {
		BbsEntity entity = bbs_biz.getEntity(bbs_no);
		return new ModelAndView("/WEB-INF/view/bbs/bbsView.jsp", "entity", entity);
	}
	
	@RequestMapping("/board/Write.do")
	public String writeRedirect() {
		return "/WEB-INF/view/bbs/bbsWrite.jsp";
	}
	
	
}
