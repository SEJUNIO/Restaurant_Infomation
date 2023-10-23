package com.ch.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ch.restaurant.dao.MemberDao;
import com.ch.restaurant.dao.RestaurantInfoDao;
import com.ch.restaurant.dto.MemberDto;

public class MWithdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = null;
		MemberDto sessionMember = (MemberDto)session.getAttribute("member");
		if(sessionMember != null) {
			mid = sessionMember.getMid();
		}
		RestaurantInfoDao rDao = RestaurantInfoDao.getInstance();
		int cnt = rDao.preWithdrawalRestaurantStep(mid);
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.withdrawalMember(mid);
		session.invalidate();
		if(result==MemberDao.SUCCESS) {
			request.setAttribute("withdrawalResult", "회원탈퇴 완료. 작성하신 글" + cnt + "개 모두 다 삭제 완료");
		}else {
			request.setAttribute("withdrawalResult", "작성하신 정보가 남아있습니다.");
		}

	}

}
