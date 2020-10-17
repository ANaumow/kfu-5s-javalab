package ru.naumow.rabbitmq.documents.consumer.impl;


import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.consumer.AbstractConsumer;

public class FanoutCounterConsumer extends AbstractConsumer {

    private int counter = 0;

    @Override
    protected String getFilename() {
        return "requestCounter.pdf";
    }

    @Override
    protected String exchangeName() {
        return Common.EXCHANGE_NAME_FANOUT;
    }

    @Override
    protected String exchangeType() {
        return Common.EXCHANGE_FANOUT;
    }

    @Override
    protected String exchangeRoutingKey() {
        return "";
    }

    @Override
    protected String queueName() {
        return Common.EXCHANGE_NAME_FANOUT + "_queue";
    }

    @Override
    protected String templateName() {
        return "fanout.html";
    }

    @Override
    protected String data(String message) {
        return String.valueOf(++counter);
    }
}
