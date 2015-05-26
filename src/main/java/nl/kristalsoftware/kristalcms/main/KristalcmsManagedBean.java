package nl.kristalsoftware.kristalcms.main;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 24-05-15.
 */
@ApplicationScoped
public class KristalcmsManagedBean {

    @Inject
    private Logger logger;

    //@Inject
    //private BaseRepository cmsRepository;

    public KristalcmsManagedBean() {
        logger.info("KristalcmsManagedBean constructor");
    }

}
