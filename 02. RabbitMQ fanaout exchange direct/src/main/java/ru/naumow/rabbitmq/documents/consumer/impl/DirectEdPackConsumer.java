package ru.naumow.rabbitmq.documents.consumer.impl;

import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.consumer.AbstractConsumer;

import java.util.UUID;

public class DirectEdPackConsumer extends AbstractConsumer {

    @Override
    protected String getFilename() {
        return "direct_ed_pack_" + UUID.randomUUID() + ".pdf";
    }

    @Override
    protected String exchangeName() {
        return Common.EXCHANGE_NAME_DIRECT_ED_PACK;
    }

    @Override
    protected String exchangeType() {
        return Common.EXCHANGE_DIRECT;
    }

    @Override
    protected String exchangeRoutingKey() {
        return "document.copy.studentTicket";
    }

    @Override
    protected String queueName() {
        return Common.EXCHANGE_NAME_DIRECT_ED_PACK + "_queue";
    }

    @Override
    protected String templateName() {
        return "direct_ed_pack.html";
    }

}
