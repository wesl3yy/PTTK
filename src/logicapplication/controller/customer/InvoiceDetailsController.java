package logicapplication.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.categoryDAO.CategoryDAO;
import logicapplication.orderDAO.OrderDAO;
import logicapplication.categoryDAO.CategoryDAOImpl;
import logicapplication.orderDAO.OrderDAOImpl;
import model.category.Category;
import model.book.BookItem;

@WebServlet(urlPatterns= {"/invoice-details"})
public class InvoiceDetailsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public InvoiceDetailsController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("id"));

            OrderDAO orderDao = new OrderDAOImpl();
            List<BookItem> items = orderDao.getOrderByOrderId(id);
            request.setAttribute("items", items);

            CategoryDAO categoryDao = new CategoryDAOImpl();
            List<Category> categories = categoryDao.getAllCategories();
            request.setAttribute("categories", categories);

            double price = 0D;
            int quantity = 0;
            for(BookItem item : items) {
                    price += item.getPrice() * item.getQuantity();
                    quantity += item.getQuantity();
            }
            request.setAttribute("price", price);
            request.setAttribute("quantity", quantity);

            request.getRequestDispatcher("client/jsp/invoice-details.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

}