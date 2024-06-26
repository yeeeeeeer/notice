package com.javanos.project.notice.controller;

import java.io.IOException;

import com.javanos.project.notice.model.dto.NoticeDTO;
import com.javanos.project.notice.model.service.NoticeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoticeSelectDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));

		NoticeService noticeService = new NoticeService();
		NoticeDTO noticeDetail = noticeService.selectNoticeDetail(no);

		System.out.println("noticeDetail : " + noticeDetail);

		String path = "";
		if (noticeDetail != null) {
			path = "/WEB-INF/views/notice/noticeDetail.jsp";
			request.setAttribute("notice", noticeDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하였습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

}
