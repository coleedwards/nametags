# Nametags
Useful NametagAPI that can be implemented into Bukkit and Spigot plugins. 48 character support & works with all versions.

* Uses Bukkit Team System
* Easy to Use
* Free + Open Source

# Todo
* Cleanup
* Add automatic string splitting (String -> 16 chars in prefix, 16 chars in display name, 16 chars in suffix)

# Example:
```java
    private Nametag nametag;

    @Override
    public void onEnable() {
        nametag = new Nametag(this);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        try {
            nametag.getNametagHandler().setNametag(e.getPlayer(), Bukkit.getScoreboardManager().getMainScoreboard(), new PlayerNametag("verycoolman", e.getPlayer().getName(), null));
        } catch (NametagException e1) {
            e1.printStackTrace();
        }
    }
    
```

# Terms
1. No claiming as your own
2. You may include this in premium plugins, with credit

# Contact
Discord - Cole#3895
Twitter - @ThatDevCole
Telegram - @ThatDevCole

&copy; **Runic Holdings LLC. 2019**

