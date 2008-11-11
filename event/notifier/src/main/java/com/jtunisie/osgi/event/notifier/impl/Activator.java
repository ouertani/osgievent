package com.jtunisie.osgi.event.notifier.impl;

import java.util.Date;
import java.util.Properties;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.springframework.osgi.extensions.annotation.ServiceReference;

/**
 *
 * @author slim
 */
public class Activator {

    private String EVENT_QUEUE;

    protected void init() throws InterruptedException {
        Properties props = new Properties();
        int i=0;
        while (true) {
            props.setProperty("property", ""+i+++" : "+ new Date());
            eventAdmin.sendEvent(new Event(EVENT_QUEUE, props));
            Thread.sleep(30*1000);
        }
    }
    private EventAdmin eventAdmin;

    @ServiceReference
    public void setEventAdmin(EventAdmin eventAdmin) {
        this.eventAdmin = eventAdmin;
    }

    public void setEVENT_QUEUE(String EVENT_QUEUE) {
        this.EVENT_QUEUE = EVENT_QUEUE;
    }
}
