package com.deba.threadd.management.dameon;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread{

    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            clean(new Date());
        }
    }

    private void clean(Date date) {
        if(deque.isEmpty()) {
            return;
        }
        boolean deleted = false;
        long timeDiffrence = 0L;

        do {
            Event event = null;

            if(!deque.isEmpty()) {
                event = deque.getLast();
                timeDiffrence = date.getTime() - event.getDate().getTime();
            }
//            System.out.println("timeDiffrence is: "+timeDiffrence);
            if(timeDiffrence >= 1000 && event != null) {
                System.out.printf("Cleaner: %s\n",event.getEvent());
                deque.removeLast();
                deleted=true;
            }

        }while (timeDiffrence >= 1000);

        if(deleted) {
            System.out.printf("Cleaner: Size of the queue: %d\n",deque.size());
        }
    }
}
