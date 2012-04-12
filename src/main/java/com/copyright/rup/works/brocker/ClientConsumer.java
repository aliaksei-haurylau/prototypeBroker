package com.copyright.rup.works.brocker;

import org.apache.camel.ConsumerTemplate;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.impl.JsonConsumer;
import com.copyright.rup.works.brocker.impl.ThriftConsumer;
import com.copyright.rup.works.brocker.marshaler.GsonMarshaler;
import com.copyright.rup.works.brocker.marshaler.JacksonJsonMarshaler;
import com.copyright.rup.works.brocker.marshaler.JaxbJsonMarshaler;
import com.copyright.rup.works.brocker.marshaler.XStreamJsonMarshaler;

public final class ClientConsumer implements Runnable{

    private static final String CONSUMER_QUEUE_XSTREM = "jms:queue:storagexstream";
    private static final String CONSUMER_QUEUE_JAXB = "jms:queue:storagejaxb";
    private static final String CONSUMER_QUEUE_JACKSON = "jms:queue:storagejackson";
    private static final String CONSUMER_QUEUE_GSON = "jms:queue:storagegson";
    private static final String CONSUMER_QUEUE_THRIFT = "jms:queue:storagethrift";

    private static final int WORKS_COLLECTION_SIZE = 1000;

    private ConsumerTemplate consumerTemplate;

    public ClientConsumer(ConsumerTemplate consumerTemplate) {
        this.consumerTemplate = consumerTemplate;
    }

    public void run() {

        IConsumer consumer = new JsonConsumer(consumerTemplate);

        StopWatch stopWatchXStream = new Log4JStopWatch("consume.xstream");
        consumer.receiveWorks(CONSUMER_QUEUE_XSTREM, WORKS_COLLECTION_SIZE, new XStreamJsonMarshaler());
        stopWatchXStream.stop();

        StopWatch stopWatchJaxb = new Log4JStopWatch("consume.jaxb");
        consumer.receiveWorks(CONSUMER_QUEUE_JAXB, WORKS_COLLECTION_SIZE, new JaxbJsonMarshaler());
        stopWatchJaxb.stop();

        StopWatch stopWatchJackson = new Log4JStopWatch("consume.jackson");
        consumer.receiveWorks(CONSUMER_QUEUE_JACKSON, WORKS_COLLECTION_SIZE, new JacksonJsonMarshaler());
        stopWatchJackson.stop();

        StopWatch stopWatchGson = new Log4JStopWatch("consume.gson");
        consumer.receiveWorks(CONSUMER_QUEUE_GSON, WORKS_COLLECTION_SIZE, new GsonMarshaler());
        stopWatchGson.stop();

        StopWatch stopWatchThrift = new Log4JStopWatch("consume.thrift");
        ThriftConsumer thriftConsumer = new ThriftConsumer(consumerTemplate);
        thriftConsumer.receiveWorks(CONSUMER_QUEUE_THRIFT, WORKS_COLLECTION_SIZE, null);
        stopWatchThrift.stop();

        try {
            consumerTemplate.stop();
        } catch (Exception e) {
           ///TODO use logger here
        }
    }
}