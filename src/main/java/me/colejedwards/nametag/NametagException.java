package me.colejedwards.nametag;

public class NametagException extends Exception {

    private String reason;

    public NametagException(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "NametagException - " + reason;
    }
}
