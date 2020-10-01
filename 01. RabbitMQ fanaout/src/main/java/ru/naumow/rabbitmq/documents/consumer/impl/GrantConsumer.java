package ru.naumow.rabbitmq.documents.consumer.impl;


import com.itextpdf.text.*;
import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.consumer.AbstractConsumer;

import java.util.Map;

public class GrantConsumer extends AbstractConsumer {

    @Override
    protected String getFilename() {
        return "grant.pdf";
    }

    @Override
    protected void handle(Document document, Map<String, String> userInfo) throws DocumentException {
        document.add(new Paragraph());
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, "Cp1251", 18, Font.BOLD, BaseColor.BLACK);
        Chunk chunk = new Chunk("Tak your grant: " + userInfo.get(Common.FIRST_NAME) + " " + userInfo.get(Common.LAST_NAME) + "!\n", font);

        document.add(chunk);
        document.add(Chunk.NEWLINE);

        font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLACK);
        chunk = new Chunk("Age: ", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        chunk = new Chunk(userInfo.get(Common.AGE) + "\n", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLACK);
        chunk = new Chunk("Passport number: ", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        chunk = new Chunk(userInfo.get(Common.PASSPORT_NUMBER) + "\n", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLACK);
        chunk = new Chunk("Passport date: ", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        chunk = new Chunk(userInfo.get(Common.DATA_OF_ISSUE) + "\n", font);
        document.add(chunk);
    }
}
