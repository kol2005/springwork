package com.biz.gallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.gallery.domain.MemberVO;
import com.biz.gallery.repository.MemberDao;

@Service
public class MemberService {

	private final MemberDao memberDao;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberService(MemberDao memberDao,BCryptPasswordEncoder passwordEncoder) {
		super();
		this.memberDao = memberDao;
		this.passwordEncoder = passwordEncoder;
	}


	public int insert(MemberVO memberVO) {
	
		// 입력된 회원정보중 password를 암호화 수행
		String cryptText = passwordEncoder.encode(memberVO.getU_password());
		memberVO.setU_password(cryptText);
		
		int nCount = memberDao.memberCount();
		if(nCount < 1) {
			memberVO.setU_grade("ADMIN");
		}else if(nCount < 4) {
			memberVO.setU_grade("MEM");
		}else {
			memberVO.setU_grade("GUEST");
		}
		
		memberVO.setU_name(memberVO.getU_id());
		return memberDao.insert(memberVO);
	}


	public MemberVO loginCheck(MemberVO memberVO) {
		String u_id = memberVO.getU_id();
		String u_password = memberVO.getU_password();
		
		MemberVO loginMemberVO = memberDao.findById(u_id);
		if(loginMemberVO != null) {
			String cryptPassword = loginMemberVO.getU_password();
			if(passwordEncoder.matches(u_password, cryptPassword)) {
				return loginMemberVO;
			}
		}
		
		return null;
	}
	
	
}
