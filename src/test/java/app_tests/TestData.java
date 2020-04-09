package app_tests;

import org.apache.log4j.Logger;
import page_objects.Interactions;

import java.util.HashMap;
import java.util.Properties;

public class TestData {
    private Properties prop;

    private static TestData instance = null;

    static public HashMap<String, String> envdata;
    private static final Logger log = Logger.getLogger(Interactions.class);

    public static TestData getInstance() {
        if(instance==null){
            instance = new TestData();
        }
        return instance;
    }

}
