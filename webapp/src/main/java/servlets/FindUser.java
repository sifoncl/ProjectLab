package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.UserDao;
import org.example.dto.UserDto;
import org.example.services.UserService;

import java.io.IOException;

@WebServlet("/finduser")
public class FindUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        UserDto userDto =UserService.getUserById(id);
        req.getSession().setAttribute("userDto",userDto);
        req.getRequestDispatcher("/userinfo.jsp").forward(req, resp);
    }
}
