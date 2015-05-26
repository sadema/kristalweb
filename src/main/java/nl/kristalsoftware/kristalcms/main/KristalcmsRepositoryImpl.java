package nl.kristalsoftware.kristalcms.main;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jcr.*;
import java.io.*;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 24-05-15.
 */
@ApplicationScoped
public class KristalcmsRepositoryImpl implements BaseRepository {

    @Inject
    private Logger logger;

    @Resource(mappedName="java:/jcr/kristalcms")
    private javax.jcr.Repository repository;

    public KristalcmsRepositoryImpl() {}

    @PostConstruct
    public void init() {
        logger.info("init postconstruct in KristalcmsRepositoryImpl");
        try {
            Session session = repository.login();
            Node rootNode = session.getRootNode();
            if (!rootNode.hasNode("site")) {
                logger.info("No site node available, import.....");
                this.importXML(session, "kristalcmspages.xml");
            }
            else {
                logger.info("The site node found");
                this.exportXML(session);
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkForContent() {
        logger.info("calling checkForContent() method");
    }

    private void importXML(Session session, String xmlFileName) {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream is = loader.getResourceAsStream(xmlFileName);
        if (is != null) {
            try {
                session.importXML("/", is, ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
                session.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("The file " + xmlFileName + " not found.");
        }
    }

    private void exportXML(Session session) {
        try {
            session.exportSystemView("/site", new FileOutputStream(new File("/Volumes/LaCie/tmp_output/kristalcms/site.xml")), false, false);
            //session.exportSystemView("/config", new FileOutputStream(new File("/Users/sjoerd/Documents/tmp/config.xml")), false, false);
            //session.exportSystemView("/orders", new FileOutputStream(new File("/Users/sjoerd/Documents/tmp/orders.xml")), false, false);
            //session.exportSystemView("/countries", new FileOutputStream(new File("/Users/sjoerd/Documents/tmp/dealers.xml")), false, false);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

}
