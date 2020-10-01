package ru.naumow.rabbitmq.documents.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import ru.naumow.rabbitmq.documents.common.Common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Common.HOST_NAME);

        Map<String, String> userInfo = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(Common.FIRST_NAME + ":");
        userInfo.put(Common.FIRST_NAME, scanner.nextLine());

        System.out.println(Common.LAST_NAME + ":");
        userInfo.put(Common.LAST_NAME, scanner.nextLine());

        System.out.println(Common.AGE + ":");
        userInfo.put(Common.AGE, scanner.nextLine());

        System.out.println(Common.PASSPORT_NUMBER + ":");
        userInfo.put(Common.PASSPORT_NUMBER, scanner.nextLine());

        System.out.println(Common.DATA_OF_ISSUE + ":");
        userInfo.put(Common.DATA_OF_ISSUE, scanner.nextLine());

        scanner.close();

        String json = Common.writeJson(userInfo);

        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(Common.EXCHANGE_NAME, Common.EXCHANGE_TYPE);
            channel.basicPublish(Common.EXCHANGE_NAME, "", null, json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }


}
