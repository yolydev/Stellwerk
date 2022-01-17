package at.plexnet.stellwerk;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private final Plugin plugin;

    private static File file;
    private static FileConfiguration config;

    public FileManager(Plugin plugin) {
        this.plugin = plugin;
    }

    public void createUserFiles(Player player) {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Stellwerk").getDataFolder(), "UserFiles/" + player.getUniqueId() + ".yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            config = YamlConfiguration.loadConfiguration(file);
        }
    }
}
