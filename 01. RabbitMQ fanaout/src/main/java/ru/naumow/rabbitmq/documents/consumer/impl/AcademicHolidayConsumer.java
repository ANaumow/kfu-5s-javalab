package ru.naumow.rabbitmq.documents.consumer.impl;

import com.itextpdf.text.*;
import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.consumer.AbstractConsumer;

import java.util.Map;

public class AcademicHolidayConsumer extends AbstractConsumer {

    @Override
    protected String getFilename() {
        return "academic_holiday.pdf";
    }

    @Override
    protected void handle(Document document, Map<String, String> userInfo) throws DocumentException {
        document.add(new Paragraph());
        Font font = FontFactory.getFont(FontFactory.COURIER, 18, BaseColor.BLACK);
        Chunk chunk = new Chunk("Academic holiday declaration\n", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLACK);
        chunk = new Chunk("Name: ", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16,  Font.NORMAL, BaseColor.BLACK);
        chunk = new Chunk(userInfo.get(Common.FIRST_NAME) + " " + userInfo.get(Common.LAST_NAME) + "\n", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD, BaseColor.BLACK);
        chunk = new Chunk("Age: ", font);
        document.add(chunk);

        font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        chunk = new Chunk(userInfo.get(Common.AGE) + "\n", font);
        document.add(chunk);

        document.add(Chunk.NEWLINE);

        font = FontFactory.getFont(FontFactory.COURIER, 18, BaseColor.BLACK);
        chunk = new Chunk("Студента пасспорт\n", font);
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
