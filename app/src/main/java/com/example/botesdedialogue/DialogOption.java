package com.example.botesdedialogue;


public class DialogOption {
    private final String name;
    private final int icon;

    public DialogOption(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
