package systems.yuuahp.JavayuuaOA;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import net.dv8tion.jda.api.managers.AudioManager;
import systems.yuuahp.JavayuuaOA.Command.HelloWorld;
import systems.yuuahp.JavayuuaOA.Command.Timer;
import systems.yuuahp.JavayuuaOA.Command.jyLookUP;


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
        builder.addEventListeners(new Main());
        builder.addEventListeners(new HelloWorld());
        builder.addEventListeners(new Timer());
        builder.addEventListeners(new jyLookUP());
        token = System.getenv("token");
        builder.setToken(token);

        builder.build();


    }

    public String prefix = "/jy ";
    public String shortprefix = "/";
    public StringBuffer jyidq = new StringBuffer();
    public StringBuffer jyidch = new StringBuffer();

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        String user = event.getMember().getUser().getName();



        event.getJDA().getTextChannelById(686474057771778069L).sendMessage(":tada:**" + user + "さん**がOAstudioに参加しました！").queue();
        event.getJDA().getTextChannelById(686102510330445923L).sendMessage(":tada:**" + user + "さん！**ようこそ**OAstudio**へ！\n下のチャンネルでサーバールールをよく読み、**閲覧権限**を入手しましょう！\n閲覧権限をもらったら **自己紹介**を書いてみましょう！").queue();

    }

    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {

        String user = event.getMember().getUser().getName();



        event.getJDA().getTextChannelById(686474057771778069L).sendMessage(":cold_sweat: **" + user + "さん**がOAstudioを去りました....").queue();
        event.getJDA().getTextChannelById(686102510330445923L).sendMessage(":cold_sweat: **" + user + "さん**、また来てね....").queue();

    }



    @Override
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
        if (event.getMessage().getContentRaw().startsWith("javayuua")) {
            event.getChannel().sendMessage("呼びました？").queue();
        }




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



            if (event.getMessage().getContentRaw().equals(shortprefix + "time")) {

                // 現在日時情報で初期化されたインスタンスの生成
                Date dateObj = new Date();
                TimeZone tzn1 = TimeZone.getDefault();//[1]
                Calendar cal1 = Calendar.getInstance(tzn1);//[2]
                TimeZone tzn2 = TimeZone.getTimeZone("Asia/Tokyo");
                cal1.setTimeZone(tzn2);//[6]


                event.getChannel().sendMessage("現在時刻は" + cal1.get(Calendar.HOUR_OF_DAY) + ":" + cal1.get(Calendar.MINUTE) + "です！").queue();
            }


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

            if (event.getMessage().getContentRaw().startsWith(shortprefix + "chat")) {
                String msg = event.getMessage().getContentRaw();
                //8
                String cutmsg = msg.substring(5);
                event.getMessage().delete().queue();
                event.getChannel().sendMessage(cutmsg).queue();

            }
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



