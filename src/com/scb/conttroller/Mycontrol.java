package com.scb.conttroller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.scb.bean.Mybean1;
import com.scb.service.MyService;

@Controller
public class Mycontrol
{@Autowired	
private MyService myService;
@RequestMapping("/login")
public ModelAndView method2(HttpServletRequest request, Mybean1 mb,HttpSession session)
{
	String u=request.getParameter("user");
	String p= request.getParameter("pass");
	mb.setUser(u);
	mb.setPass(p);
		int n=myService.validate(mb);
		if(n==1)
		{
			
			return new ModelAndView("User.jsp"); 
		}
		else
		{
			return new ModelAndView("Error");
		}
}

@RequestMapping("/loan_details")
public ModelAndView method4(HttpServletRequest request, Mybean1 mb,HttpSession session)
{
	String u=request.getParameter("user");
	mb.setUser(u);
	List<Mybean1> dets = myService.showLoandetails();
	ModelAndView mav = new ModelAndView();
	List<Mybean1> welcome_name = myService.getName(mb);
	mav.addObject("welcome_name", welcome_name);
	mav.addObject("acc_data", dets);
	mav.setViewName("acc_dets.jsp");
	return mav;
}

@RequestMapping("/miniStat_details")
public ModelAndView method5(HttpServletRequest request, Mybean1 mb,HttpSession session)
{
	String u=request.getParameter("user");
	mb.setUser(u);
	List<Mybean1> dets = myService.showMinidetails(mb);
	ModelAndView mav = new ModelAndView();
	List<Mybean1> welcome_name = myService.getName(mb);
	mav.addObject("welcome_name", welcome_name);
	mav.addObject("miniStat_data", dets);
	mav.setViewName("ministat.jsp");
	return mav;
}

@RequestMapping("/microStat_details")
public ModelAndView method6(HttpServletRequest request, Mybean1 mb,HttpSession session)
{
	String u=request.getParameter("user");
	mb.setUser(u);
	List<Mybean1> dets = myService.showMicrodetails(mb);
	ModelAndView mav = new ModelAndView();
	List<Mybean1> welcome_name = myService.getName(mb);
	mav.addObject("welcome_name", welcome_name);
	mav.addObject("acc_data", dets);
	mav.setViewName("acc_dets.jsp");
	return mav;
}

@RequestMapping("/acc_details")
public ModelAndView method3(HttpServletRequest request, Mybean1 mb,HttpSession session)
{
	String u=request.getParameter("user");
	mb.setUser(u);
	List<Mybean1> dets = myService.showdetails(mb);
	ModelAndView mav = new ModelAndView();
	List<Mybean1> welcome_name = myService.getName(mb);
	mav.addObject("welcome_name", welcome_name);
	mav.addObject("acc_data", dets);
	mav.setViewName("acc_dets.jsp");
	return mav;
}

}