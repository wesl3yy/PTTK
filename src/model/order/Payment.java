package model.order;

import java.io.Serializable;

public class Payment implements Serializable{
    static final long serialVersionUID = 13L;
    private int id;
    private Order order;
    private String type;

    public Payment(int id, Order order, String type) {
        this.id = id;
        this.order = order;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
