package ru.naumow.rabbitmq.documents.consumer.impl;


import com.itextpdf.text.*;
import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.consumer.AbstractConsumer;

public class TopicCopiesCounterConsumer extends AbstractConsumer {

    private int counter = 0;

    @Override
    protected String getFilename() {
        return "copiesCounter.pdf";
    }

    @Override
    protected String exchangeName() {
        return Common.EXCHANGE_NAME_TOPIC;
    }

    @Override
    protected String exchangeType() {
        return Common.EXCHANGE_TOPIC;
    }

    @Override
    protected String exchangeRoutingKey() {
        return "document.copy.*";
    }

    @Override
    protected String queueName() {
        return Common.EXCHANGE_NAME_TOPIC + "_queue";
    }

    @Override
    protected String templateName() {
        return "topic.html";
    }

    @Override
    protected String data(String message) {
        return String.valueOf(++counter);
    }
}
