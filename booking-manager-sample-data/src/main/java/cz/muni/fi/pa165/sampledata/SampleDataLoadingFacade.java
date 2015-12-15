package cz.muni.fi.pa165.sampledata;

import java.io.IOException;

/**
 * Provides sample data.
 *
 * @author Ivo Hradek
 */
public interface SampleDataLoadingFacade {

    /**
     * Loads data to the database.
     *
     * @throws IOException
     */
    void loadData() throws IOException;

}
