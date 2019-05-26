package me.colejedwards.nametag;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public class NametagHandler {

    public void setNametag(Player player, Scoreboard scoreboard, PlayerNametag nametag) throws NametagException {
        if (doesPlayerHaveNametag(player)) {
            throw new NametagException("Player already has nametag");
        }

        String teamName = player.getName() + "nameTag";

        if (teamName.length() > 16) {
            teamName = teamName.substring(0, 16);
        }

        Team team;

        team = scoreboard.getTeam(teamName);

        if (team ==  null) {
            team = scoreboard.registerNewTeam(teamName);
        }

        if (nametag.getName() != null) team.setDisplayName(nametag.getName());
        if (nametag.getPrefix() != null) team.setPrefix(nametag.getPrefix());
        if (nametag.getSuffix() != null) team.setSuffix(nametag.getSuffix());

        team.addPlayer(player);

        player.setScoreboard(scoreboard);
    }

    public boolean doesPlayerHaveNametag(Player player) {
        String teamName = player.getName() + "nameTag";
        if (teamName.length() > 16) {
            return doesTeamExist(teamName.substring(0, 16));
        }
        return doesTeamExist(teamName);
    }

    public boolean doesTeamExist(String team) {
        for (UUID uuid : Nametag.getInstance().getScoreboard().keySet()) {
            for (Team team1 : Nametag.getInstance().getScoreboard().get(uuid).getTeams()) {
                if (team1.getName().equalsIgnoreCase(team)) {
                    return true;
                }
            }
        }
        return false;
    }
}
