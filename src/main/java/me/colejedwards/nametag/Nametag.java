package me.colejedwards.nametag;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.UUID;

@Getter
public class Nametag {

    @Getter private static Nametag instance;

    private Plugin plugin;
    private HashMap<UUID, Scoreboard> scoreboard = new HashMap<UUID, Scoreboard>();

    private NametagHandler nametagHandler;

    public Nametag(Plugin plugin) {
        instance = this;

        this.plugin = plugin;
        this.nametagHandler = new NametagHandler();

        Bukkit.getServer().getPluginManager().registerEvents(new NametagListener(), plugin);
    }

}
