package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/11/13
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "RestaurantXSDServlet", urlPatterns = "/restaurants/xsd")
public class RestaurantXSDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String relativePath = "\\WEB-INF\\resources\\Restaurants.xsd";
        String absoluteFilePath = getServletContext().getRealPath(relativePath);
        File file = new File(absoluteFilePath);

        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        response.setContentType("text/xml;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String currentLine;

        while((currentLine = bufferedReader.readLine()) != null){
            out.append(currentLine);
        }
        out.flush();
    }
}
