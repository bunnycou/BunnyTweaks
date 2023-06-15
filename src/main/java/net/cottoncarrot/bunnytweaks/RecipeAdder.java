package net.cottoncarrot.bunnytweaks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;

public class RecipeAdder extends JavaPlugin {
    static ShapelessRecipe Leather2Hide = new ShapelessRecipe(
            new NamespacedKey("bunnytweaks", "rabbit_hide"),
            new ItemStack(Material.RABBIT_HIDE,4))
            .addIngredient(Material.LEATHER);
    static ShapedRecipe HoneyPiston = new ShapedRecipe(
            new NamespacedKey("bunnytweaks", "honeypiston"),
            new ItemStack(Material.STICKY_PISTON, 1))
            .shape("H","P")
            .setIngredient('H', Material.HONEY_BOTTLE)
            .setIngredient('P', Material.PISTON);
    static ShapedRecipe HoneyLead = new ShapedRecipe(
            new NamespacedKey("bunnytweaks", "honeylead"),
            new ItemStack(Material.LEAD, 1))
            .shape("SS ","SH ", "  S")
            .setIngredient('H', Material.HONEY_BOTTLE)
            .setIngredient('S', Material.STRING);
    static ShapedRecipe Saddle = new ShapedRecipe(
            new NamespacedKey("bunnytweaks", "saddle"),
            new ItemStack(Material.SADDLE, 1))
            .shape("LLL", "L L", "I I")
            .setIngredient('L', Material.LEATHER)
            .setIngredient('I', Material.IRON_INGOT);

    static ShapedRecipe Bundle = new ShapedRecipe(
            new NamespacedKey("bunnytweaks", "bundle"),
            new ItemStack(Material.BUNDLE, 1))
            .shape("SHS" ,"H H", "HHH")
            .setIngredient('S', Material.STRING)
            .setIngredient('H', Material.RABBIT_HIDE);
//    static RecipeChoice shovels = new RecipeChoice.MaterialChoice(
//            Material.WOODEN_SHOVEL,
//            Material.STONE_SHOVEL,
//            Material.IRON_SHOVEL,
//            Material.GOLDEN_SHOVEL,
//            Material.DIAMOND_SHOVEL,
//            Material.NETHERITE_SHOVEL);
    static ShapelessRecipe Gravel2Flint = new ShapelessRecipe(
            new NamespacedKey("bunnytweaks", "gravel_flint"),
            new ItemStack(Material.FLINT, 1))
            .addIngredient(Material.GRAVEL)
            .addIngredient(Material.GRAVEL)
            .addIngredient(Material.GRAVEL)
            .addIngredient(Material.GRAVEL);
    static RecipeChoice wools = new RecipeChoice.MaterialChoice(
            Material.BLACK_WOOL,
            Material.BLUE_WOOL,
            Material.CYAN_WOOL,
            Material.BROWN_WOOL,
            Material.GRAY_WOOL, // 5
            Material.GREEN_WOOL,
            Material.LIGHT_BLUE_WOOL,
            Material.LIGHT_GRAY_WOOL,
            Material.YELLOW_WOOL,
            Material.LIME_WOOL, // 10
            Material.MAGENTA_WOOL,
            Material.ORANGE_WOOL,
            Material.RED_WOOL,
            Material.PINK_WOOL,
            Material.PURPLE_WOOL); // 15
    static ShapelessRecipe Wool2White = new ShapelessRecipe(
            new NamespacedKey("bunnytweaks", "wool_white"),
            new ItemStack(Material.WHITE_WOOL, 1))
            .addIngredient(Material.WHITE_DYE)
            .addIngredient(wools);
    static FurnaceRecipe Flesh2Leather = new FurnaceRecipe(
            new NamespacedKey("bunnytweaks", "flesh_leather"),
            new ItemStack(Material.LEATHER, 1),
            Material.ROTTEN_FLESH, 0f, 200);
    public static void addRecipes(FileConfiguration config) {
        Server server = Bukkit.getServer();

        if (config.getBoolean("Leather2Hide")) {
            server.addRecipe(Leather2Hide);
        }

        if (config.getBoolean("HoneySlime")) {
            server.addRecipe(HoneyPiston);
            server.addRecipe(HoneyLead);
        }

        if (config.getBoolean("Saddle")) {
            server.addRecipe(Saddle);
        }

        if (config.getBoolean("Bundle")) {
            server.addRecipe(Bundle);
        }

        if (config.getBoolean("Flesh2Leather")) {
            server.addRecipe(Flesh2Leather);
        }

        if (config.getBoolean("Wool2White")) {
            server.addRecipe(Wool2White);
        }

        if (config.getBoolean("Gravel2Flint")) {
            server.addRecipe(Gravel2Flint);
        }
    }
}
