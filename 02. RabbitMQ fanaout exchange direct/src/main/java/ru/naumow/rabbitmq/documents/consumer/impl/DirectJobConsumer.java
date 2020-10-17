package ru.naumow.rabbitmq.documents.consumer.impl;

import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.consumer.AbstractConsumer;

import java.util.UUID;

public class DirectJobConsumer extends AbstractConsumer {

    @Override
    protected String getFilename() {
        return "direct_job_" + UUID.randomUUID() + ".pdf";
    }

    @Override
    protected String exchangeName() {
        return Common.EXCHANGE_NAME_DIRECT_JOB;
    }

    @Override
    protected String exchangeType() {
        return Common.EXCHANGE_DIRECT;
    }

    @Override
    protected String exchangeRoutingKey() {
        return "document.copy.passport";
    }

    @Override
    protected String queueName() {
        return Common.EXCHANGE_NAME_DIRECT_JOB + "_queue";
    }

    @Override
    protected String templateName() {
        return "direct_job.html";
    }


}
