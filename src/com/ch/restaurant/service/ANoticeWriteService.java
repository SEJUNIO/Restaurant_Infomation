package com.ch.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ch.restaurant.dao.NoticeDao;
import com.ch.restaurant.dto.NoticeDto;

public class ANoticeWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int result = NoticeDao.FAIL;
		String aid = request.getParameter("aid");
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		String nip = request.getRemoteAddr();
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeDto nDto = new NoticeDto(0, aid, ntitle, ncontent, 0, 0, 0, 0, nip, null);
		result = nDao.writeNotice(nDto);
		if(result == NoticeDao.SUCCESS) { 
			request.setAttribute("noticeResult", "글쓰기 성공");
		}else {
			request.setAttribute("noticeResultErrorMsg", "글쓰기 실패");
		}

	}

}
