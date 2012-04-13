/**
 *
 */
package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.marshaler.GsonMarshaler;

/**
 * @author Andrei_Khadziukou
 *
 */
public class GsonClient extends BaseClient {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            GsonClient client = new GsonClient();
            client.start(UtilVarialble.PRODUCER_QUEUE_XSTREM, UtilVarialble.CONSUMER_QUEUE_XSTREM);
        } catch (Exception exc) {
            // TODO Add log
            exc.printStackTrace();
        }

    }

    public GsonClient() throws Exception {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IBrokerService createBrokerService() {
        BrokerService service = new BrokerService();
        service.setConsumer(new JsonConsumer(getConsumerTemplate()));
        service.setProducer(new JsonProducer(getProduceTemplate()));
        service.setMarshaler(new GsonMarshaler());
        return service;
    }

}
