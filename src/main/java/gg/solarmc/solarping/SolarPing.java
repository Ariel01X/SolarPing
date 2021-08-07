package gg.solarmc.solarping;

import gg.solarmc.solarping.Commands.PingCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SolarPing extends JavaPlugin {

    @Override
    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.addDefault("PlayerNotFoundMessage" , "&CPlayer not found");
        config.addDefault("pingmessage" , "&7Your ping: &6%ping%");
        config.addDefault("pingotherplayermessage" , "&7%playername%''s ping: &6%otherplayerping%");
        config.options().copyDefaults(true);
        saveConfig();

        getCommand("ping").setExecutor(new PingCommand(this));



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
