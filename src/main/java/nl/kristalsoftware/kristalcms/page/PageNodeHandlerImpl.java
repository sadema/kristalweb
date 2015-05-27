package nl.kristalsoftware.kristalcms.page;

import nl.kristalsoftware.kristalcms.main.KristalcmsManagedBean;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * Created by sjoerdadema on 22-05-15.
 */
public class PageNodeHandlerImpl implements PageNodeHandler {

    @Inject
    private Session session;

    public PageNodeHandlerImpl() {}

    @Override
    public boolean nodeExists(String path) {
        boolean nodeExists = false;
        try {
            nodeExists = session.nodeExists(path);
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        return nodeExists;
    }
}
