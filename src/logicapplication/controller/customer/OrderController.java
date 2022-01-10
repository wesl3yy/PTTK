package logicapplication.controller.customer;

import logicapplication.categoryDAO.CategoryDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logicapplication.orderDAO.OrderDAO;
import logicapplication.customerDAO.CustomerDAO;
import logicapplication.categoryDAO.CategoryDAOImpl;
import logicapplication.orderDAO.OrderDAOImpl;
import logicapplication.customerDAO.CustomerDAOImpl;
import java.util.List;
import model.category.Category;
import model.order.Order;
import model.customer.Customer;

@WebServlet("/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderDAO orderDao;
    public OrderController() {
        super();
        orderDao = new OrderDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO categoryDao = new CategoryDAOImpl();
		List<Category> categories = categoryDao.getAllCategories();
		request.setAttribute("categories", categories);
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order"); // chi con truong hop truy cap truc tiep
		String userName = session.getAttribute("login_user").toString(); // filter loc user roi, nen neu co thi la da dang nhap
		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer user = customerDAO.getUserByUserName(userName);
		int id = 0; // order id, lay de in hoa don
		if(order == null) {
                    response.sendRedirect("./"); // neu nguoi dung chua mua hang, ve trang chu
                    return;
		}else {
                    order.setUser(user);
                    id = orderDao.addOrder(order);
		}
		session.removeAttribute("order"); // sau khi thanh cong, xoa session order di
		// dieu huong ve view hien thi
		//request.getRequestDispatcher("client/jsp/static/success.html").forward(request, response);
		response.sendRedirect("./success?id=" + id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
