package net.cottoncarrot.bunnytweaks;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String name = e.getPlayer().getName();
        giveRecipes(name);
    }

    private void giveRecipes(String user) {
        BunnyTweaks.logger.info("[BunnyTweaks] Giving "+ user + " all recipes");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "recipe give " + user + " *");
    }
}
