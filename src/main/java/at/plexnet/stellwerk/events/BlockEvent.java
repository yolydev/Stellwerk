package at.plexnet.stellwerk.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockEvent implements Listener {
    @EventHandler
    public void onBreakBock(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(event.getBlock().getType() == Material.IRON_ORE || event.getBlock().getType() == Material.DEEPSLATE_IRON_ORE) {
            player.sendMessage("break event");
            event.setDropItems(false);

            ItemStack droppedItem = new ItemStack(Material.IRON_INGOT);
            ItemMeta droppedItemMeta = droppedItem.getItemMeta();
            droppedItemMeta.setDisplayName(ChatColor.RESET + "Iron Ingot");
            droppedItem.setItemMeta(droppedItemMeta);

            player.getWorld().dropItem(event.getBlock().getLocation(), droppedItem);
        }
    }
}
