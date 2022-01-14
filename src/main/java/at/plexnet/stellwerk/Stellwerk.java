package at.plexnet.stellwerk;

import at.plexnet.stellwerk.commands.DateCommand;
import at.plexnet.stellwerk.commands.TestCommand;
import at.plexnet.stellwerk.events.ChatEvent;
import at.plexnet.stellwerk.events.JoinEvent;
import at.plexnet.stellwerk.events.QuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Stellwerk extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("[Stellwerk] wird aktiviert.");

        commands();
        events();
        createFolder();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("[Stellwerk] wird deaktiviert.");
    }

    public static String getPrefix() {
        return ChatColor.GRAY + "(" + ChatColor.GOLD + "Stellwerk" + ChatColor.GRAY + ") " + ChatColor.GRAY;
    }

    public void commands() {
        getCommand("test").setExecutor(new TestCommand());
        getCommand("date").setExecutor(new DateCommand());
    }

    public void events() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinEvent(), this);
        manager.registerEvents(new QuitEvent(), this);
        manager.registerEvents(new ChatEvent(), this);
    }

    public void createFolder() {
        File file = new File("plugins/Stellwerk");
        File config = new File("plugins/Stellwerk/config.txt");
        if(!file.exists()) {
            file.mkdirs();

            if(!config.exists()) {
                try {
                    config.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
