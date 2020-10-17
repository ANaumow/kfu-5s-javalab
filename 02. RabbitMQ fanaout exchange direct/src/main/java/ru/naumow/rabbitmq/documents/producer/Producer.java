package ru.naumow.rabbitmq.documents.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import ru.naumow.rabbitmq.documents.common.Common;
import ru.naumow.rabbitmq.documents.common.Request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) {

        while (true) {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(Common.HOST_NAME);

            List<Request> requests = Common.requests;

            System.out.println("Choose what you need:");
            for (int i = 0; i < requests.size(); i++) {
                System.out.printf("%s) %s%n", i + 1, requests.get(i).getName());
            }

            Scanner scanner = new Scanner(System.in);
            int num = Integer.parseInt(scanner.nextLine());

            System.out.println("We need your " + requests.get(num - 1).getDocumentType());
            String line = scanner.nextLine();
            String routingKey = requests.get(num - 1).getDocumentCode();

            try (Connection connection = connectionFactory.newConnection();
                 Channel channel = connection.createChannel()) {
                channel.basicPublish(Common.EXCHANGE_NAME_FANOUT, routingKey, null, line.getBytes(StandardCharsets.UTF_8));
                channel.basicPublish(Common.EXCHANGE_NAME_DIRECT_ED_PACK, routingKey, null, line.getBytes(StandardCharsets.UTF_8));
                channel.basicPublish(Common.EXCHANGE_NAME_DIRECT_JOB, routingKey, null, line.getBytes(StandardCharsets.UTF_8));
                channel.basicPublish(Common.EXCHANGE_NAME_DIRECT_OPEN_DEBIT, routingKey, null, line.getBytes(StandardCharsets.UTF_8));
                channel.basicPublish(Common.EXCHANGE_NAME_DIRECT_STUD_HOLIDAY, routingKey, null, line.getBytes(StandardCharsets.UTF_8));
                channel.basicPublish(Common.EXCHANGE_NAME_TOPIC, routingKey, null, line.getBytes(StandardCharsets.UTF_8));
            } catch (IOException | TimeoutException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }


}
