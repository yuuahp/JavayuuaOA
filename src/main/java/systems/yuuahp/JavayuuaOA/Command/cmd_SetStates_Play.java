package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

public class cmd_SetStates_Play {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        String shortprefix = "/";
        String prefix = "/jy ";

        if (event.getMessage().getContentRaw().startsWith(shortprefix + "state")) {

            event.getChannel().sendMessage("states set!");
            JDABuilder jdaBuilder = new JDABuilder();
            jdaBuilder.setActivity(Activity.watching("test"));
        }
    }

}
