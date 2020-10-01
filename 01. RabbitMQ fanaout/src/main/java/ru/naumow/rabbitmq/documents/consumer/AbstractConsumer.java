package ru.naumow.rabbitmq.documents.consumer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import ru.naumow.rabbitmq.documents.common.Common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public abstract class AbstractConsumer implements Runnable {

    @Override
    public void run() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Common.HOST_NAME);

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicQos(3);

            channel.exchangeDeclare(Common.EXCHANGE_NAME, Common.EXCHANGE_TYPE);
            String queue = channel.queueDeclare().getQueue();

            channel.queueBind(queue, Common.EXCHANGE_NAME, "");

            DeliverCallback deliverCallback = (consumerTag, message) -> {
                String json = new String(message.getBody(), StandardCharsets.UTF_8);
                Map<String, String> userInfo = Common.parseJson(json);
                try {
                    Document document = new Document();
                    File docs = new File("documents");
                    //noinspection ResultOfMethodCallIgnored
                    docs.mkdir();
                    PdfWriter.getInstance(document, new FileOutputStream("documents/" + getFilename()));

                    document.open();
                    handle(document, userInfo);
                    document.close();

                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                } catch (IOException | DocumentException e) {
                    System.err.println("FAILED");
                    channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
                }
            };
            channel.basicConsume(queue, false, deliverCallback, consumerTag -> {});
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected abstract String getFilename();

    protected abstract void handle(Document document, Map<String, String> userInfo) throws DocumentException;

}
