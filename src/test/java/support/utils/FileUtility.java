package support.utils;

import org.apache.log4j.Logger;
import page_objects.Interactions;
import support.listeners.TestListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class FileUtility {
    private static final Logger log = Logger.getLogger(FileUtility.class);
    public static void appendToFile(String filePath,String value){
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(filePath, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(value);
            out.close();
        } catch (IOException e) {
            log.error("ERROR -Appending text to file");
            log.error(e.getMessage());
            TestListener.getExtentTest().error(e.getMessage());
        }
        finally {
            if(out != null)
                out.close();
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {

            }
        }
    }
}
