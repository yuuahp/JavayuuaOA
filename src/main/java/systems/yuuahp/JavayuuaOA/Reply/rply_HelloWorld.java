package systems.yuuahp.JavayuuaOA.Reply;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

public class rply_HelloWorld {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith("hello")) {
            event.getChannel().sendMessage("HelloWorld!").queue();
        }


    }
}
