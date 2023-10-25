package com.ch.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.restaurant.dao.NoticeDao;
import com.ch.restaurant.dto.NoticeDto;

public class ANoticeModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int result = NoticeDao.FAIL;
		int nid = Integer.parseInt(request.getParameter("nid"));
		//String aid = request.getParameter("aid");
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		//int nhit = Integer.parseInt(request.getParameter("nhit").trim());
		String nip = request.getRemoteAddr();
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeDto nDto = new NoticeDto(nid, null, ntitle, ncontent, 0, 0, 0, 0, nip, null);
		result = nDao.modifyNotice(nDto);
		if(result == NoticeDao.SUCCESS) { 
			request.setAttribute("nDto", "글수정 성공");
		}else {
			request.setAttribute("nDto", "글수정 실패");
		}
	}

}
