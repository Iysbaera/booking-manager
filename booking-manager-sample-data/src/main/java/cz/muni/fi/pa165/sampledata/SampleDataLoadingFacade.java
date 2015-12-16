package cz.muni.fi.pa165.sampledata;

import java.io.IOException;
import java.text.ParseException;

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
     * @throws java.text.ParseException
     */
    void loadData() throws IOException, ParseException;

}
