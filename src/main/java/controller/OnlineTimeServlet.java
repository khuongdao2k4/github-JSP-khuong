package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/online")
public class OnlineTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Long createTime = (Long) session.getAttribute("createTime");

        if (createTime == null) {
            createTime = System.currentTimeMillis();
            session.setAttribute("createTime", createTime);
        }

        long onlineTime = (System.currentTimeMillis() - createTime) / 1000;
        session.setAttribute("onlineTime", onlineTime);

        request.getRequestDispatcher("online.jsp").forward(request, response);
    }
}
