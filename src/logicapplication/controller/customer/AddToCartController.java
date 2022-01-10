package logicapplication.controller.customer;

import logicapplication.categoryDAO.CategoryDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logicapplication.bookDAO.BookDAO;
import logicapplication.categoryDAO.CategoryDAOImpl;
import logicapplication.bookDAO.BookDAOImpl;
import model.category.Category;
import model.book.BookItem;
import model.order.Order;
import model.book.Book;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO productDao;
    
    public AddToCartController() {
        super();
        productDao = new BookDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = 1;
        int id;
        CategoryDAO categoryDao = new CategoryDAOImpl();
        List<Category> categories = categoryDao.getAllCategories();
        request.setAttribute("categories", categories);
        if(request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
            Book product = productDao.getProductById(id);
            if(product != null) {
                quantity = Integer.parseInt(request.getParameter("quantity"));
                HttpSession session = request.getSession();
                if(session.getAttribute("order") == null) { // chua co order nao
                    Order order = new Order();
                    List<BookItem> listItems = new ArrayList<>();
                    BookItem item = new BookItem();
                    item.setQuantity(quantity);
                    item.setProduct(product);
                    item.setPrice(product.getPrice());
                    listItems.add(item);
                    order.setItems(listItems);
                    session.setAttribute("order", order);
                } else { // neu order da ton tai trong session
                    Order order = (Order) session.getAttribute("order");
                    List<BookItem> listItems = order.getItems();
                    boolean isProductExist = false;
                    for(BookItem i : listItems) {
                        if(i.getProduct().getId() == id) {
                            i.setQuantity(i.getQuantity() + quantity);
                            isProductExist = true;
                        }
                    }
                    if(isProductExist == false) {
                        BookItem item = new BookItem();
                        item.setProduct(product);
                        item.setQuantity(quantity);
                        item.setPrice(product.getPrice());
                        listItems.add(item);
                    }
                    session.setAttribute("order", order);
                }
                response.sendRedirect("cart");
            } else response.sendRedirect("./");			
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
