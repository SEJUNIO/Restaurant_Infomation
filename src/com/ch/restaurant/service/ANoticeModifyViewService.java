package com.ch.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.restaurant.dao.NoticeDao;
import com.ch.restaurant.dto.NoticeDto;

public class ANoticeModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String nidStr = request.getParameter("nid");
		int nid = 0;
		nid =Integer.parseInt(nidStr);
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeDto nDto = nDao.getNoticeNotHitUP(nid);
		request.setAttribute("notice", nDto);

	}

}
