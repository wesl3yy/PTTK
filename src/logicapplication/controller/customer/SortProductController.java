package logicapplication.controller.customer;

import logicapplication.categoryDAO.CategoryDAO;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.bookDAO.BookDAO;
import logicapplication.categoryDAO.CategoryDAOImpl;
import logicapplication.bookDAO.BookDAOImpl;
import model.category.Category;
import model.book.Book;
import util.OrderBy;

@WebServlet("/SortProductController")
public class SortProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SortProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                CategoryDAO categoryDao = new CategoryDAOImpl();
		List<Category> categories = categoryDao.getAllCategories();
		request.setAttribute("categories", categories);
		// xu ly ajax sort
		// String orderBy = request.getParameter("orderBy");
		// System.out.println(orderBy);
		OrderBy order = null;
		// xu ly chung - viet lai
		String orderBy = request.getParameter("orderBy");
		System.out.println(orderBy);
		order = orderBy == null ? OrderBy.ID : OrderBy.valueOf(orderBy); // neu khong truyen vao, mac dinh la orderBy ID
		// neu pageId = null thi mac dinh la 1
		int pageId = request.getParameter("pageId") == null ? 1 : Integer.valueOf(request.getParameter("pageId"));

		BookDAO productDao = new BookDAOImpl();
		List<Book> products = productDao.getAllProductsLimit(order, pageId);

		request.setAttribute("products", products);
		request.getRequestDispatcher("client/jsp/listProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
