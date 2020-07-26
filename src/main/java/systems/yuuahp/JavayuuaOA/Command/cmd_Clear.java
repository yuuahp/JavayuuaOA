package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import java.awt.*;
import java.util.List;

public class cmd_Clear {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        String shortprefix = "/";
        String s = event.getMessage().getContentRaw();
        if (s.startsWith(shortprefix + "clear")) {
            String[] ss = event.getMessage().getContentRaw().split(" ");
            int i = Integer.parseInt(ss[1]);
            int is = i + 1;
            if (is <= 10 && is > 0) {
                List<Message> messages = event.getTextChannel().getHistory().retrievePast(is).complete();
                for (Message m : messages) {
                    m.delete().queue();
                }
                String name = event.getMember().getUser().getName();


                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(":pencil: メッセージを削除しました。", null);
                eb.setColor(new Color(246, 162, 255));
                eb.setDescription("**" + name + "さん** - " + is + "メッセージ");
                event.getChannel().sendMessage(eb.build()).queue();

                //event.getChannel().sendMessage("-----------------\n:pencil: "+i+"メッセージを**削除**しました。("+name+")\n-----------------").queue();
            } else {
                event.getTextChannel().sendMessage(":ledger: 消去数は10までです！申し訳ありません。").queue();
            }
        }
    }

}
