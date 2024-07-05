import java.time.*;
import java.time.format.DateTimeFormatter;

public class dataDemo {
    public static void main(String[] args) {
        //1. LocalDate - 表示日期（年月日）
        // 获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("当前日期：" + today);

        // 创建指定日期
        LocalDate christmas = LocalDate.of(2024, 12, 25);
        System.out.println("圣诞节日期：" + christmas);

        // 获取年、月、日
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println("年：" + year + "，月：" + month + "，日：" + day);

        // 日期比较
        boolean isBefore = today.isBefore(christmas);
        System.out.println("今天是否在圣诞节之前：" + isBefore);

        //2. LocalTime - 表示时间（时分秒纳秒）
        // 获取当前时间
        LocalTime now = LocalTime.now();
        System.out.println("当前时间：" + now);

        // 创建指定时间
        LocalTime lunchTime = LocalTime.of(12, 0);
        System.out.println("午餐时间：" + lunchTime);

        // 获取时、分、秒
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        System.out.println("时：" + hour + "，分：" + minute + "，秒：" + second);

        //3. LocalDateTime - 表示日期时间（年月日时分秒）
        // 获取当前日期时间
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println("当前日期时间：" + nowTime);

        // 创建指定日期时间
        LocalDateTime christmasEve = LocalDateTime.of(2023, 12, 24, 20, 0);
        System.out.println("圣诞节前夜：" + christmasEve);

        // 格式化日期时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = nowTime.format(formatter);
        System.out.println("格式化后的日期时间：" + formattedDateTime);

        //4. Instant - 表示时刻（时间戳）
        // 获取当前时间戳
        Instant nowTimeUnix = Instant.now();
        System.out.println("当前时间戳：" + nowTimeUnix);

        // 创建指定时间戳（从 Unix 纪元开始的秒数）
        Instant specificTime = Instant.ofEpochSecond(1615428902);
        System.out.println("指定时间戳：" + specificTime);

        // 时间戳比较
        boolean isBeforeUnix = nowTimeUnix.isBefore(specificTime);
        System.out.println("当前时间戳是否在指定时间戳之前：" + isBeforeUnix);

        //5. Duration 和 Period - 表示时间段和日期间隔
        // 计算时间段
        LocalTime start = LocalTime.of(10, 0);
        LocalTime end = LocalTime.of(12, 30);
        Duration duration = Duration.between(start, end);
        System.out.println("时间段：" + duration.toMinutes() + " 分钟");

        // 计算日期间隔
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        Period period = Period.between(startDate, endDate);
        System.out.println("日期间隔：" + period.getMonths() + " 个月 " + period.getDays() + " 天");
    }
}