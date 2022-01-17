package at.plexnet.stellwerk.commands;

import at.plexnet.stellwerk.Stellwerk;
import at.plexnet.stellwerk.StellwerkGroupManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAddCommand implements CommandExecutor {
    StellwerkGroupManager manager = Stellwerk.getInstance().getStellwerkGroupManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //groupadd <player> <group>
        //change to /group add/remove <player> <group>
        //make user/group safe to config.yml

        if(args.length == 0) {
            sender.sendMessage("User List: " + manager.getUser().toString());
            sender.sendMessage("Admin List: " + manager.getAdmin().toString());
        }
        if(args.length == 2) {
            Player player = Bukkit.getPlayer(args[0]);

            if(args[1].equals("user")) {
                if(manager.isUser(player)) {
                    manager.setUser(player, false);
                    sender.sendMessage("Removed " + player.getName() + " from the user list");
                } else {
                    manager.setUser(player, true);
                    sender.sendMessage("Added " + player.getName() + " to the user list");
                }
            } else if(args[1].equals("admin")) {
                if(manager.isAdmin(player)) {
                    manager.setAdmin(player, false);
                    sender.sendMessage("Removed " + player.getName() + " from the admin list");
                } else {
                    manager.setAdmin(player, true);
                    sender.sendMessage("Added " + player.getName() + " to the admin list");
                }
            }
        }
        return false;
    }
}
