

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.alibaba.fastjson.JSON;


import java.util.Properties;
import java.util.concurrent.Future;

public class TestProducer {

    public static final String topic_student = "student";

    public static void main(String[] args) throws InterruptedException{
        producer("begin");
    }

    public static void producer(String info) throws InterruptedException{
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.30.39:9092");
        //props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //创建kafka的生产者类
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        Future<RecordMetadata> recode = null;
        for (int i = 1; i <= 100; i++) {
            Student student = new Student(i, "zhisheng" + i, "password" + i, 18 + i);
            ProducerRecord record = new ProducerRecord<String, String>(topic_student, null, null, JSON.toJSONString(student));
            producer.send(record);
            System.out.println("send data: " + JSON.toJSONString(student));

            Thread.sleep(10 * 1000); //发送一条数据 sleep 10s，相当于 1 分钟 6 条
        }
        producer.flush();
        producer.close();

    }

}
