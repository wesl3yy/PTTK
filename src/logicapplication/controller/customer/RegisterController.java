package logicapplication.controller.customer;

import logicapplication.categoryDAO.CategoryDAO;
import logicapplication.categoryDAO.CategoryDAOImpl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.customerDAO.CustomerDAOImpl;

import java.util.Iterator;
import java.util.List;
import model.category.Category;

import model.customer.Customer;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterController() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                CategoryDAO categoryDao = new CategoryDAOImpl();
                List<Category> categories = categoryDao.getAllCategories();
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("client/jsp/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                               
		request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
                String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("repeat-pwd");
		String address = request.getParameter("address");
		String phonenum = request.getParameter("phone-num");
		CustomerDAOImpl userImpl = new CustomerDAOImpl();
		
		List<Customer> listCustomer = userImpl.getListUser();
		
		boolean checkUser = true;
		int idx = 0;
		for (Customer o : listCustomer) {
		   if(o.getUsername().endsWith(username)) {
			   checkUser = false;
			   break;
		   }
		   idx++;
		}
		
		if(password1.equals(password2) && checkUser) {
			Customer user = new Customer();
			user.setFullName(fullname);
                        user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password1);
			user.setAddress(address);
			user.setPhone(phonenum);
			
			userImpl.addUser(user);
			
			response.sendRedirect("client/jsp/static/registerSuccess.jsp");
		}
		else {
			response.sendRedirect("client/jsp/static/registerErr.jsp");
		}

	}

}
