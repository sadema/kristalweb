package nl.kristalsoftware.kristalweb.page;

import javax.jcr.RepositoryException;

/**
 * Created by sjoerdadema on 22-05-15.
 */
public interface PageNodeHandler {

    boolean nodeExists(String path);

    boolean createFileNode(String nodePath, String content);

    String getPage(String path) throws RepositoryException;

}
