package gg.solarmc.solarping.Commands;

import gg.solarmc.solarping.SolarPing;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PingCommand implements CommandExecutor {
    private final SolarPing plugin;


    public PingCommand(SolarPing plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command,String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            String selfPing = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("pingmessage").replace("%ping%", getPlayerPing(player)));
            if (args.length > 0) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    String otherPlayerPing = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("pingotherplayermessage").replace("%otherplayerping%", getPlayerPing(target))).replace("%playername%", target.getDisplayName());
                    player.sendMessage(otherPlayerPing);
                }else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("PlayerNotFoundMessage")));

                }
                } else {
                    player.sendMessage(selfPing);

            }

        }

        return true;
    }
    private String getPlayerPing(Player player) {
        return String.valueOf(player.spigot().getPing());
    }

}
