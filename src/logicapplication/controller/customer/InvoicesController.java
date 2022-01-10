package logicapplication.controller.customer;

import logicapplication.categoryDAO.CategoryDAO;
import logicapplication.orderDAO.OrderDAO;
import logicapplication.customerDAO.CustomerDAO;
import logicapplication.orderDAO.OrderDAOImpl;
import logicapplication.customerDAO.CustomerDAOImpl;
import logicapplication.categoryDAO.CategoryDAOImpl;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.category.Category;
import model.customer.Customer;
import model.order.OrderDTO;

@WebServlet(urlPatterns= {"/invoices", "/hoa-don"})
public class InvoicesController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public InvoicesController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Lay user tu username session
		HttpSession session = request.getSession();
		String username = session.getAttribute("login_user").toString();
		CustomerDAO customerDAO = new CustomerDAOImpl();
                Customer user = customerDAO.getUserByUserName(username);
		
		// Tai day lay tat ca giao dich theo id
		OrderDAO orderDao = new OrderDAOImpl();
		List<OrderDTO> orders = orderDao.getOrdersByUserId(user.getId());
		request.setAttribute("orders", orders);
		
		// Lay tat ca categories
		CategoryDAO categoryDao = new CategoryDAOImpl();
		List<Category> categories = categoryDao.getAllCategories();
		request.setAttribute("categories", categories);
		
		request.getRequestDispatcher("client/jsp/invoices.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}