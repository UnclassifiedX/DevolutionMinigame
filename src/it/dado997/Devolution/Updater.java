package it.dado997.Devolution;

import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.function.Consumer;

public class Updater {

    private int project;
    private URL checkURL;
    private String newVersion;
    private Main plugin;

    public Updater(Main plugin, int projectID) {
        this.plugin = plugin;
        project = projectID;
        newVersion = plugin.getDescription().getVersion();
        try {
            checkURL = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + projectID);
        }catch(MalformedURLException e) {
            Bukkit.getLogger().warning("§4Could not connect to Spigot, plugin disabled!");
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }

    public boolean checkForUpdates() throws Exception {
        URLConnection con = checkURL.openConnection();
        newVersion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
        return !plugin.getDescription().getVersion().equalsIgnoreCase(newVersion);
    }

}
