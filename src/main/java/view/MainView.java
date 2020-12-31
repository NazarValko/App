package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainView {

    private String path;
    private String index;
    private String menu;
    private String login;
    private static MainView ourInstance = new MainView();

    public static MainView getOurInstance() {
        return ourInstance;
    }
    private MainView(){

    }
    public void setPath(String path) {
        this.path = path;
        this.index = getPartialHtml("index");
        this.menu = getPartialHtml("menu");
        this.login = getPartialHtml("login");
    }

    public String getPath() {
        return path;
    }

    public String getIndex() {
        return index;
    }

    public String getMenu() {
        return menu;
    }
    public String getLogin() {
        return login;
    }

    private String getPartialHtml(String filename){
        StringBuilder strb = new StringBuilder();
        Path file = Paths.get(this.path + filename + ".html");
        Charset charset = Charset.forName("UTF-8");


        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                strb.append(line).append("\n");
            }
        }catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return strb.toString();
    }
}
