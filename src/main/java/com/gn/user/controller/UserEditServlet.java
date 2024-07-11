package com.gn.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/edit")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserEditServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("user_no");
		String id = request.getParameter("user_id");
		request.setAttribute("no", no);
		request.setAttribute("id", id);
		RequestDispatcher view = request.getRequestDispatcher("/views/user/edit.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
