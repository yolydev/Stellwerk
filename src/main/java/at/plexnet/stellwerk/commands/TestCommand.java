package at.plexnet.stellwerk.commands;

import at.plexnet.stellwerk.Stellwerk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;
        openGUI(player);
        return false;
    }

    public Inventory createGUI(String title, int size) {
        return Bukkit.getServer().createInventory(null, size, title);
    }

    public void openGUI(Player player) {
        Inventory gui = this.createGUI("TestGUI", 27);
        ItemStack itemStack = new ItemStack(Material.COOKIE);
        ItemStack gamemodeSurvival = new ItemStack(Material.BLUE_WOOL);
        ItemStack gamemodeCreative = new ItemStack(Material.YELLOW_WOOL);
        ItemStack gamemodeAdventure = new ItemStack(Material.RED_WOOL);
        ItemStack gamemodeSpectator = new ItemStack(Material.GREEN_WOOL);
        ItemStack exitGUI = new ItemStack(Material.BARRIER);

        ItemMeta itemMeta = itemStack.getItemMeta();
        ItemMeta metaSurvival = gamemodeSurvival.getItemMeta();
        ItemMeta metaCreative = gamemodeCreative.getItemMeta();
        ItemMeta metaAdventure = gamemodeAdventure.getItemMeta();
        ItemMeta metaSpectator = gamemodeSpectator.getItemMeta();
        ItemMeta metaGUI = exitGUI.getItemMeta();

        itemMeta.setDisplayName(ChatColor.RESET + "" + ChatColor.BLACK + "Killer Cookie");
        metaSurvival.setDisplayName(ChatColor.RESET + "" + ChatColor.BLUE + "Survival");
        metaCreative.setDisplayName(ChatColor.RESET + "" + ChatColor.YELLOW + "Creative");
        metaAdventure.setDisplayName(ChatColor.RESET + "" + ChatColor.RED + "Adventure");
        metaSpectator.setDisplayName(ChatColor.RESET + "" + ChatColor.GREEN + "Spectator");
        metaGUI.setDisplayName(ChatColor.RESET + "" + ChatColor.DARK_RED + "Exit");

        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        itemStack.setItemMeta(itemMeta);
        gamemodeSurvival.setItemMeta(metaSurvival);
        gamemodeCreative.setItemMeta(metaCreative);
        gamemodeAdventure.setItemMeta(metaAdventure);
        gamemodeSpectator.setItemMeta(metaSpectator);
        exitGUI.setItemMeta(metaGUI);

        gui.setItem(13, itemStack);
        gui.setItem(11, gamemodeSurvival);
        gui.setItem(12, gamemodeCreative);
        gui.setItem(14, gamemodeAdventure);
        gui.setItem(15, gamemodeSpectator);
        gui.setItem(26, exitGUI);
        player.openInventory(gui);
    }
}
