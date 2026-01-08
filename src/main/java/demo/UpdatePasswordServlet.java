package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String newPass = request.getParameter("newpass");

        try {
            Connection con = DBConnection.getConnection();
            con.setAutoCommit(true);

            String sql = "UPDATE users SET password=? WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newPass);
            ps.setString(2, username);

            int rows = ps.executeUpdate();

            System.out.println("Rows updated: " + rows);

            if (rows > 0) {
                request.setAttribute("msg", "Password updated successfully!");
            } else {
                request.setAttribute("msg", "User not found!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}