package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import java.awt.*;

public class jyLookUP {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        String shortprefix = "/";
        if (event.getMessage().getContentRaw().startsWith(shortprefix + "jylookup")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle(":satellite_orbital: **JavayuuaStates**", null);
            eb.setColor(new Color(155, 255, 148));

            eb.setDescription("States:**NowOnline!**");
            event.getChannel().sendMessage(eb.build()).queue();

            //event.getChannel().sendMessage("私はOnlineですよ～").queue();
        }
    }

}
