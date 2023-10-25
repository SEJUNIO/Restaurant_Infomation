package com.ch.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.restaurant.dao.NoticeDao;

public class ANoticeDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String nidStr = request.getParameter("nid");
		int nid = 0;
		nid =Integer.parseInt(nidStr);
		NoticeDao nDao = NoticeDao.getInstance();
		int result = nDao.deleteNotice(nid);
		if(result == NoticeDao.SUCCESS) {
			request.setAttribute("noticeResult", "글 삭제 성공");
		}else {
			request.setAttribute("noticeResult", "글삭제 실패");
		}
	}

}
