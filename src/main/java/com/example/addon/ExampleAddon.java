package com.example.addon;

import java.util.List;

import com.example.addon.mixin.MessageEnemyReceiveEvent;
import com.example.addon.mixin.TablistHeaderListener;
import com.example.addon.modules.Enemy;
import com.example.addon.modules.Server;
import net.labymod.api.LabyModAddon;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.util.ResourceLocation;

public class ExampleAddon extends LabyModAddon {

  public ModuleCategory timolia;
  public static ExampleAddon INSTANCE;
  public String latestserver = null;

  @Override
  public void onEnable() {
    INSTANCE = this;

    //Register Module Category
    timolia = new ModuleCategory("Timolia", true, new ControlElement.IconData(new ResourceLocation("icons/timolia/timolia128.png")));
    System.out.println("Timolia-Addon enabled");
    ModuleCategoryRegistry.loadCategory(timolia);

    //Modules
    this.getApi().registerModule(new Enemy());
    this.getApi().registerModule(new Server());

    //Listener
    this.getApi().getEventService().registerListener(new TablistHeaderListener());
    this.getApi().getEventService().registerListener(new MessageEnemyReceiveEvent());

  }

  @Override
  public void loadConfig() {

  }

  @Override
  protected void fillSettings(List<SettingsElement> list) {

  }
}
