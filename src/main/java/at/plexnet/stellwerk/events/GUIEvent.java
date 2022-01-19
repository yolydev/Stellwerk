package at.plexnet.stellwerk.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.inventory.ItemStack;

public class GUIEvent implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getView().getTitle().equals("TestGUI")) {
            ItemStack clickedItem = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();

            if(clickedItem == null) {
                player.sendMessage("Clicked1");
            } else if(clickedItem.getType() == Material.COOKIE) {
                player.sendMessage("coookie!");
            } else if(clickedItem.getType() == Material.BLUE_WOOL) {
                if(player.getGameMode() == GameMode.SURVIVAL) player.sendMessage("You're already in GameMode Survival.");
                else {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("GameMode changed to Survival!");
                }
            } else if(clickedItem.getType() == Material.YELLOW_WOOL) {
                if(player.getGameMode() == GameMode.CREATIVE) player.sendMessage("You're already in GameMode Creative.");
                else {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("GameMode changed to Creative!");
                }
            } else if(clickedItem.getType() == Material.RED_WOOL) {
                if(player.getGameMode() == GameMode.ADVENTURE) player.sendMessage("You're already in GameMode Adventure.");
                else {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("GameMode changed to Adventure!");
                }
            } else if(clickedItem.getType() == Material.GREEN_WOOL) {
                if(player.getGameMode() == GameMode.SPECTATOR) player.sendMessage("You're already in GameMode Spectator.");
                else {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("GameMode changed to Spectator");
                }
            } else if(clickedItem.getType() == Material.BARRIER) {
                player.closeInventory();
            }
            event.setCancelled(true);
        }
    }
}
