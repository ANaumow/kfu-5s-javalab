package ru.naumow.rabbitmq.documents.consumer;

import ru.naumow.rabbitmq.documents.consumer.impl.AcademicHolidayConsumer;
import ru.naumow.rabbitmq.documents.consumer.impl.GrantConsumer;
import ru.naumow.rabbitmq.documents.consumer.impl.UniversityApplyingConsumer;

public class Starter {

    public static void main(String[] args) {
        new AcademicHolidayConsumer().run();
        new UniversityApplyingConsumer().run();
        new GrantConsumer().run();
    }

}
