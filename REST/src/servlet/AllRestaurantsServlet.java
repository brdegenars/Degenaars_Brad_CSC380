package servlet;

import javax.servlet.annotation.WebServlet;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/11/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/restaurants")
public class AllRestaurantsServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String relativePath = "\\WEB-INF\\resources\\Restaurants.xml";
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
