import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateCustomerRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve customer information from the request
        String customerId = request.getParameter("customerId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Update the customer record (in this example, just printing the information)
        System.out.println("Customer record updated:");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCustomerRecord.jsp");
        dispatcher.forward(request, response);
    }
}
