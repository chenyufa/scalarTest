
import org.apache.spark.SparkConf

import org.apache.spark.streaming.{Seconds, StreamingContext}


/**
  * Created by CYF on 2017/12/20.
  */
object UserClickCountAnalytics {
  def main(args: Array[String]): Unit = {
    var masterUrl = "local[1]"
    if (args.length > 0) {
      masterUrl = args(0)
    }


    val conf = new SparkConf().setMaster(masterUrl).setAppName("UserClickCountStat")
    val ssc = new StreamingContext(conf, Seconds(5))


    val topics = Set("user_events")
    val brokers = "10.10.4.126:9092,10.10.4.127:9092"
    val kafkaParams = Map[String, String](
      "metadata.broker.list" -> brokers, "serializer.class" -> "kafka.serializer.StringEncoder")

    val dbIndex = 1
    val clickHashKey = "app::users::click"



  }
}
