import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeckillActivityDemo {
    public static void main(String[] args) {
        // 定义活动截止时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endTime = LocalDateTime.parse("2024-06-18 00:00:00", formatter);

        // 定义小红和小明的参加时间
        LocalDateTime xiaohongTime = LocalDateTime.parse("2024-06-17 23:59:58", formatter);
        LocalDateTime xiaomingTime = LocalDateTime.parse("2024-06-18 00:00:02", formatter);

        // 判断小红是否参加上了活动
        boolean xiaohongParticipated = xiaohongTime.isBefore(endTime);
        System.out.println("小红参加上了活动: " + xiaohongParticipated);

        // 判断小明是否参加上了活动
        boolean xiaomingParticipated = xiaomingTime.isBefore(endTime);
        System.out.println("小明参加上了活动: " + xiaomingParticipated);
    }
}