package org.example1.konumPlugin;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class KonumKomutlar implements CommandExecutor, TabCompleter {


    private final KonumPlugin plugin;

    public KonumKomutlar(KonumPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("konumplugin.admin")) {
            sender.sendMessage(String.valueOf(ChatColor.GRAY) + "yetkiniz yok");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(String.valueOf(ChatColor.WHITE) + "Bu Komutun Doğru Kullanımı /konumadmin reload");
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            this.plugin.reloadConfig();
            RegionManager.loadRegionsFromConfig(this.plugin.getConfig());
            sender.sendMessage(String.valueOf(ChatColor.GREEN) + "reload başarılı");
            return true;
        }
        sender.sendMessage(String.valueOf(ChatColor.RED) + "geçersiz komut şekli " + String.valueOf(ChatColor.RED));
        sender.sendMessage(String.valueOf(ChatColor.WHITE) + "doğru kullanım şekili /konumadmin reload");
        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1 && sender.hasPermission("konumplugin.admin")) {
            completions.add("reload");
        }
        return completions;
    }
}
