package org.example1.konumPlugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class KonumPlugin extends JavaPlugin {
    private static KonumPlugin instance;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getLogger().info(String.valueOf(ChatColor.GREEN) + "Eklentimiz Sunucuyla Bağlantı Kurdu Ve Sorunsuz Çalışıyor Bağlantı STABİL");
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            (new KonumPlaceholder(this)).register();
            getLogger().info(String.valueOf(ChatColor.GREEN) + "placeholderapi entegrasyonu başarılıyla bağlantı kurdu eklenti aktif");
        } else {
            getLogger().warning(String.valueOf(ChatColor.YELLOW) + "placeholderapi yok placeholder çalışmayacaktır devre dışı bırakılıyor");
            getServer().getPluginManager().disablePlugin((Plugin) this);
        }

        RegionManager.loadRegionsFromConfig(getConfig());
        getCommand("konumadmin").setExecutor(new KonumKomutlar(this));
        getCommand("konumadmin").setTabCompleter(new KonumKomutlar(this));
    }

    public void onDisable() {
        getLogger().info(String.valueOf(ChatColor.RED) + "eklenti devre dışı");
    }

    public static KonumPlugin getInstance() {
        return instance;
    }
}
