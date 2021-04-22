package com.example.addon.mixin;

import com.example.addon.ExampleAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.gui.screen.overlay.PlayerTabListOverlayEvent;
import net.minecraft.util.text.ITextComponent;

public class TablistHeaderListener {

    @Subscribe
    public void onPlayerTabListOverlay( final PlayerTabListOverlayEvent event ) {
        final ITextComponent header = event.getHeader();
        final ITextComponent footer = event.getFooter();

        if(header.getString().contains("Du spielst auf")) {
            String[] servername = header.getString().split("§6");
            String serveroutput = servername[servername.length-1];
            serveroutput = serveroutput.substring(0,serveroutput.length()-4);
            ExampleAddon.INSTANCE.latestserver = serveroutput;

            System.out.println(serveroutput);
            System.out.println(ExampleAddon.INSTANCE.latestserver);

        }

    }

}
