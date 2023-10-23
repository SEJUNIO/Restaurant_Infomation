package com.ch.restaurant.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ch.restaurant.dao.MemberDao;
import com.ch.restaurant.dto.MemberDto;

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int result = MemberDao.FAIL; // DB정보수정 결과를 저장할 변수
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mtel = request.getParameter("mtel");
		String mbirthStr = request.getParameter("mbirth");
		Date mbirth = null;
		if(!mbirthStr.equals("")) {
			mbirth = Date.valueOf(mbirthStr);
		}
		String maddress = request.getParameter("maddress");
		MemberDao mDao = MemberDao.getInstance();
		MemberDto mDto = new MemberDto(mid, mpw, mname, memail, mtel, mbirth, maddress);
		result = mDao.modifyMember(mDto);
		if(result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", mDto);
			request.setAttribute("modifyResult", "회원 정보 수정 성공");
		}else {
			request.setAttribute("modifyErrorMsg", "회원정보 수정 실패(정보가 길거나 mid check!)");
		}
	}

}
