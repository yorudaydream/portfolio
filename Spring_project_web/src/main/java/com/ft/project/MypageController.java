package com.ft.project;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ft.member.MemberDTO;
import com.ft.member.MemberService;

@Controller
@RequestMapping(value="/mypage/**")
public class MypageController {
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="my", method=RequestMethod.GET)
	public void myPage() throws Exception{
	}
	
	@RequestMapping(value="myOrderList", method=RequestMethod.GET)
	public void myOrderList() throws Exception{
		System.out.println("myOrderList");
		
	}
	@RequestMapping(value="myProductList", method=RequestMethod.GET)
	public void myProductList() throws Exception{
		System.out.println("myProductList");
		
	}
	@RequestMapping(value="myInfo", method=RequestMethod.GET)
	public void myInfo() throws Exception{
		System.out.println("myInfo");
		
	}
	
	@RequestMapping(value="myInfo.do", method=RequestMethod.POST)
	public String myInfo(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd) throws Exception{
		System.out.println("myInfodo");
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
		
		return "redirect:./my";
		
	}
}
