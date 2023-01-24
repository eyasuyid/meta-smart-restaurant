package com.alimama;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.alimama.data_util.CustomerDataUtil;
import com.alimama.users.Customer;
import com.alimama.users.User;
import com.alimama.data_util.security.PasswordHash;
import com.alimama.mail.UserMailing;
/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String firstName, lastName, email, phone;
	private User user;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/alimama/dashboard.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		email = request.getParameter("email");
		if (request.getParameter("command").equals("update")) {
			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			phone = request.getParameter("phone");
			// check if either of the field are null or empty
			if (firstName != null && lastName != null && email != null && phone != null) {
				if (firstName != "" && lastName != "" && email != "" && phone != "") {
					user = new Customer(firstName, lastName, phone, email,
							new PasswordHash().generateStorngPasswordHash(
									request.getParameter("password")
							));
					new CustomerDataUtil().updateUser(user);
					new UserMailing(email, firstName, lastName, phone, "updated");
					request.setAttribute("user", user);
					request.setAttribute("password", request.getParameter("password"));
					request.getRequestDispatcher("/dashboard.jsp")
						.forward(request, response);
				}
			}
		} else if (request.getParameter("command").equals("delete")){
			new CustomerDataUtil().deleteUser(email);
			new UserMailing(email, firstName, lastName, phone, "deleted");
			response.sendRedirect("/alimama/signout.jsp");
		}
	}
}
