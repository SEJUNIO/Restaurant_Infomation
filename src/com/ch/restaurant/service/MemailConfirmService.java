package com.ch.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.restaurant.dao.MemberDao;

public class MemailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.memailConfirm(memail);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("memailConfirmResult", "<b>중복된 이메일입니다. 다시 확인 부탁드립니다.</b>");
		}else {
			request.setAttribute("memailConfirmResult", "<b>사용 가능한 이메일 입니다.</b>");
		}

	}

}
