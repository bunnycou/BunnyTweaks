package net.cottoncarrot.bunnytweaks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;
public class RecipeAdder extends JavaPlugin {
    static ShapelessRecipe Leather2Hide = new ShapelessRecipe(
            new NamespacedKey("bunnytweaks", "rabbit_hide"),
            new ItemStack(Material.RABBIT_HIDE,4))
            .addIngredient(Material.LEATHER);

    static ShapedRecipe Saddle = new ShapedRecipe(
            new NamespacedKey("bunnytweaks", "saddle"),
            new ItemStack(Material.SADDLE, 1))
            .shape("LLL", "L L", "I I")
            .setIngredient('L', Material.LEATHER)
            .setIngredient('I', Material.IRON_INGOT);

    public static void addRecipes(FileConfiguration config) {
        if (config.getBoolean("Leather2Hide")) {
            Bukkit.getServer().addRecipe(Leather2Hide);
        }

        if (config.getBoolean("Saddle")) {
            Bukkit.getServer().addRecipe(Saddle);
        }
    }
}
