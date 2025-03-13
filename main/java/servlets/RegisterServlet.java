package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Register;
import dao.ToDoDAO;
import dao.ToDoDAOImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  // Handles POST requests
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Set response content type
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      // Reading form data
      String fname = request.getParameter("fname");
      String lname = request.getParameter("lname");
      String email = request.getParameter("email");
      String pass = request.getParameter("pass");
      String mobileStr = request.getParameter("mobile");
      String address = request.getParameter("address");

      // Check for null values or empty strings
      if (fname == null || lname == null || email == null || pass == null || mobileStr == null || address == null ||
          fname.trim().isEmpty() || lname.trim().isEmpty() || email.trim().isEmpty() ||
          pass.trim().isEmpty() || mobileStr.trim().isEmpty() || address.trim().isEmpty()) {

        out.println("<h3>All fields are required!</h3>");
        return;
      }

      long mobile = 0;

      try {
        mobile = Long.parseLong(mobileStr.trim());
      } catch (NumberFormatException e) {
        out.println("<h3>Invalid Mobile Number!</h3>");
        return;
      }

      // Create Register Bean Object
      Register reg = new Register(0, fname.trim(), lname.trim(), email.trim(), pass.trim(), mobile, address.trim());

      // DAO Object
      ToDoDAO dao = ToDoDAOImpl.getInstance();
      int regId = dao.register(reg);

      if (regId > 0) {
        response.sendRedirect("Login.jsp"); // Redirect to login page on success
      } else {
        out.println("<h3>Registration Failed. Please Try Again!</h3>");
      }

    } catch (Exception e) {
      e.printStackTrace();
      out.println("<h3>An Error Occurred: " + e.getMessage() + "</h3>");
    } finally {
      out.close();
    }
  }
}
