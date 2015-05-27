package nl.kristalsoftware.kristalcms.page;

/**
 * Created by sjoerdadema on 22-05-15.
 */
public interface PageContentHandler {

    public StringBuilder getPage(String contextPath, String customerName, String nodePath);

    public boolean pageExists(String nodePath);

    public boolean createPage(String nodePath, String content);

}
