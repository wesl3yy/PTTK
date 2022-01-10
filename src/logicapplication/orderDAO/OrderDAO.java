package logicapplication.orderDAO;

import java.util.List;

import model.book.BookItem;
import model.order.Order;
import model.order.OrderDTO;

public interface OrderDAO {
	
    List<OrderDTO> getAllOrders();
    List<OrderDTO> getOrdersByUserId(int id); 
    int addOrder(Order order);
    List<BookItem> getOrderByOrderId(int id);
    int countOrders();
    boolean updateOrderStatus(int id, int status);

}
