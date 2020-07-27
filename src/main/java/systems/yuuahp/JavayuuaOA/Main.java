package systems.yuuahp.JavayuuaOA;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import systems.yuuahp.JavayuuaOA.Command.*;
import systems.yuuahp.JavayuuaOA.Reply.rply_HelloWorld;
import systems.yuuahp.JavayuuaOA.Reply.rply_calljavayuua;


import javax.security.auth.login.LoginException;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Main extends ListenerAdapter {

    public static final String COMMAND_PREFIX = "/";


    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token;
        builder.setEventManager(new AnnotatedEventManager());

        builder.addEventListeners(new rply_calljavayuua());
        builder.addEventListeners(new rply_HelloWorld());

        builder.addEventListeners(new Main());
        builder.addEventListeners(new cmd_Timer());
        builder.addEventListeners(new cmd_jyLookUP());
        builder.addEventListeners(new cmd_Clear());
        builder.addEventListeners(new cmd_Time());
        builder.addEventListeners(new cmd_restart());
        builder.addEventListeners(new cmd_Chat());
        builder.addEventListeners(new cmd_jyoa());
        builder.addEventListeners(new cmd_SetStates_Play());



        token = System.getenv("token");
        builder.setToken(token);
        builder.build();
    }

    public String prefix = "/jy ";
    public String shortprefix = "/";
    public StringBuffer jyidq = new StringBuffer();
    public StringBuffer jyidch = new StringBuffer();
@SubscribeEvent
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String user = event.getMember().getUser().getName();
        event.getJDA().getTextChannelById(686102510330445923L).sendMessage(":tada:**" + user + "さん！**ようこそ**OAstudio**へ！\n下のチャンネルでサーバールールをよく読み、**閲覧権限**を入手しましょう！\n閲覧権限をもらったら **自己紹介**を書いてみましょう！").queue();
    }
@SubscribeEvent
    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        String user = event.getMember().getUser().getName();
        event.getJDA().getTextChannelById(686102510330445923L).sendMessage(":cold_sweat: **" + user + "さん**、また来てね....").queue();
    }



    @SubscribeEvent
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getReactionEmote().getName().equals("\uD83D\uDCCC")){
            event.getChannel().sendMessage("リアクション検知！").queue();

            String msg = event.getTextChannel().getHistory().getMessageById(event.getMessageId()).getContentRaw();
            event.getChannel().sendMessage(msg).queue();
        }
    }
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = new String[0];
        System.out.println("Received->" +
                event.getAuthor().getName() + ":" +
                event.getMessage().getContentDisplay()
        );





        /*if (event.getMessage().getContentRaw().equals("/jy oa") && event.getMessage().getContentRaw().startsWith("サーバールールを")) {


            if (event.getMember().getRoles().contains(686106681335218397L)) {

            }
            if (event.getMember().getRoles().contains(712695118070808687L)) {

            } else {
                if (event.getMessage().getChannel().equals("<#702161494141304832>")) {
                    event.getMessage().delete().queue();
                }
            }
*/






            if (event.getMessage().getContentRaw().startsWith(prefix + "emojisubmit")) {
                String emjsubmsg = event.getMessage().getContentRaw();
                String Name = event.getMember().getUser().getName();
                event.getChannel().sendMessage("申請を送信しました。\n`jyid:お好きなID`を送信してください。\n申請はこのIDをもとに管理されます。\n**・分かりやすいIDの生成にご協力ください。**\n**・原則半角英数字のみとさせて頂きます。**").queue();
                event.getJDA().getTextChannelById("686474057771778069").sendMessage(":pencil:**" + Name + "さん**から新たな**絵文字リクエスト**がありました！\n>" + emjsubmsg).queue();
            }//スタッフ会議


            if (event.getMessage().getContentRaw().startsWith(prefix + "req")) {
                String submsg = event.getMessage().getContentRaw();
                String Name = event.getMember().getUser().getName();
                event.getChannel().sendMessage("申請を送信しました。\n`jyid:お好きなID`を送信してください。\n申請はこのIDをもとに管理されます。\n**・分かりやすいIDの生成にご協力ください。**\n**・原則半角英数字のみとさせて頂きます。**").queue();
                event.getJDA().getTextChannelById("686474057771778069").sendMessage(":pencil:**" + Name + "さん**から新たな**申請**がありました！\n`>" + submsg + "`").queue();
            }//スタッフ会議


            if (event.getMessage().getContentRaw().startsWith("jyid:")) {

                String jyid = event.getMessage().getContentRaw();
                jyidq.replace(0, 100, jyid);
                String Name = event.getMember().getUser().getName();
                String ch = event.getChannel().getName();
                jyidch.replace(0, 100, ch);
                event.getChannel().sendMessage("申請ID->`" + jyid + "`を生成しました。\nスタッフ内で審議しますのでしばらくお待ちください。").queue();
                event.getJDA().getTextChannelById("686474057771778069").sendMessage(":pencil:**" + Name + "さん**が新たなJYIDを申請しました！\n`>" + jyidq + "`\n運営は審議完了後に`/jy aprv " + jyid + "`か`/jy noaprv " + jyid + "`を実行してください。").queue();
                //スタッフ会議
            }

            if (event.getMessage().getContentRaw().startsWith(prefix + "aprv")) {
                String aprvmsg = event.getMessage().getContentRaw();
                //8
                String cutmsg = aprvmsg.substring(9);
                event.getChannel().sendMessage(":pencil:" + cutmsg + "の**承認処理**に成功しました！").queue();
                event.getJDA().getTextChannelById("686473875143393288").sendMessage("JYID`" + cutmsg + "`が**承認**されました。").queue();
                //質問相談
            }
            if (event.getMessage().getContentRaw().startsWith(prefix + "noaprv")) {
                String noaprvmsg = event.getMessage().getContentRaw();
                //8
                String cutmsg = noaprvmsg.substring(10);
                event.getChannel().sendMessage(":pencil:" + cutmsg + "の**否認処理**に成功しました！").queue();
                event.getJDA().getTextChannelById("686473875143393288").sendMessage("JYID`" + cutmsg + "`が**否認**されました。").queue();
                //質問相談
            }




            if (event.getMessage().getContentRaw().startsWith(prefix + "devreq")) {
                String reqmsg = event.getMessage().getContentRaw();
                String Name = event.getMember().getUser().getName();
                event.getChannel().sendMessage("**ありがとうございます！**リクエストを送信しました!").queue();
                event.getJDA().getTextChannelById("712698533941215293").sendMessage(":pencil:**" + Name + "さん**から新たな**開発リクエスト**がありました！\n`>" + reqmsg + "`").queue();
            }//dev

            //if(event.getMessage().getContentRaw().startsWith(prefix+"watch")){
            //  String msg = event.getMessage().getContentRaw();
            //9
            //String cutmsg = msg.substring(9);
            //event.getChannel().sendMessage("NowWatchingを設定しました！`"+cutmsg+"`").queue();
            //JDABuilder builder = JDABuilder.createDefault(args[0]);
            //builder.setActivity(Activity.listening(cutmsg));
            //builder.build();


            //}







        if (event.getMessage().getContentRaw().startsWith(shortprefix + "afk")) {

            String nick = event.getMember().getNickname();
            if(nick==null){
                String name = event.getMember().getUser().getName();
                event.getMember().modifyNickname("[AFK!]"+name).queue();
                event.getChannel().sendMessage(":mega: **"+name+"** is AFK!").queue();
            }
            else {
                event.getMember().modifyNickname("[AFK!]"+nick).queue();
                event.getChannel().sendMessage(":mega: **"+nick+"** is AFK!").queue();
            }



        }
        if (event.getMessage().getContentRaw().startsWith(shortprefix + "unafk")) {

            String nick = event.getMember().getNickname();
            String cutnick = nick.substring(6);
            event.getMember().modifyNickname(cutnick).queue();
            event.getChannel().sendMessage(":mega: **"+cutnick+"** is ONLINE!").queue();


        }




    }



}



