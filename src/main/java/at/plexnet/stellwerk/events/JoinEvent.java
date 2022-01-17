package at.plexnet.stellwerk.events;

import at.plexnet.stellwerk.FileManager;
import at.plexnet.stellwerk.Stellwerk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class JoinEvent implements Listener {
    FileManager manager = Stellwerk.getInstance().getFileManager();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GOLD + player.getName() + ChatColor.GRAY + " ist dem Server beigetreten.");
        manager.createUserFiles(player);
    }
}
