package nl.kristalsoftware.kristalcms.main;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 24-05-15.
 */
@ApplicationScoped
public class KristalcmsRepositoryImpl implements BaseRepository {

    @Inject
    private Logger logger;

    public KristalcmsRepositoryImpl() {}

    @PostConstruct
    public void init() {
        logger.info("init postconstruct in KristalcmsRepositoryImpl");
    }

    @Override
    public void checkForContent() {
        logger.info("calling checkForContent() method");
    }

}
