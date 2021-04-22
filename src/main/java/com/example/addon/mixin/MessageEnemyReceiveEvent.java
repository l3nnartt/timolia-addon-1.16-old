package com.example.addon.mixin;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageReceiveEvent;
import net.minecraft.util.text.ITextComponent;


public class MessageEnemyReceiveEvent {

    public static String enemy = null;
    public static String kit = null;

    @Subscribe
    public void onMessageReceiveEvent(MessageReceiveEvent event) {

        final ITextComponent msg = event.getComponent();

        if (msg.getString().contains("1vs1") && msg.getString().contains("»")) {

            if (msg.getString().contains("Kit") && msg.getString().contains("Einstellungen")) {
                String kitname = msg.getString().split("§6")[1].split("§8")[0];
                kitname = kitname.substring(0, kitname.length()-1);
                kit = kitname;
            }

            if (msg.getString().contains("Kampf") && msg.getString().contains("beginnt")) {
                String enemyname = msg.getString().split("§6")[1].split("§7")[0];
                enemyname = enemyname.substring(0, enemyname.length()-2);
                enemy = enemyname;
            }

            else if (msg.getString().contains("den Kampf gegen")) {
                enemy = null;
                kit = null;
            }

            System.out.println(kit);
            System.out.println(enemy);

        }

    }
}
