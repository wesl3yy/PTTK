package logicapplication.controller.manager;

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
import util.Constants;
import util.OrderBy;

@WebServlet("/admin/products-management")
public class ProductsManagementController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO productDao;
    public ProductsManagementController() {
        super();
        productDao = new BookDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        // check action (EDIT / DELETE)
        String action = request.getParameter("action");
        if(action != null) {
            if(action.equals("EDIT")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Book prodct = productDao.getProductById(id);
                if(prodct.getType().equals("magazine")){
                    Magazine ns = productDao.getMagazine(id);
                    request.setAttribute("prodct", ns);
                } else{
                    Books books = productDao.getBooks(id);
                    request.setAttribute("prodct", books);
                }
            } else if(action.equals("DELETE")) {
                int id = Integer.parseInt(request.getParameter("id"));
                productDao.removeProduct(id);
            }
        }

        // Current page
        int pageId = 1;
        if(request.getParameter("pageId") != null)
            pageId = Integer.parseInt(request.getParameter("pageId"));

        List<Book> products = productDao.getAllProductsLimit(OrderBy.ID,pageId);

        CategoryDAO categoryDao = new CategoryDAOImpl();
        List<Category> categories = categoryDao.getAllCategories();

        request.setAttribute("products", products);
        request.setAttribute("categories", categories);

        // Pagination
        int nbOfProducts = productDao.countProducts(); // dem so product
        int pages = (int) Math.ceil((double) nbOfProducts / Constants.NUMBER_PER_PAGES); // tinh so trang 
        request.setAttribute("pages", pages);

        request.getRequestDispatcher("./jsp/products-management.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        // action = ADD / UPDATE
        String action = request.getParameter("action");

        int id = request.getParameter("product-id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("product-id"));
        String isbn = request.getParameter("product-isbn");
        String name = request.getParameter("product-name");
        double price = Double.parseDouble(request.getParameter("product-price"));
        int cateId = Integer.parseInt(request.getParameter("cateId"));
        String type = request.getParameter("product-type");
        String img = request.getParameter("product-img");
        if(type.equals("books")){
            Books books = new Books();
            books.setId(id);
            books.setName(name);
            books.setIsbn(isbn);
            books.setPrice(price);
            books.setCategory(new CategoryDAOImpl().getCategoryById(cateId));
            books.setType(type);
            books.setImg(img);
            String publicdate = request.getParameter("product-publicationdate");
            String numberofpage = request.getParameter("product-numberofpage");
            String language = request.getParameter("product-language");
            String author = request.getParameter("product-author");
            String publisher = request.getParameter("product-publisher");
            books.setPublicdate(publicdate);
            books.setNumberofpage(numberofpage);
            books.setLanguage(language);
            books.setAuthor(author);
            books.setPublisher(publisher);
            if(action.equals("ADD")) {
                productDao.addBooks(books);
            } else if(action.equals("UPDATE")) {
                productDao.updateBooks(books);
            }
        } else{
            Magazine ns = new Magazine();
            ns.setId(id);
            ns.setName(name);
            ns.setIsbn(isbn);
            ns.setPrice(price);
            ns.setCategory(new CategoryDAOImpl().getCategoryById(cateId));
            ns.setType(type);
            ns.setImg(img);
            String publicdate = request.getParameter("product-publicationdate");
            String numberofpage = request.getParameter("product-numberofpage");
            String language = request.getParameter("product-language");
            ns.setPublicdate(publicdate);
            ns.setNumberofpage(numberofpage);
            ns.setLanguage(language);
            if(action.equals("ADD")) {
                productDao.addMagazine(ns);
            } else if(action.equals("UPDATE")) {
                productDao.updateMagazine(ns);
            }
        }
        response.sendRedirect("products-management");
    }
}
