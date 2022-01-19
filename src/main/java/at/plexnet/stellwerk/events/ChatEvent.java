package at.plexnet.stellwerk.events;

import at.plexnet.stellwerk.Stellwerk;
import at.plexnet.stellwerk.StellwerkGroupManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;

public class ChatEvent implements Listener {
    StellwerkGroupManager manager = Stellwerk.getInstance().getStellwerkGroupManager();
    FileConfiguration config = Stellwerk.getInstance().getConfig();

    private String userPrefix = config.getString("user-prefix");
    private String adminPrefix = config.getString("admin-prefix");

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if((!manager.isUser(player)) && (!manager.isAdmin(player))) {
            event.setFormat(event.getPlayer().getName() + ": " + event.getMessage());
        }
        for(Player tempUser : manager.getUser()){
            event.setFormat(userPrefix + " " + tempUser.getName() + ": " + event.getMessage());
        }
        for(Player tempAdmin : manager.getAdmin()){
            event.setFormat(adminPrefix + " " + tempAdmin.getName() + ": " + event.getMessage());
        }
    }
}
