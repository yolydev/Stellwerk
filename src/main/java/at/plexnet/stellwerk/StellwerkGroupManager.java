package at.plexnet.stellwerk;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class StellwerkGroupManager {
    private final Plugin plugin;
    private final List<Player> user;
    private final List<Player> admin;

    public StellwerkGroupManager(Plugin plugin) {
        this.plugin = plugin;
        this.user = new ArrayList<>();
        this.admin = new ArrayList<>();
    }

    public List<Player> getUser() {
        return user;
    }

    public List<Player> getAdmin() {
        return admin;
    }

    public boolean isUser(Player player) {
        return user.contains(player);
    }

    public boolean isAdmin(Player player) {
        return admin.contains(player);
    }

    public void setUser(Player player, boolean bool) {
        if(bool) {
            user.add(player);
        } else {
            user.remove(player);
        }
    }

    public void setAdmin(Player player, boolean bool) {
        if(bool) {
            admin.add(player);
        } else {
            admin.remove(player);
        }
    }
}
