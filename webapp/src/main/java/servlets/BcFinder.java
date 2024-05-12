package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.BiochemicalDao;
import org.example.dao.UserDao;
import org.example.dto.BiochemicalDto;
import org.example.dto.UserDto;
import org.example.services.BiochemicalService;

import java.io.IOException;
import java.util.List;

@WebServlet("/biochemicalfinder")
public class BcFinder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getSession().getAttribute("userDto");

        List<BiochemicalDto> allBc = BiochemicalService.getAllUserResults(user.getId());

        System.out.println(allBc.getFirst());
        req.getSession().setAttribute("allBc",allBc);
        req.getRequestDispatcher("/bclist.jsp").forward(req, resp);
    }
}
