package net.cottoncarrot.bunnytweaks;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Seed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            String seed = String.valueOf(((Player) commandSender).getWorld().getSeed());
            commandSender.sendMessage(Component.text()
                    .content("[").color(TextColor.color(0xfbfbfb))
                    .append(Component.text().content(seed)
                            .color(TextColor.color(0x00ff00))
                            .hoverEvent(HoverEvent.showText(Component.text("Click to copy to clipboard")))
                            .clickEvent(ClickEvent.copyToClipboard(seed)))
                    .append(Component.text().content("]").color(TextColor.color(0xfbfbfb)))

            );
        }
        return false;
    }
}
