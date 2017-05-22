package com.uniandes.tallertres.util;

import com.uniandes.tallertres.entity.Ready;

import java.io.*;

/**
 * Created by jfsan on 22-May-17.
 */
public class Recommender {

    public static void Recommend(Ready ready) {
        try {
            String pathToJar = System.getProperty("user.dir") + "\\lib\\T3.jar";
            String[] commands = new String[]{"java", "-classpath", pathToJar, "WekaT3", String.valueOf(ready.getTimestampfrom())
                    , String.valueOf(ready.getTimestampto()), String.valueOf(ready.getUserid()), String.valueOf(ready.getMovieid())
                    , String.valueOf(ready.getId())};
            ProcessBuilder pb = new ProcessBuilder(commands);
            pb.directory(new File(System.getProperty("user.dir")));
            try {
                Process p = pb.start();
                LogStreamReader lsr = new LogStreamReader(p.getInputStream());
                Thread thread = new Thread(lsr, "LogStreamReader");
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

class LogStreamReader implements Runnable {

    private BufferedReader reader;

    public LogStreamReader(InputStream is) {
        this.reader = new BufferedReader(new InputStreamReader(is));
    }

    public void run() {
        try {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
