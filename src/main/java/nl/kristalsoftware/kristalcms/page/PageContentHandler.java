package nl.kristalsoftware.kristalcms.page;

/**
 * Created by sjoerdadema on 22-05-15.
 */
public interface PageContentHandler {

    public StringBuilder getPage(String contextPath, String customerName, String nodePath);

}
