package me.colejedwards.nametag;

import lombok.Data;

@Data
public class PlayerNametag {

    private String name;
    private String prefix;
    private String suffix;

    public PlayerNametag(String prefix, String name, String suffix) throws NametagException {
        if (name != null && name.length() > 16) {
            throw new NametagException("Name cannot be larger then 16 characters");
        }

        if (prefix != null && prefix.length() > 16) {
            throw new NametagException("Prefix cannot be larger then 16 characters");
        }

        if (suffix != null && suffix.length() > 16) {
            throw new NametagException("Suffix cannot be larger then 16 characters");
        }

        this.prefix = prefix;
        this.name = name;
        this.suffix = suffix;
    }

}
