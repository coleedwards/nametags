package me.colejedwards.nametag;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;

public class NametagListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        if (Nametag.getInstance().getNametagHandler().doesPlayerHaveNametag(player)) {
            Scoreboard scoreboard = Nametag.getInstance().getScoreboard().get(player.getUniqueId());

            String teamName = player.getName() + "nameTag";

            if (teamName.length() > 16) {
                teamName = teamName.substring(0, 16);
            }

            scoreboard.getTeam(teamName).unregister();

            Nametag.getInstance().getScoreboard().remove(player.getUniqueId());
        }
    }
}
