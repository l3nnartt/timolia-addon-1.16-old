package com.github.lennart;

import java.util.List;
import com.github.lennart.modules.ServerSupport2;
import net.labymod.api.LabyModAddon;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.settings.elements.SettingsElement;

public class TimoliaAddon extends LabyModAddon {

  public ModuleCategory timolia;
  public static TimoliaAddon INSTANCE;
  public String latestserver = null;

  @Override
  public void onEnable() {
    INSTANCE = this;

    //Register Module Category
    //timolia = new ModuleCategory("Timolia", true, new ControlElement.IconData(new ResourceLocation("icons/timolia/timolia128.png")));
    //System.out.println("Timolia-Addon enabled");
    //ModuleCategoryRegistry.loadCategory(timolia);

    //Modules
    api.registerServerSupport(this, new ServerSupport2());

  }

  @Override
  public void loadConfig() {
  }

  @Override
  protected void fillSettings(List<SettingsElement> list) {
  }
}
