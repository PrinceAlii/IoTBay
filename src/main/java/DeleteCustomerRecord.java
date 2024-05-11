import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteCustomerRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve customer ID from the request
        String customerId = request.getParameter("customerId");

        // Delete the customer record (in this example, just printing the information)
        System.out.println("Customer record deleted:");
        System.out.println("Customer ID: " + customerId);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteCustomerRecord.jsp");
        dispatcher.forward(request, response);
    }
}

