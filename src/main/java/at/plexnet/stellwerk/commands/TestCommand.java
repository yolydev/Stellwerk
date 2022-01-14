package at.plexnet.stellwerk.commands;

import at.plexnet.stellwerk.Stellwerk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        sender.sendMessage(Stellwerk.getPrefix() + "Nix zum Hackln?");
        return false;
    }
}
