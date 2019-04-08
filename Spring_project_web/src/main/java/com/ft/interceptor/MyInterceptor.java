package com.ft.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ft.member.MemberDTO;

public class MyInterceptor extends HandlerInterceptorAdapter{
	//Controller 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
	
		HttpSession session = request.getSession();//로그인 했나 안햇나
		boolean check = false;
		if(session.getAttribute("member") != null){
			check = true;
		}else {
			response.sendRedirect("/project/member/login");
		}//회원이면 다음단계 비회원이면 돌려보냄
		return check;
	}
	
	

}
