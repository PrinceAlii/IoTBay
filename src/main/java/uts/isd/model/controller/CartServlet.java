package uts.isd.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.OrderLineItem;
import java.util.ArrayList;
import java.util.List;

public class CartServlet extends HttpServlet {

    // forward to doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<OrderLineItem> cart = (List<OrderLineItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) { // use a switch statement to handle different actions
                case "add":
                    addToCart(request, cart);
                    break;
                case "update":
                    updateCart(request, cart);
                    break;
                case "remove":
                    removeFromCart(request, cart);
                    break;
                case "cancel":
                    cancelOrder(session);
                    break;
                case "submit":
                    submitOrder(session, cart);
                    break;
            }
        }
        response.sendRedirect("cart.jsp"); // redirect to the cart page to show updated cart
    }

    private void addToCart(HttpServletRequest request, List<OrderLineItem> cart) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = 1; // default quantity
        boolean found = false;
    
        for (OrderLineItem item : cart) {
            if (item.getProductID() == productId) {
                item.setOrderQuantity(item.getOrderQuantity() + quantity);
                found = true;
                break;
            }
        }

        if (!found) {
            OrderLineItem newItem = new OrderLineItem(0, 0, productId, quantity);
            cart.add(newItem);
        }
    }

    private void updateCart(HttpServletRequest request, List<OrderLineItem> cart) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        cart.stream()
            .filter(item -> item.getProductID() == productId)
            .findFirst()
            .ifPresent(item -> item.setOrderQuantity(quantity));
    }

    private void removeFromCart(HttpServletRequest request, List<OrderLineItem> cart) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        cart.removeIf(item -> item.getProductID() == productId);
    }

    private void cancelOrder(HttpSession session) {
        session.removeAttribute("cart"); // clear the cart by removing it from the session
    }

    private void submitOrder(HttpSession session, List<OrderLineItem> cart) {
        session.removeAttribute("cart"); // clear the cart after submitting
    }
}
