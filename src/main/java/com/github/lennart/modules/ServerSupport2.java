package com.github.lennart.modules;

import net.labymod.api.event.events.client.gui.screen.overlay.PlayerTabListOverlayEvent;
import net.labymod.ingamegui.moduletypes.ColoredTextModule;
import net.labymod.servermanager.ChatDisplayAction;
import net.labymod.servermanager.Server;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.PacketBuffer;

import java.util.Collections;
import java.util.List;

public class ServerSupport2 extends Server {

    private boolean displayServer;
    private boolean displayEnemy;
    private boolean displayKit;
    private boolean displayMap;

    public String enemy = null;
    public String latestServer = null;
    public String kit = null;
    public String latestMap = null;

    public ServerSupport2() {
        super("timolia", "timolia.de", "play.timolia.de", "*.timolia.de");
    }

    @Override
    public void onJoin(ServerData serverData) {

    }

    @Override
    public ChatDisplayAction handleChatMessage(String clean, String formatted) throws Exception {
        if (formatted.contains("1vs1") && formatted.contains("»")) {
            if (formatted.contains("Kit") && formatted.contains("Einstellungen")) {
                String kitname = formatted.split("§6")[1].split("§8")[0];
                kitname = kitname.substring(0, kitname.length() - 1);
                kit = kitname;
            }
            if (formatted.contains("Kampf") && formatted.contains("beginnt")) {
                String enemyname = formatted.split("§6")[1].split("§7")[0];
                enemyname = enemyname.substring(0, enemyname.length() - 2);
                enemy = enemyname;
            } else if (formatted.contains("den Kampf gegen")) {
                enemy = null;
                kit = null;
            }
        } return null;
    }

    @Override
    public void handlePayloadMessage(String s, PacketBuffer packetBuffer) throws Exception {

    }

    @Override
    public void handleTabInfoMessage(PlayerTabListOverlayEvent.Type type, String s, String s1) throws Exception {
        if (s.contains("Du spielst auf")) {
            String[] servername = s.split("§6");
            String serveroutput = servername[servername.length-1];
            serveroutput = serveroutput.substring(0,serveroutput.length()-4);
            latestServer = serveroutput;
        }
    }

    @Override
    public void fillSubSettings(List<SettingsElement> list) {
        list.add(new HeaderElement("Server Support Modules"));
        list.add(new BooleanElement("Display Server", this, new ControlElement.IconData(Material.ANVIL), "displayServer"));
        list.add(new BooleanElement("Display Enemy", this, new ControlElement.IconData(Material.NAME_TAG), "displayEnemy"));
        list.add(new BooleanElement("Display Kit", this, new ControlElement.IconData(Material.DIAMOND_SWORD), "displayKit"));
        list.add(new BooleanElement("Display Current Map", this, new ControlElement.IconData(Material.SIGN), "displayMap"));
    }

    @Override
    public void addModuleLines(List<DisplayLine> lines) {
        super.addModuleLines(lines);
        try {
            lines.add(new DisplayLine("Server", Collections.singletonList(ColoredTextModule.Text.getText(latestServer))));
            if (enemy != null)
                lines.add(new DisplayLine("Enemy", Collections.singletonList(ColoredTextModule.Text.getText(enemy))));
            if (kit != null)
                lines.add(new DisplayLine("Kit", Collections.singletonList(ColoredTextModule.Text.getText(kit))));
            if (latestMap != null)
                lines.add(new DisplayLine("Map", Collections.singletonList(ColoredTextModule.Text.getText(latestMap))));
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @Override
    public void loadConfig() {
        super.loadConfig();
        this.displayServer = getBooleanAttribute("displayServer", true);
        this.displayEnemy = getBooleanAttribute("displayEnemy", true);
        this.displayKit = getBooleanAttribute("displayKit", true);
        this.displayMap = getBooleanAttribute("displayMap", true);
    }
}
