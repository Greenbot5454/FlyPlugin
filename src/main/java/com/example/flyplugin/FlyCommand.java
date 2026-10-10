package com.example.flyplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        if (args.length > 0) {
            if (!player.hasPermission("flyplugin.fly.others")) {
                player.sendMessage(ChatColor.RED + "You don't have permission!");
                return true;
            }
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                player.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }
            toggleFly(target);
            player.sendMessage(ChatColor.GREEN + "Toggled fly for " + target.getName());
            return true;
        }

        toggleFly(player);
        return true;
    }

    private void toggleFly(Player player) {
        boolean newState = !player.getAllowFlight();
        player.setAllowFlight(newState);
        player.setFlying(newState);
        player.sendMessage(ChatColor.GREEN + "Fly " + (newState ? "enabled" : "disabled"));
    }
}
