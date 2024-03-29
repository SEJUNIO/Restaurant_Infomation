package com.ch.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.restaurant.service.ALoginService;
import com.ch.restaurant.service.ANoticeContentService;
import com.ch.restaurant.service.ANoticeDeleteService;
import com.ch.restaurant.service.ANoticeListService;
import com.ch.restaurant.service.ANoticeModifyService;
import com.ch.restaurant.service.ANoticeModifyViewService;
import com.ch.restaurant.service.AnoticeWriteService;
import com.ch.restaurant.service.MAllViewService;
import com.ch.restaurant.service.MLoginService;
import com.ch.restaurant.service.MLogoutService;
import com.ch.restaurant.service.MModifyService;
import com.ch.restaurant.service.MWithdrawalService;
import com.ch.restaurant.service.MemailConfirmService;
import com.ch.restaurant.service.MidConfirmService;
import com.ch.restaurant.service.MjoinService;
import com.ch.restaurant.service.Service;
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/main.do")) {
			viewPage = "main/main.jsp";
		/* * * * * member요청 * * * * */
		}else if(command.equals("/loginView.do")) { // 로그인 화면
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) { //db를 통해 로그인 확인 및 세션처리
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/joinView.do")) { //회원가입 화면
			viewPage = "member/join.jsp";
		}else if(command.equals("/midConfirm.do")) { // 아이디 중복확인
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/midConfirm.jsp";
		}else if(command.equals("/memailConfirm.do")) { // 이메일 중복확인
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/memailConfirm.jsp"; 
		}else if(command.equals("/join.do")) { // 회원가입 db처리후 로그인으로 가고 id엔 가입한 id출력
			service = new MjoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(command.equals("/logOut.do")){ // 로그아웃 - 세션 날리기
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/modifyView.do")) { // 정보수정화면
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) { // 정보수정 DB처리후 세션도 수정
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/withdrawal.do")) { // 회원탈퇴
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "main/main.jsp";	
			/* * * * * admin  요청 * * * * */
		}else if(command.equals("/allView.do")){ 
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(command.equals("/adminLoginView.do")) {
			viewPage = "admin/adminLogin.jsp";
		}else if(command.equals("/adminLogin.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "allView.do";
		}else if(command.equals("/noticeList.do")) {
			service = new ANoticeListService();
			service.execute(request, response);
			viewPage = "admin/noticeList.jsp";
		}else if(command.equals("/noticeWriteView.do")) {  // 공지사항 글 작성
			viewPage = "admin/noticeWrite.jsp";
		}else if(command.equals("/noticeWrite.do")) {
			service = new AnoticeWriteService();
			service.execute(request, response);
			viewPage = "noticeList.do";				
		}else if(command.equals("/noticeContent.do")) {
			service = new ANoticeContentService();
			service.execute(request, response);
			viewPage = "admin/noticeContent.jsp";
		}else if(command.equals("/noticeModifyView.do")) {
			service = new ANoticeModifyViewService();
			service.execute(request, response);
			viewPage = "admin/noticeModify.jsp";
		}else if(command.equals("/noticeModify.do")) {
			service = new ANoticeModifyService();
			service.execute(request, response);
			viewPage = "noticeList.do";
		}else if(command.equals("/noticeDelete.do")) {
			service = new ANoticeDeleteService();
			service.execute(request, response);
			viewPage = "noticeList.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		}	
}
