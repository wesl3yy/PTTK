package logicapplication.controller.manager;

import logicapplication.categoryDAO.CategoryDAO;
import logicapplication.managerDAO.ManagerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import logicapplication.customerDAO.CustomerDAO;
import logicapplication.categoryDAO.CategoryDAOImpl;
import logicapplication.managerDAO.ManagerDAOImpl;
import logicapplication.customerDAO.CustomerDAOImpl;
import java.util.List;
import model.category.Category;
import util.Common;
import util.Constants;

@WebServlet(urlPatterns= {"/admin/login"})
public class ManagerLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public ManagerLoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/jsp/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ManagerDAO managerDAO = new ManagerDAOImpl();
        boolean result = managerDAO.checkLoginInfo(username, Common.MD5(password));
        System.out.println(username + " " + password + " " + result);
        if(result == true) {
            HttpSession session = request.getSession();
            session.setAttribute("login_user", username);
            response.sendRedirect("/eshop/admin/home");
        }
        else {
            request.setAttribute("errorMess", Constants.WRONG_USERNAME_OR_PASSWORD);
            request.getRequestDispatcher("/admin/jsp/login.jsp").forward(request, response);
        }

    }

}
