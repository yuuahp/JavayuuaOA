package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import java.awt.*;

public class cmd_restart {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        String prefix = "/jy ";
        if (event.getMessage().getContentRaw().startsWith(prefix + "restart")) {
            event.getChannel().sendMessage(":octagonal_sign: **Javayuua Stoped** :octagonal_sign:").queue();


            Message editmsg = event.getChannel().sendMessage("**3**").complete();

            editmsg.editMessage("**3**").queue();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**2**").queue();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**1**").queue();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**RESTARTING....**").queue();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**#-----**").queue();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**-#----**").queue();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**--#---**").queue();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**---#--**").queue();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**----#-**").queue();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**-----#**").queue();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editmsg.editMessage("**SUCCESS**").queue();






            //Javayuuaをリスタートする的なコード調べる


            event.getChannel().sendMessage(":white_check_mark: **Javayuua is Ready!** :white_check_mark:").queue();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle(":pencil: SUCCESSFULLY COMPLETED", null);
            eb.setColor(new Color(246, 162, 255));
            eb.setDescription("RESULT:All programs has been restarted");
            event.getChannel().sendMessage(eb.build()).queue();

        }
    }

}
