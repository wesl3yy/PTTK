package logicapplication.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.categoryDAO.CategoryDAO;
import logicapplication.bookDAO.BookDAO;
import logicapplication.categoryDAO.CategoryDAOImpl;
import logicapplication.bookDAO.BookDAOImpl;
import model.category.Category;
import model.book.Book;
import util.OrderBy;

@WebServlet(urlPatterns= {"/home", "/trang-chu"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO categoryDao = new CategoryDAOImpl();
		List<Category> categories = categoryDao.getAllCategories();
		request.setAttribute("categories", categories);
		BookDAO productDao = new BookDAOImpl();
		List<Book> products = productDao.getAllProductsLimit(OrderBy.ID, 1);
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("/client/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
