package logicapplication.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.customerDAO.CustomerDAO;
import logicapplication.customerDAO.CustomerDAOImpl;
import model.customer.Customer;

@WebServlet("/admin/users-management")
public class UsersManagementController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;
    public UsersManagementController() {
        super();
        customerDAO = new CustomerDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Customer> users = customerDAO.getListUser();
            request.setAttribute("users", users);
            // check action (EDIT / DELETE)
            String action = request.getParameter("action");
            if(action != null) {	
                if(action.equals("EDIT")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Customer user = customerDAO.getUserByUserId(id);
                    request.setAttribute("user", user);
                } else if(action.equals("DELETE")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    customerDAO.removeUser(id);
                    response.sendRedirect("users-management");
                    return;
                }
            }
            request.getRequestDispatcher("jsp/users-management.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// action = ADD / UPDATE
		String action = request.getParameter("action");
		
		int id = request.getParameter("user-id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("user-id"));
		String fullName = request.getParameter("fullName");
 		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");		

		Customer user = new Customer(id, username, password, fullName, email, address, phone);
		
		if(action.equals("ADD")) {
                    customerDAO.addUser(user);
		} else if(action.equals("UPDATE")) {
                    customerDAO.updateUser(user);
		}
		response.sendRedirect("users-management");
		
	}

}
