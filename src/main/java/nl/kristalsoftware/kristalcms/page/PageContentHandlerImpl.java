package nl.kristalsoftware.kristalcms.page;

/**
 * Created by sjoerdadema on 22-05-15.
 */
public class PageContentHandlerImpl implements PageContentHandler {

    public PageContentHandlerImpl() {}

    @Override
    public StringBuilder getPage(String contextPath, String customerName, String nodePath) {
        StringBuilder page = new StringBuilder("<html><head><title>KristalCMS</title></head><body>");
        page.append("<h1>Hello ").append(customerName).append("</h1>");
        page.append("<p>").append(nodePath).append("</p>");
        page.append("</body></html>");
        return page;
    }

}
