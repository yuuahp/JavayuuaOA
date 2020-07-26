package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import java.awt.*;


public class cmd_Timer {
@SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        String shortprefix = "/";
        if (event.getMessage().getContentRaw().startsWith(shortprefix + "timer")) {
            String msg = event.getMessage().getContentRaw();
            String cutmsg = msg.substring(7);
            int i = Integer.parseInt(cutmsg);
            int i2 = i*1000;

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle(":stopwatch: Timer Started! ("+i+"s)", null);
            eb.setColor(new Color(246, 162, 255));
            event.getChannel().sendMessage(eb.build()).queue();


            try {
                Thread.sleep(i2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            EmbedBuilder eb2 = new EmbedBuilder();
            eb2.setTitle(":stopwatch: TIME OVER! ("+i+"s)", null);
            eb2.setColor(new Color(246, 162, 255));
            event.getChannel().sendMessage(eb2.build()).queue();
        }
    }
}
