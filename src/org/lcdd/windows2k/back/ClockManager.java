package org.lcdd.windows2k.back;

import org.lcdd.windows2k.Windows2KMain;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ClockManager {
    private
    long time = 946681140000L;

    public ClockManager() {
        Timer clockUpdater = new Timer("ClockUpdater");
        clockUpdater.schedule(new TimerTask() {
            @Override
            public void run() {
                addTime(60000L);
                Date date = new Date(time);
                String hour = date.toString().substring(11, 16) + "<br>" + date.toString().substring(4, 7) + "/" + date.toString().substring(8, 10) + " " + date.toString().substring(24);

                Windows2KMain.frame.desktop.taskBar.setHour(hour);
            }
        }, new Date(System.currentTimeMillis() + 100), 60000);
        // a minute

    }

    private void addTime(long add) {
        time = time + add;
    }

}
