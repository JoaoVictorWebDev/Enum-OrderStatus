import entities.Client;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;
import pedidos.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data");
        System.out.print("Name Client: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date  (DD/MM/YYYY)");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);
        System.out.println("Enter Order Data");
        System.out.println("STATUS: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        System.out.println("How many items to this order");
        int n = sc.nextInt();

        Order order = new Order(new Date(), status, client);

        for (int i = 0; i <= n; i++) {
            System.out.println("Enter the product # " + i);
            System.out.println("Product Name");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Product Price");
            double ProductPrice = sc.nextDouble();
            Product product = new Product(productName, ProductPrice);
            System.out.println("Quantity");

            int quantity = sc.nextInt();
        }
        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order Moment : " + birthDate);
        System.out.println("Order Status" + order );

        sc.close();
    }
}
