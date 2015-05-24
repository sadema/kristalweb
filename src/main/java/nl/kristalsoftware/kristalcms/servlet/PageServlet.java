package nl.kristalsoftware.kristalcms.servlet;

import nl.kristalsoftware.kristalcms.main.BaseRepository;
import nl.kristalsoftware.kristalcms.page.PageContentHandler;
import nl.kristalsoftware.kristalcms.page.PageContentHandlerImpl;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 21-05-15.
 */
@WebServlet(name = "PageServlet", urlPatterns = {"/cms/*"} )
public class PageServlet extends HttpServlet {

    @Inject
    private Logger logger;

    @Inject
    private PageContentHandler pageContentHandler; // = null;

    @Inject
    private BaseRepository cmsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cmsRepository.checkForContent();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        String nodePath = uri.replace(contextPath, "");
        logger.info("nodePath: " + nodePath);
        String name = nodePath.replace("/cms/", "");
        logger.info("customerName: " + name);
        if (name.contains("/")) {
            int pos = name.indexOf('/');
            name = name.substring(0, pos);
        }
        logger.info("customerName: " + name);
        out.append(pageContentHandler.getPage(contextPath, name, nodePath));
        //String name = uri.substring(uri.lastIndexOf("site/"));
        //out.append("<html>");
        //out.append("<head><title>KristalCMS</title></head>");
        //out.append("<body>");
        //out.append("<h1>Hello ").append(name).append("</h1>");
        //out.append("<p>").append(request.getRequestURI()).append("</p>");
        //out.append("<p>").append(nodePath).append("</p>");
        //out.append("</body>");
        //out.append("</html>");
    }
}
