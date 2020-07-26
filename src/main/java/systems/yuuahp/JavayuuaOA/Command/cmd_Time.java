package systems.yuuahp.JavayuuaOA.Command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class cmd_Time {
    @SubscribeEvent
    public void onMessageReceived(MessageReceivedEvent event) {
        String shortprefix = "/";
        if (event.getMessage().getContentRaw().equals(shortprefix + "time")) {


            // 現在日時情報で初期化されたインスタンスの生成
            Date dateObj = new Date();
            TimeZone tzn1 = TimeZone.getDefault();//[1]
            Calendar cal1 = Calendar.getInstance(tzn1);//[2]
            TimeZone tzn2 = TimeZone.getTimeZone("Asia/Tokyo");
            cal1.setTimeZone(tzn2);//[6]


            event.getChannel().sendMessage("現在時刻は" + cal1.get(Calendar.HOUR_OF_DAY) + ":" + cal1.get(Calendar.MINUTE) + "です！").queue();
        }
    }

}
