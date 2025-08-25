package org.example1.konumPlugin;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;


public class KonumPlaceholder extends PlaceholderExpansion {
    private final KonumPlugin plugin;

    public KonumPlaceholder(KonumPlugin plugin) {
        this.plugin = plugin;
    }


    public String getIdentifier() {
        return "konum";
    }

    public String getAuthor() {
        return this.plugin.getDescription().getAuthors().toString();
    }

    public String getVersion() {
        return this.plugin.getDescription().getVersion();
    }

    public boolean persist() {
        return true;
    }




    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null)
            return "";
        if (identifier.equals("current_location")) {
            String regionName = RegionManager.getRegionNameAtLocation(player.getLocation());
            return (regionName != null) ? regionName : "Belirsiz";
        }
        return null;
    }
}
