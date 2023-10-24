package com.ch.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.restaurant.dao.NoticeDao;
import com.ch.restaurant.dto.NoticeDto;

public class ANoticeContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nid = Integer.parseInt(request.getParameter("nid"));
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.hitUp(nid);
		NoticeDto nContent = nDao.getNoticeNotHitUP(nid);
		request.setAttribute("nContent", nContent);

	}

	}

