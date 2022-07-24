/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import java.io.File;
import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;


/**
 *
 * @author vojtechkylar
 */
public class StartApp implements Watchable {

    public static void move(File file, String url) {
        try {
            Files.move(Path.of(file.getPath()), Path.of(url + "/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(StartApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static WatchKey watchDir(String uri) {
        Path dir = Path.of(uri);
        try {
            WatchService ws = FileSystems.getDefault().newWatchService();
            WatchKey key = dir.register(ws, ENTRY_MODIFY,
                    ENTRY_DELETE,
                    ENTRY_MODIFY);
            return key;
        } catch (IOException ex) {
            System.out.println("FU");
            return null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String downloadFolderPath = "/Users/vojtechkylar/Downloads";
        String downloadImagesPath = "/Users/vojtechkylar/DownloadImages";
        String downloadJarPath = "/Users/vojtechkylar/DownloadJar";
        String ModelsPath = "/Users/vojtechkylar/Models";
        
        WatchKey key = watchDir(downloadFolderPath);
        while (true) {
            for (WatchEvent<?> pollEvent : key.pollEvents()) {

                if (pollEvent.kind() == ENTRY_MODIFY) {
                    File folder = new File(downloadFolderPath);
                    for (File file : folder.listFiles()) {
                        String extension = "";
                        int i = file.getName().lastIndexOf('.');
                        if (i > 0) {
                            extension = file.getName().substring(i + 1);
                        }

                        if (extension.equals("jpeg") || extension.equals("jpg") || extension.equals("png") || extension.equals("gif")) {
                            move(file, downloadImagesPath);
                        } else if (extension.equals("jar")) {
                            move(file, downloadJarPath);
                        } else if (extension.equals("stl") || extension.equals("3mf")) {
                            move(file, ModelsPath);
                        }
                    }
                }
            }
        }

    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
