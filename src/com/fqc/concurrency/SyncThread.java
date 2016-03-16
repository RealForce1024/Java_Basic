package com.fqc.concurrency;


import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import org.apache.commons.logging.Log;
import org.apache.log4j.lf5.viewer.LogFactor5Dialog;

/**
 * com.fqc.concurrency
 *
 * @author fqc
 * @date 16/3/16
 */
public class SyncThread implements  Runnable{
    static {
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("%m%n")));
    }

    public static final Log LOGGER = LogFactory.getLog(SyncThread.class);

    private Integer value;
    private static Integer NOWVALUE;

    public SyncThread(Integer value) {
        this.value = value;
    }

    public SyncThread() {

    }

    /**
     * 对实例对象的value值进行检查
     */
    public synchronized void doSomething(String thread_name) {
        NOWVALUE = this.value;
        LOGGER.info(NOWVALUE+"---"+thread_name);
    }
    @Override
    public void run() {
        Thread t0 = Thread.currentThread();
        String thread_name = t0.getName();
        this.doSomething(thread_name);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SyncThread(1),"t1");
        Thread t2 = new Thread(new SyncThread(100),"t2");
        t1.start();
        t2.start();
    }

}
