package ru.naumow.rabbitmq.documents.consumer.impl;

import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.consumer.AbstractConsumer;

import java.util.UUID;

public class DirectStudHolidayConsumer extends AbstractConsumer {

    @Override
    protected String getFilename() {
        return "direct_stud_holiday_" + UUID.randomUUID() + ".pdf";
    }

    @Override
    protected String exchangeName() {
        return Common.EXCHANGE_NAME_DIRECT_STUD_HOLIDAY;
    }

    @Override
    protected String exchangeType() {
        return Common.EXCHANGE_DIRECT;
    }

    @Override
    protected String exchangeRoutingKey() {
        return "document.original.studentTicket";
    }

    @Override
    protected String queueName() {
        return Common.EXCHANGE_NAME_DIRECT_STUD_HOLIDAY + "_queue";
    }

    @Override
    protected String templateName() {
        return "direct_stud_holiday.html";
    }
}
