package ru.naumow.rabbitmq.documents.consumer;

import ru.naumow.rabbitmq.documents.consumer.impl.DirectEdPackConsumer;
import ru.naumow.rabbitmq.documents.consumer.impl.DirectJobConsumer;
import ru.naumow.rabbitmq.documents.consumer.impl.DirectOpenDebitConsumer;
import ru.naumow.rabbitmq.documents.consumer.impl.DirectStudHolidayConsumer;
import ru.naumow.rabbitmq.documents.consumer.impl.FanoutCounterConsumer;
import ru.naumow.rabbitmq.documents.consumer.impl.TopicCopiesCounterConsumer;

public class Starter {

    public static void main(String[] args) {
        new DirectJobConsumer().run();
        new DirectEdPackConsumer().run();
        new DirectOpenDebitConsumer().run();
        new DirectStudHolidayConsumer().run();
        new TopicCopiesCounterConsumer().run();
        new FanoutCounterConsumer().run();
    }

}
