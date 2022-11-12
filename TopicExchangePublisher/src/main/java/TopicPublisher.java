import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection  = factory.newConnection();
        Channel channel = connection.createChannel();

        String message = "Hello. Message to queue";
        channel.basicPublish("topic-exchange-demo","red.blue",null, message.getBytes());

        channel.close();
    }
}
