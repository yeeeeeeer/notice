package com.javanos.project.community.controller;

import java.io.IOException;
import java.util.List;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.service.CommunityService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community/list")
public class CommunitySelectListServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CommunityDTO를 list로 구성해서 forward시키기
				List<CommunityDTO> communityList = new CommunityService().selectAllCommunityList();
				
				request.setAttribute("communityList", communityList);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/community/community.jsp");
				rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
