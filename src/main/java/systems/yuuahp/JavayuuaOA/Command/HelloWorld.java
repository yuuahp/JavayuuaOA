package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

public class HelloWorld {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith("hello")) {
            event.getChannel().sendMessage("HelloWorld!").queue();
        }


    }
}
