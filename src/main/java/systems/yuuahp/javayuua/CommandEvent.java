package systems.yuuahp.javayuua;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

public interface CommandEvent {

    public void onCommand(final JDA jda, final Guild guild, final MessageChannel channel, final Member member,
                          final Message message, final String[] args);

}



