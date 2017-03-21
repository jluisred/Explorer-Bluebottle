package org.librairy.bluebottle.conf;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunTopicModelling implements Runnable{

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Override
	public void run() {
		// TODO Auto-generated method stub
        log.info("The time is now {}", dateFormat.format(new Date()));

        
	}

}
