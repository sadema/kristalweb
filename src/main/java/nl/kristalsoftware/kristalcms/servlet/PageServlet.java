package nl.kristalsoftware.kristalcms.servlet;

import nl.kristalsoftware.kristalcms.page.PageContentHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sjoerdadema on 21-05-15.
 */
@WebServlet(name = "PageServlet", urlPatterns = {"/site/*"} )
public class PageServlet extends HttpServlet {

    private PageContentHandler pageContentHandler = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        pageContentHandler = new PageContentHandler();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //StringBuilder uri = new StringBuilder(request.getRequestURI());
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        String name = uri.replace(contextPath + "/site/", "");
        if (name.contains("/")) {
            int pos = name.indexOf('/');
            name = name.substring(0, pos);
        }
        //String name = uri.substring(uri.lastIndexOf("site/"));
        out.append("<html>");
        out.append("<head><title>KristalCMS</title></head>");
        out.append("<body>");
        out.append("<h1>Hello ").append(name).append("</h1>");
        out.append("<p>").append(request.getRequestURI()).append("</p>");
        out.append("</body>");
        out.append("</html>");
    }
}
