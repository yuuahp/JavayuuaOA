package systems.yuuahp.javayuua;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;



import javax.security.auth.login.LoginException;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Main extends ListenerAdapter {

    public static final String COMMAND_PREFIX = "/";


    public static void main(String[] args) throws LoginException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token;
        builder.addEventListeners(new Main());
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


        long ziko = 720660907352653864L;
        event.getJDA().getTextChannelById(686474057771778069L).sendMessage(":tada:**" + user + "さん**がOAstudioに参加しました！").queue();
        event.getJDA().getTextChannelById(686102510330445923L).sendMessage(":tada:**" + user + "さん！**ようこそ**OAstudio**へ！\n下のチャンネルでサーバールールをよく読み、**閲覧権限**を入手しましょう！\n閲覧権限をもらったら **自己紹介**を書いてみましょう！").queue();

    }

    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {

        String user = event.getMember().getUser().getName();


        long ziko = 720660907352653864L;
        event.getJDA().getTextChannelById(686474057771778069L).sendMessage(":cold_sweat: **" + user + "さん**がOAstudioを去りました....").queue();
        event.getJDA().getTextChannelById(686102510330445923L).sendMessage(":cold_sweat: **" + user + "さん**、また来てね....").queue();

    }


    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = new String[0];
        System.out.println("Received->" +
                event.getAuthor().getName() + ":" +
                event.getMessage().getContentDisplay()
        );
        if (event.getMessage().getContentRaw().startsWith("javayuua")) {
            event.getChannel().sendMessage("呼びました？").queue();
        }

        if (event.getMessage().getContentRaw().startsWith(prefix + "checkstate")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle(":satellite_orbital: **JavayuuaStates**", null);
            eb.setColor(new Color(155, 255, 148));

            eb.setDescription("States:**NowOnline!**");
            event.getChannel().sendMessage(eb.build()).queue();

            //event.getChannel().sendMessage("私はOnlineですよ～").queue();
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

             if (event.getMessage().getContentRaw().equals("/jy oa")) {

             }
             else {
                 String ch = event.getChannel().getId();

                 if(ch == "702161494141304832") {
                     event.getMessage().delete().queue();

                 }
             }

            if (event.getMessage().getContentRaw().contains(shortprefix + "time")) {

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

            if (event.getMessage().getContentRaw().contains("!ゆうあ")) {
                String yuua = "<@492088741167366144>";
                event.getChannel().sendMessage(yuua + "呼ばれてますよ！").queue();
            }


            if (event.getMessage().getContentRaw().startsWith(prefix + "restart")) {
                event.getChannel().sendMessage(":octagonal_sign: **Javayuua Stoped** :octagonal_sign:").queue();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //Javayuuaをリスタートする的なコード調べる


                event.getChannel().sendMessage(":white_check_mark: **Javayuua is Ready!** :white_check_mark:").queue();
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

        }


    }
}


