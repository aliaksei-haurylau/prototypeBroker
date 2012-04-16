package com.copyright.rup.works.broker.impl;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.api.IConsumer;
import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.api.IProducer;
import com.copyright.rup.works.domain.api.IWork;

import java.util.ArrayList;
import java.util.List;

/**
 * It is a broker service implementation.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/13/12.
 *
 * @author Andrei_Khadziukou.
 *
 */
public class BrokerService implements IBrokerService {

    private IConsumer consumer;
    private IMarshaler marshaler;
    private IProducer producer;

    /**
     * It gets consumer.
     *
     * @return the consumer
     */
    public IConsumer getConsumer() {
        return consumer;
    }

    /**
     * It gets marshaler.
     *
     * @return the marshaler
     */
    public IMarshaler getMarshaler() {
        return marshaler;
    }

    /**
     * It gets producer.
     *
     * @return the producer
     */
    public IProducer getProducer() {
        return producer;
    }

    /**
     * {@inheritDoc}
     */
    public List<IWork> receive(String queueName) {
        consumer.receiveWorks(queueName, UtilVarialble.CHUNK_SIZE, marshaler);
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void send(List<IWork> works, String queueName) {

        int startIndex = 0;
        int endIndex = UtilVarialble.CHUNK_SIZE;

        List<IWork> chunkWorks;
        do {
            if (endIndex > works.size()) {
                endIndex = works.size();
            }
            chunkWorks = new ArrayList<>(works.subList(startIndex, endIndex));
            startIndex = endIndex;
            endIndex += UtilVarialble.CHUNK_SIZE;
            producer.sendWorks(queueName, chunkWorks, marshaler);
            // TODO Check while (index <= works.size())
        } while (startIndex < works.size());
    }

    /**
     * It sets consumer.
     *
     * @param consumer
     *            the consumer to set
     */
    public void setConsumer(IConsumer consumer) {
        this.consumer = consumer;
    }

    /**
     * It sets marshaler.
     *
     * @param marshaler
     *            the marshaler to set
     */
    public void setMarshaler(IMarshaler marshaler) {
        this.marshaler = marshaler;
    }

    /**
     * It sets producer.
     *
     * @param producer
     *            the producer to set
     */
    public void setProducer(IProducer producer) {
        this.producer = producer;
    }

}
