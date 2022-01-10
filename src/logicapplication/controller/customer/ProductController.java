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
import model.book.Books;
import model.book.Magazine;

@WebServlet(urlPatterns= {"/product/*","/san-pham/*"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 1;
		if(request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		
		BookDAO productDao = new BookDAOImpl();
		Book product = productDao.getProductById(id);
		if(product == null) { // neu id product sai
			response.sendRedirect("error");
			return;
		}
                if(product.getType().equals("magazine")){
                    Magazine ns = productDao.getMagazine(id);
                    // neu san pham tim thay trong csdl
                    request.setAttribute("product", ns);
                } else if(product.getType().equals("books")){
                    Books books = productDao.getBooks(id);
                    request.setAttribute("product", books);
                }
		
		
		// lay danh sach category
		CategoryDAO categoryDao = new CategoryDAOImpl();
		List<Category> categories = categoryDao.getAllCategories();
		request.setAttribute("categories", categories);
                
		
		// chuyen huong ve view
		request.getRequestDispatcher("client/jsp/product.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
