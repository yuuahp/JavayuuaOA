package systems.yuuahp.javayuua.Events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import systems.yuuahp.javayuua.Main;

public class PushPin extends Main {


    public String prefix = "/jy ";
    public String shortprefix = "/";


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().startsWith(prefix+"start")){
            event.getChannel().sendMessage("Javayuua is Ready");
        }
    }
}
