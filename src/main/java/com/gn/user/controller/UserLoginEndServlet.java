package com.gn.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.user.service.UserService;
import com.gn.user.vo.User;


@WebServlet(name="userLoginEnd",urlPatterns="/user/loginEnd")
public class UserLoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLoginEndServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 -> 비밀번호 확인(사용자 입력 == 회원가입)
		// 회원가입 비밀번호 암호화 == 사용자 입력값을 암호화
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		User u = new UserService().loginUser(id,pw);
//		User u = new User(1,"aa","m3PZqnzsc75hC4V6sNtwQ+D62EyZAVA3AV4N4dCtB29sg4cnQX4Nd3Ncl438jQW9O5LeLSO4EPafxDFiAvIBsQ==","아무개");
//		User u = null;
		if(u != null) {
			HttpSession session = request.getSession(true);
			if(session.isNew()||session.getAttribute("user")==null) {
				session.setAttribute("user", u);
				session.setMaxInactiveInterval(60*30);
			}
			response.sendRedirect("/");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/login_fail.jsp");
			view.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
