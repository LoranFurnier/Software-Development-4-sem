package com.leonov.lab_4;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import java.util.Date;
import java.util.Locale;

public class NotificationData {

    public static void notificationEventStarted(Context context, int widgetID)
    {
        final int NOTIFY_ID = 1;

        Resources res = context.getResources();
        NotificationChannel notificationChannel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            notificationChannel = new NotificationChannel("EventStarted", "Установленная дата", NotificationManager.IMPORTANCE_DEFAULT);
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            notificationManager.createNotificationChannel(notificationChannel);

        }Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "EventStarted")
                .setSmallIcon(R.drawable.ic_event_available)
                .setContentTitle("Результат работы — работает")
                .setContentText("Сегодня — " + dateText)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_android))
                .setTicker("Работает! Жаль, что только на старых устройствах...")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true);

        notificationManager.notify(NOTIFY_ID, builder.build());

    }
}
