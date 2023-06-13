package pedidos;

import entities.Client;
import entities.OrderItem;
import entities.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;

    private OrderStatus status;

    private List<OrderItem> Orderitem = new ArrayList<>();

    private Client client;


    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");


    public Order() {

    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderitem() {
        return Orderitem;
    }

    public void setOrderitem(List<OrderItem> orderitem) {
        Orderitem = orderitem;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order(Date moment, OrderStatus status, Client client) {

        this.moment = moment;
        this.status = status;
        this.client = client;
    }


    public void addItem(OrderItem item) {
        Orderitem.add(item);
    }

    public void removeItem(OrderItem item) {
        Orderitem.remove(item);
    }

    public Object total() {
        double sum = 0.0;
        for (OrderItem item : Orderitem) {
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Moment");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order Status");
        sb.append(status + "\n");
        sb.append("Client : ");
        for (OrderItem item : Orderitem) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }

}
