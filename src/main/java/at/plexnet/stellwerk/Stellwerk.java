package at.plexnet.stellwerk;

import at.plexnet.stellwerk.commands.DateCommand;
import at.plexnet.stellwerk.commands.GroupAddCommand;
import at.plexnet.stellwerk.commands.TestCommand;
import at.plexnet.stellwerk.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Stellwerk extends JavaPlugin {
    public static Stellwerk instance;
    private StellwerkGroupManager stellwerkGroupManager;
    private FileManager fileManager;

    FileConfiguration config = getConfig();
    // Reading from the config
    //String name = plugin.getConfig().getString("player-name");

    // Writing to the config
    //plugin.getConfig().set("player-name", name);

    @Override
    public void onEnable() {
        instance = this;
        this.stellwerkGroupManager = new StellwerkGroupManager(this);
        this.fileManager = new FileManager(this);
        commands();
        events();
        createConfig();
    }

    @Override
    public void onDisable() { }

    public void createConfig() {
        config.options().copyDefaults(true);
        saveConfig();
    }

    public static Stellwerk getInstance() {
        return instance;
    }

    public StellwerkGroupManager getStellwerkGroupManager() {
        return stellwerkGroupManager;
    }
    public FileManager getFileManager() { return fileManager; }

    public static String getPrefix() {
        return ChatColor.GRAY + "(" + ChatColor.GOLD + "Stellwerk" + ChatColor.GRAY + ") " + ChatColor.GRAY;
    }

    public void commands() {
        getCommand("test").setExecutor(new TestCommand());
        getCommand("date").setExecutor(new DateCommand());
        getCommand("groupadd").setExecutor(new GroupAddCommand());
    }

    public void events() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinEvent(), this);
        manager.registerEvents(new QuitEvent(), this);
        manager.registerEvents(new ChatEvent(), this);
        manager.registerEvents(new GUIEvent(), this);
        manager.registerEvents(new BlockEvent(), this);
    }
}
