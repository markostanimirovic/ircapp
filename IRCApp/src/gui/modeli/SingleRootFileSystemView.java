/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modeli;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author furtula.filip
 */
public class SingleRootFileSystemView extends FileSystemView {

    private static Properties properties;
    private File root_user;
    private File root;
    private File[] roots = new File[2];

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("system.config"));
        } catch (Exception ex) {
            Logger.getLogger(SingleRootFileSystemView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SingleRootFileSystemView(File root_user) {
        super();
        this.root_user = root_user;
        this.root = new File(properties.getProperty("local_path"));
        roots[0] = this.root;
        roots[1] = this.root_user;

    }

    @Override
    public File createNewFolder(File containingDir) throws IOException {
        File folder = new File(containingDir, "New Folder");
        folder.mkdir();
        return folder;
    }

    @Override
    public File getDefaultDirectory() {
        return root_user;
    }

    @Override
    public File getHomeDirectory() {
        return root;
    }

    @Override
    public File[] getRoots() {
        return roots;
    }

}
