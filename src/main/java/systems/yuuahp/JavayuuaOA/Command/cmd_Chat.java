package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

public class cmd_Chat {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        String shortprefix = "/";
        String prefix = "/jy ";
        if (event.getMessage().getContentRaw().startsWith(shortprefix + "chat")) {
            String msg = event.getMessage().getContentRaw();
            //8
            String cutmsg = msg.substring(5);
            event.getMessage().delete().queue();
            event.getChannel().sendMessage(cutmsg).queue();

        }
    }

}
