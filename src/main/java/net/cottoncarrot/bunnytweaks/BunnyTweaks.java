package net.cottoncarrot.bunnytweaks;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BunnyTweaks extends JavaPlugin {
    static Logger logger = Bukkit.getLogger();
    @Override
    public void onEnable() {
        saveDefaultConfig();

        FileConfiguration config = getConfig();
        RecipeAdder.addRecipes(config);
        if (config.getBoolean("GiveRecipes")) {
            getServer().getPluginManager().registerEvents(new JoinListener(), this);
        }
        if (config.getBoolean("DisableInsomnia")) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule doInsomnia false");
        }

        logger.info("[BunnyTweaks] Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
