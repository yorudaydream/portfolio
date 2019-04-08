package com.ft.project;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ft.member.MemberDTO;
import com.ft.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public void join() throws Exception{
		
	}
	
	@RequestMapping(value="join.do", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd, HttpServletRequest request) throws Exception{
		System.out.println("joindo");
		/*int kind = Integer.parseInt(request.getParameter("memeberType"));
		memberDTO.setGrade(kind);*/
		
		int result = memberService.join(memberDTO);
		System.out.println(result);
		String path ="redirect:../";
		if(result<1) {
			path ="redirect:../join";
			rd.addFlashAttribute("msg", "회원가입 실패");
		}
		
		return path;
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login() throws Exception{
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd) throws Exception{
		memberDTO =memberService.login(memberDTO);//받아온 memberDTO를 한번 받아서 null인지 아닌지 체크하도록
		String path = "";
		/*System.out.println(memberDTO.getId());*/
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);//member 이름으로 memberDTO 담기
			System.out.println(memberDTO.getAddress());
			path="redirect:../";
		}else {
			path="redirect:./login";
			rd.addFlashAttribute("msg", "로그인을 실패했습니다");
		}
		
		return path;
	}
	
/*	@RequestMapping(value="idCheck")
	public String idCheck(String id, Model model) throws Exception{
		MemberDTO memberDTO = memberService.idCheck(id);//id가져오기
		int result = 0;
		if(memberDTO==null) {
			result = 1;
		}//memberDTO가 없으면 중복된 아이디 없음
		
		model.addAttribute("result", result);
		
		return "common/result";
		
	}*/

	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update() throws Exception{
		
	}

	@RequestMapping(value="myUpdate", method=RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd) throws Exception{
		System.out.println("myUpdate");
		MemberDTO sMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sMemberDTO.getId());
		
		int result = memberService.update(memberDTO);
		//result가 0이상일 때 grade 자동set, session에 memberDTO 저장. 실패하면 오류메세지 출력
		if(result>0) {
			memberDTO.setGrade(sMemberDTO.getGrade());
			session.setAttribute("member", memberDTO);
		}else {
			rd.addFlashAttribute("msg", "수정을 실패했습니다.");
		}
		
		return "redirect:/project/mypage/my";
	}
	
	//session에서 member 꺼내서 memberDTO 에 저장하고 result에 아이디 담기. result>0이면 성공메세지 출력,session 끊기.
	//메세지 저장해서 출력하고 index로 redirect
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(HttpSession session, RedirectAttributes rd) throws Exception{
		MemberDTO sMemberDTO = (MemberDTO)session.getAttribute("member");
		System.out.println(sMemberDTO.getId());
		int result = memberService.delete(sMemberDTO.getId());
		String message = "Delete Fail";
		if(result>0) {
			message = "Delete Success";
			session.invalidate();
		}
		
		rd.addFlashAttribute("msg",message);
		return "redirect:../";
		
		
	}
	
	//세션 끊고 index로 redirect
	@RequestMapping(value="logOut", method=RequestMethod.GET)
	public String logOut(HttpSession session, RedirectAttributes rd) throws Exception{
		session.invalidate();//즉시종료
		return "redirect:../";
	}
	
	
	@RequestMapping(value="idcheck.do", method=RequestMethod.POST)
    @ResponseBody
    public Map<Object, Object> idcheck(@RequestBody String id) {
		int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        try {
			count = memberService.idCheck(id);
	        map.put("check", count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
		return map;
        
    }
 

	
}
