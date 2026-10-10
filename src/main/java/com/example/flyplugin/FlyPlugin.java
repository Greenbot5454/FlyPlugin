package com.example.flyplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class FlyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("FlyPlugin enabled!");
        if (getCommand("fly") != null) {
            getCommand("fly").setExecutor(new FlyCommand());
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("FlyPlugin disabled!");
    }
}
