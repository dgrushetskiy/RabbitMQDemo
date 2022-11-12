import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

import java.util.concurrent.TimeoutException;

public class QConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection  = factory.newConnection();
        Channel channel = connection.createChannel();

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String (delivery.getBody());
            System.out.println("Message received by consumer = " + message);
        };

        channel.basicConsume("queue-1", true, deliverCallback, consumerTag -> {} );


    }
}
