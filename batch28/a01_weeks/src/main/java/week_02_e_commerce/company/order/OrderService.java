package week_02_e_commerce.company.order;

import week_02_e_commerce.company.Cart;

public interface OrderService {
    String placeOrder(Cart cart);
}
