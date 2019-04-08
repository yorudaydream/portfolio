package com.ft.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	public int join(MemberDTO memberDTO) throws Exception{
		return memberDAO.join(memberDTO);
	}

	//잘 기억 못함
	public int update(MemberDTO memberDTO) throws Exception{
		return memberDAO.update(memberDTO);
		
	}
	
	//잘 기억 못함
	public int idCheck(String id) throws Exception{
		return memberDAO.idCheck(id);
	}
	
	public int delete(String id) throws Exception{
		return memberDAO.delete(id);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}
	
}
