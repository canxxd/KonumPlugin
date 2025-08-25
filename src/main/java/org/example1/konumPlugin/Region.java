package org.example1.konumPlugin;

import org.bukkit.Location;
import org.bukkit.World;


public class Region {
    private String name;

    private World world;

    private Location pos1;

    private Location pos2;


    public Region(String name, World world, Location pos1, Location pos2) {
        this.name = name;
        this.world = world;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public String getName() {
        return this.name;
    }

    public World getWorld() {
        return this.world;
    }

    public Location getPos1() {
        return this.pos1;
    }

    public Location getPos2() {
        return this.pos2;
    }

    public boolean contains(Location loc) {
        if (!loc.getWorld().equals(this.world))
            return false;
        double minX = Math.min(this.pos1.getX(), this.pos2.getX());
        double minY = Math.min(this.pos1.getY(), this.pos2.getY());
        double minZ = Math.min(this.pos1.getZ(), this.pos2.getZ());
        double maxX = Math.max(this.pos1.getX(), this.pos2.getX());
        double maxY = Math.max(this.pos1.getY(), this.pos2.getY());
        double maxZ = Math.max(this.pos1.getZ(), this.pos2.getZ());
        return (loc.getX() >= minX && loc.getX() <= maxX && loc
                .getY() >= minY && loc.getY() <= maxY && loc
                .getZ() >= minZ && loc.getZ() <= maxZ);
    }
}
