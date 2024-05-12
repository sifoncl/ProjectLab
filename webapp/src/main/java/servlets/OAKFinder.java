package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.BiochemicalDto;
import org.example.dto.OAKDto;
import org.example.dto.UserDto;
import org.example.services.BiochemicalService;
import org.example.services.OAKService;

import java.io.IOException;
import java.util.List;

@WebServlet("/oakfinder")
public class OAKFinder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getSession().getAttribute("userDto");

        List<OAKDto> allOAK = OAKService.getAllUserResults(user.getId());


        req.getSession().setAttribute("allOAK",allOAK);
        req.getRequestDispatcher("/oaklist.jsp").forward(req, resp);
    }
}
