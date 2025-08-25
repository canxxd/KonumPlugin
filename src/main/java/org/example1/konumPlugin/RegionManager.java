package org.example1.konumPlugin;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;




public class RegionManager {
    private static List<Region> regions = new ArrayList<>();

    public static void loadRegionsFromConfig(FileConfiguration config) {
        regions.clear();
        ConfigurationSection regionsSection = config.getConfigurationSection("regions");
        if (regionsSection == null) {
            KonumPlugin.getInstance().getLogger().warning("configde 'regions' bölümün bulunamadı");
            return;
        }

        for (String regionName : regionsSection.getKeys(false)) {
            ConfigurationSection regionData = regionsSection.getConfigurationSection(regionName);
            if (regionData == null) continue;

            String worldName = regionData.getString("world");
            if (worldName == null) {
                KonumPlugin.getInstance().getLogger().warning("bölgen '" + regionName + "' için dünya belirtilmemiş");
                continue;
            }


            World world = Bukkit.getWorld(worldName);
            if (world == null) {
                KonumPlugin.getInstance().getLogger().warning("bölgen '" + regionName + "' için dünya '" + worldName + "' bulunmadı");
                continue;
            }

            double pos1_x = regionData.getDouble("pos1.x");
            double pos1_y = regionData.getDouble("pos1.y");
            double pos1_z = regionData.getDouble("pos1.z");
            Location pos1 = new Location(world, pos1_x, pos1_y, pos1_z);

            double pos2_x = regionData.getDouble("pos2.x");
            double pos2_y = regionData.getDouble("pos2.y");
            double pos2_z = regionData.getDouble("pos2.z");
            Location pos2 = new Location(world, pos2_x, pos2_y, pos2_z);

            regions.add(new Region(regionName, world, pos1, pos2));
            KonumPlugin.getInstance().getLogger().info("bölgeler başarıyla yüklendi " + regionName);
        }
    }

    public static String getRegionNameAtLocation(Location location) {
        for (Region region : regions) {
            if (region.contains(location)) {
                return region.getName();
            }
        }
        return null;
    }
}
