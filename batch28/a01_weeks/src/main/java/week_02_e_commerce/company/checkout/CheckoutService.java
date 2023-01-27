package week_02_e_commerce.company.checkout;

import week_02_e_commerce.company.Customer;

public interface CheckoutService {
    boolean checkout(Customer customer, Double totalAmount);
}
