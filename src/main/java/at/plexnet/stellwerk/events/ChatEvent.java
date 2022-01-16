package at.plexnet.stellwerk.events;

import at.plexnet.stellwerk.Stellwerk;
import at.plexnet.stellwerk.StellwerkGroupManager;
import at.plexnet.stellwerk.commands.GroupAddCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    StellwerkGroupManager manager = Stellwerk.getInstance().getStellwerkGroupManager();

    private String userPrefix = "(User) ";
    private String adminPrefix = "(Admin) ";

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if((!manager.isUser(player)) && (!manager.isAdmin(player))) {
            event.setFormat(event.getPlayer().getName() + ": " + event.getMessage());
        }
        for(Player temp : manager.getUser()){
            event.setFormat(userPrefix + temp.getName() + ": " + event.getMessage());
        }

        for(Player temp : manager.getAdmin()){
            event.setFormat(adminPrefix + temp.getName() + ": " + event.getMessage());
        }
    }
}
