package net.java.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dao.UserDAO;
import net.java.model.user;

/**
 * Servlet implementation class createAccount
 */
@WebServlet("/createAccount")
public class createAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			String taikhoan = request.getParameter("username");
			String matkhau = request.getParameter("password");
			String matkhau1 =request.getParameter("password1");
			if(matkhau.equals(matkhau1)) {
			UserDAO userDAO = new UserDAO();
			user User= new user(taikhoan,matkhau);
			userDAO.insertUser(User);
			response.sendRedirect("login.jsp");
			}else {
				request.setAttribute("errorAcc", "re-enter password did not correctly ");
				request.getRequestDispatcher("createAcount.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
