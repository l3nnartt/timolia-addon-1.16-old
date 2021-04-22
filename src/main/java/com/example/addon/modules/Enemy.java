package com.example.addon.modules;

import com.example.addon.ExampleAddon;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.minecraft.util.ResourceLocation;

public class Enemy extends SimpleModule {

    @Override
    public ModuleCategory getCategory() {
        return ExampleAddon.INSTANCE.timolia;
    }

    @Override
    public String getDisplayName() {
        return "Gegner";
    }

    @Override
    public String getDisplayValue() {
        return null;
    }

    @Override
    public String getDefaultValue() {
        return "???";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(new ResourceLocation("icons/timolia/enemy128.png"));
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public String getSettingName() {
        return "Gegner(1vs1)";
    }

    @Override
    public String getControlName() {
        return getSettingName();
    }

    @Override
    public String getDescription() {
        return "Zeigt dir den Namen deines Gegners an";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
}