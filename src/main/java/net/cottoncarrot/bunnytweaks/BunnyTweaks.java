package net.cottoncarrot.bunnytweaks;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BunnyTweaks extends JavaPlugin {
    static Logger logger = Bukkit.getLogger();
    @Override
    public void onEnable() {
        logger.info("[BunnyTweaks] Enabled");
        saveDefaultConfig();

        FileConfiguration config = getConfig();
        RecipeAdder.addRecipes(config);
        if (config.getBoolean("GiveRecipes")) {
            getServer().getPluginManager().registerEvents(new JoinListener(), this);
        }
        if (config.getBoolean("Seed")) {
            this.getCommand("seed").setExecutor(new Seed());
        }
        if (config.getBoolean("NoPhantoms")) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "gamerule doInsomnia false");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
