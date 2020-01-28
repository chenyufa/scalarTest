import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by CYF
 * on 2018/7/2.
 */
public class customConsumer {
    public static void main(String[] args) {
        String groupID = "GroupA6";
        String topicName = "39_topic_39";

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.30.39:9092");
        //props.put("bootstrap.servers", "127.0.0.1:9092");
        //消费者的组id
        props.put("group.id", groupID);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        //从poll(拉)的回话处理时长
        props.put("session.timeout.ms", "30000");
        //poll的数量限制
        props.put("max.poll.records", "100");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);


        //自定义offset
        //Map<TopicPartition, OffsetAndMetadata> hashMaps = new HashMap<TopicPartition, OffsetAndMetadata>();
        //hashMaps.put(new TopicPartition(topicName, 3), new OffsetAndMetadata(0));
        //consumer.commitSync(hashMaps);
        //consumer.assign(Arrays.asList(new TopicPartition(topicName, 0)));
        //consumer.seekToBeginning(Arrays.asList(new TopicPartition(topicName, 0)));//不改变当前offset
        //consumer.seek(new TopicPartition(topicName, 0), 4);//不改变当前offset

        //订阅主题列表topic
        //consumer.subscribe(Arrays.asList(topicName));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                //　正常这里应该使用线程池处理，不应该在这里处理
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value()+"\n");
        }
    }
}
