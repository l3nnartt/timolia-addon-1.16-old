package com.github.lennart;

import java.util.List;
import com.github.lennart.modules.ServerSupport;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;

public class TimoliaAddon extends LabyModAddon {

  public static TimoliaAddon INSTANCE;
  public String latestserver = null;

  @Override
  public void onEnable() {
    INSTANCE = this;

    api.registerServerSupport(this, new ServerSupport());
  }

  @Override
  public void loadConfig() {
  }

  @Override
  protected void fillSettings(List<SettingsElement> list) {
  }
}
