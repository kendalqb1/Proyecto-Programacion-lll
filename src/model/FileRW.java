package model;

import java.io.*;
import java.util.Scanner;

public class FileRW {

    public final File routeFile = new File("src/Facture/Facturas.txt");

    public boolean writeData(String data) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = routeFile;
            if (!routeFile.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean writeDataOrders(String data) {
        try {
            FileWriter w = new FileWriter("src/Facture/Facturas.txt");
            w.write(data);
            w.close();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public String readData() {
        try {
            Scanner sc = new Scanner(routeFile);
            String data = "";
            while (sc.hasNextLine()) {
                data += sc.nextLine() + "\n";
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }


}
