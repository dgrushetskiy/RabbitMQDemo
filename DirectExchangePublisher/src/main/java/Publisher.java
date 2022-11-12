import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection  = factory.newConnection();
        Channel channel = connection.createChannel();

        String message = "Hello. Message to queue";
        channel.basicPublish("direct-exchange-demo","r-1",null, message.getBytes());
        System.out.println("Message sent to the r-1");

        channel.basicPublish("direct-exchange-demo","g-1",null, message.getBytes());
        System.out.println("Message sent to the g-1");

        channel.close();
    }
}
