package systems.yuuahp.Events;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import systems.yuuahp.Main;

import javax.security.auth.login.LoginException;

public class PushPin extends ListenerAdapter {


    public String prefix = "/jy ";
    public String shortprefix = "/";
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().startsWith(prefix+"start")){
            event.getChannel().sendMessage("Javayuua is Ready");
        }
    }
}
