package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileRW {

    public final File routeFile = new File("Facturas.txt");

    public boolean writeData(String data) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = routeFile;
           if ( !routeFile.exists() ) {
               file.createNewFile();
           }
           fw = new FileWriter(file.getAbsoluteFile(), true);
           bw = new BufferedWriter(fw);
           bw.write(data);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if ( fw != null) {
                    fw.close();
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }




}
