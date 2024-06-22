package com.javanos.project.notice.controller;

import java.io.IOException;
import java.util.List;

import com.javanos.project.notice.model.dto.NoticeDTO;
import com.javanos.project.notice.model.service.NoticeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NoticeSelectList")
public class NoticeSelectList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList();

		System.out.println(noticeList);

		String path = "";
		if (noticeList != null) {
			path = "/WEB-INF/views/notice/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 조회 실패!");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
