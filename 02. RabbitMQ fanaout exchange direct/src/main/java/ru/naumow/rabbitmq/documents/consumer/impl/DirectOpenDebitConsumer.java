package ru.naumow.rabbitmq.documents.consumer.impl;

import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.consumer.AbstractConsumer;

import java.util.UUID;

public class DirectOpenDebitConsumer extends AbstractConsumer {

    @Override
    protected String getFilename() {
        return "direct_open_debit_" + UUID.randomUUID() + ".pdf";
    }

    @Override
    protected String exchangeName() {
        return Common.EXCHANGE_NAME_DIRECT_OPEN_DEBIT;
    }

    @Override
    protected String exchangeType() {
        return Common.EXCHANGE_DIRECT;
    }

    @Override
    protected String exchangeRoutingKey() {
        return "document.original.passport";
    }

    @Override
    protected String queueName() {
        return Common.EXCHANGE_NAME_DIRECT_OPEN_DEBIT + "_queue";
    }

    @Override
    protected String templateName() {
        return "direct_open_debit.html";
    }
}
