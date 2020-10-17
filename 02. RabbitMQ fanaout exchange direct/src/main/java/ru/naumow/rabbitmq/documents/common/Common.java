package ru.naumow.rabbitmq.documents.common;

import java.util.Arrays;
import java.util.List;

public class Common {

    public final static String EXCHANGE_NAME_DIRECT_JOB = "documents_direct_job";
    public final static String EXCHANGE_NAME_DIRECT_ED_PACK = "documents_direct_ed_pack";
    public final static String EXCHANGE_NAME_DIRECT_OPEN_DEBIT = "documents_direct_open_debit";
    public final static String EXCHANGE_NAME_DIRECT_STUD_HOLIDAY = "documents_direct_stud_holiday";

    public final static String EXCHANGE_NAME_FANOUT = "documents_fanout";
    public final static String EXCHANGE_NAME_TOPIC = "documents_topic";

    public final static String EXCHANGE_FANOUT = "fanout";
    public final static String EXCHANGE_DIRECT = "direct";
    public final static String EXCHANGE_TOPIC = "topic";

    public final static String HOST_NAME = "localhost";

    public final static List<Request> requests = Arrays.asList(
            new Request("Get a job", "copy of passport", "document.copy.passport"),
            new Request("Get a student education pack", "copy of student ticket", "document.copy.studentTicket"),
            new Request("Open debit account", "original passport", "document.original.passport"),
            new Request("Get a student holiday", "original student ticket", "document.original.studentTicket")
    );

}
