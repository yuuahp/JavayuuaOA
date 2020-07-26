package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmd_jyoa {
    public void onMessageReceived(MessageReceivedEvent event) {
        String prefix = "/jy";
        if (event.getMessage().getContentRaw().startsWith(prefix + "oa")) {
            Role role = event.getGuild().getRoleById(686103774691065871L);
            Role role2 = event.getGuild().getRoleById(720326371217244321L);
            String Name = event.getMember().getUser().getName();
            String member = event.getAuthor().getId();
            event.getGuild().addRoleToMember(member, role).queue();
            event.getGuild().addRoleToMember(member, role2).queue();
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("サーバールールを読んでいただきありがとうございました！\n**" + Name + "さん**、あなたに**閲覧権限**を付与しました！").queue();
        }
    }
}
