package at.plexnet.stellwerk.commands;

import at.plexnet.stellwerk.Stellwerk;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Date;

public class DateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Date date = new Date();
        sender.sendMessage(Stellwerk.getPrefix() + "Heutiges Datum: " + ChatColor.GOLD + date.toString() + ChatColor.GRAY + ".");
        return false;
    }
}
