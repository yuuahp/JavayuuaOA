package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import javax.security.auth.login.LoginException;

public class cmd_SetStates_Play {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event)throws LoginException {
        String shortprefix = "/";
        String prefix = "/jy ";

        if (event.getMessage().getContentRaw().startsWith(shortprefix + "state")) {

            event.getChannel().sendMessage("states set!").queue();
            JDABuilder jdaBuilder = new JDABuilder();
            jdaBuilder.setActivity(Activity.watching("test"));
            jdaBuilder.build();
        }
    }

}
