package systems.yuuahp.javayuua;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import systems.yuuahp.javayuua.Events.PushPin;


import javax.security.auth.login.LoginException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;



public class Main extends ListenerAdapter {

    public static final String COMMAND_PREFIX = "/";


    public static void main(String[] args) throws LoginException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token;
        token = System.getenv("token");
        builder.setToken(token);

        builder.addEventListeners(new PushPin());
        builder.build();










    }
    public String prefix = "/jy ";
    public String shortprefix = "/";
    public StringBuffer jyidq = new StringBuffer();
    public StringBuffer jyidch = new StringBuffer();

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        String user = event.getMember().getUser().getName();



        long ziko = 720660907352653864L;
        event.getJDA().getTextChannelById(686474057771778069L).sendMessage(":tada:**"+user+"さん**がOAstudioに参加しました！").queue();
        event.getJDA().getTextChannelById(686102510330445923L).sendMessage(":tada:**"+user+"さん！**ようこそ**OAstudio**へ！\n下のチャンネルでサーバールールをよく読み、**閲覧権限**を入手しましょう！\n閲覧権限をもらったら **自己紹介**を書いてみましょう！").queue();

    }



    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = new String[0];
        System.out.println("Received->" +
                event.getAuthor().getName() +  ":" +
                event.getMessage().getContentDisplay()
        );
        if(event.getMessage().getContentRaw().startsWith("javayuua")){
            event.getChannel().sendMessage("呼びました？").queue();
        }

        if(event.getMessage().getContentRaw().startsWith(prefix+"checkstate")){
            event.getChannel().sendMessage("私はOnlineですよ～").queue();
        }

        if(event.getMessage().getContentRaw().contains(shortprefix+"pingyuua")){
            event.getChannel().sendMessage("ぽんぐ！(pong!)").queue();
        }

        if(event.getMessage().getContentRaw().startsWith("自己紹介してjavayuua")){
            event.getChannel().sendMessage("**こんにちは！**\n私は**javayuua**と言います！\n色んな事が出来る多機能系BOTです。\n**DESTROY MEE6**\n.\n.\nよろしく！\nhttps://discordapp.com/channels/686102510330445875/686470299201306625/734075610678296618").queue();
        }



        if(event.getMessage().getContentRaw().contains(shortprefix+"time")){

            // 現在日時情報で初期化されたインスタンスの生成
            Date dateObj = new Date();
            TimeZone tzn1 = TimeZone.getDefault();//[1]
            Calendar cal1 = Calendar.getInstance(tzn1);//[2]
            TimeZone tzn2 = TimeZone.getTimeZone("Asia/Tokyo");
            cal1.setTimeZone(tzn2);//[6]



            event.getChannel().sendMessage("現在時刻は"+cal1.get(Calendar.HOUR_OF_DAY)+":"+cal1.get(Calendar.MINUTE)+"です！" ).queue();
        }


        if(event.getMessage().getContentRaw().startsWith(prefix+"emojisubmit")){
            String emjsubmsg = event.getMessage().getContentRaw();
            String Name = event.getMember().getUser().getName();
            event.getChannel().sendMessage("申請を送信しました。\n`jyid:お好きなID`を送信してください。\n申請はこのIDをもとに管理されます。\n**・分かりやすいIDの生成にご協力ください。**\n**・原則半角英数字のみとさせて頂きます。**").queue();
            event.getJDA().getTextChannelById("686474057771778069").sendMessage(":pencil:**"+Name+"さん**から新たな**絵文字リクエスト**がありました！\n>"+emjsubmsg).queue();
        }//スタッフ会議



        if(event.getMessage().getContentRaw().startsWith(prefix+"req")){
            String submsg = event.getMessage().getContentRaw();
            String Name = event.getMember().getUser().getName();
            event.getChannel().sendMessage("申請を送信しました。\n`jyid:お好きなID`を送信してください。\n申請はこのIDをもとに管理されます。\n**・分かりやすいIDの生成にご協力ください。**\n**・原則半角英数字のみとさせて頂きます。**").queue();
            event.getJDA().getTextChannelById("686474057771778069").sendMessage(":pencil:**"+Name+"さん**から新たな**申請**がありました！\n`>"+submsg+"`").queue();
        }//スタッフ会議


        if(event.getMessage().getContentRaw().startsWith("jyid:")){

            String jyid = event.getMessage().getContentRaw();
            jyidq.replace(0,100,jyid);
            String Name = event.getMember().getUser().getName();
            String ch = event.getChannel().getName();
            jyidch.replace(0,100,ch);
            event.getChannel().sendMessage("申請ID->`"+jyid+"`を生成しました。\nスタッフ内で審議しますのでしばらくお待ちください。").queue();
            event.getJDA().getTextChannelById("686474057771778069").sendMessage(":pencil:**"+Name+"さん**が新たなJYIDを申請しました！\n`>"+jyidq+"`\n運営は審議完了後に`/jy aprv "+jyid+"`か`/jy noaprv "+jyid+"`を実行してください。").queue();
            //スタッフ会議
        }

        if(event.getMessage().getContentRaw().startsWith(prefix+"aprv")){
            String aprvmsg = event.getMessage().getContentRaw();
            //8
            String cutmsg = aprvmsg.substring(9);
            event.getChannel().sendMessage(":pencil:"+cutmsg+"の**承認処理**に成功しました！").queue();
            event.getJDA().getTextChannelById("686473875143393288").sendMessage("JYID`"+cutmsg+"`が**承認**されました。").queue();
            //質問相談
        }
        if(event.getMessage().getContentRaw().startsWith(prefix+"noaprv")){
            String noaprvmsg = event.getMessage().getContentRaw();
            //8
            String cutmsg = noaprvmsg.substring(10);
            event.getChannel().sendMessage(":pencil:"+cutmsg+"の**否認処理**に成功しました！").queue();
            event.getJDA().getTextChannelById("686473875143393288").sendMessage("JYID`"+cutmsg+"`が**否認**されました。").queue();
            //質問相談
        }
        if(event.getMessage().getContentRaw().startsWith(prefix+"oa")){
            Role role = event.getGuild().getRoleById(686103774691065871L);
            Role role2 = event.getGuild().getRoleById(720326371217244321L);
            String Name = event.getMember().getUser().getName();
            String member = event.getAuthor().getId();
            event.getGuild().addRoleToMember(member, role).queue();
            event.getGuild().addRoleToMember(member,role2).queue();
            event.getChannel().sendMessage("サーバールールを読んでいただきありがとうございました！\n**"+Name+"さん**、あなたに**閲覧権限**を付与しました！").queue();
        }

        if(event.getMessage().getContentRaw().startsWith(prefix+"devreq")){
            String reqmsg = event.getMessage().getContentRaw();
            String Name = event.getMember().getUser().getName();
            event.getChannel().sendMessage("**ありがとうございます！**リクエストを送信しました!").queue();
            event.getJDA().getTextChannelById("712698533941215293").sendMessage(":pencil:**"+Name+"さん**から新たな**開発リクエスト**がありました！\n`>"+reqmsg+"`").queue();
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

        if(event.getMessage().getContentRaw().contains("ゆうあ")){
            String yuua = "<@492088741167366144>";
            event.getChannel().sendMessage(yuua+"呼ばれてますよ！").queue();
        }

        if(event.getMessage().isPinned()){
            event.getChannel().sendMessage("pushpin!");
        }




    }






}


