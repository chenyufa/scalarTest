import java.io.{File, FileWriter}
import java.util.Random




/**
  * Created by CYF on 2018/1/4.
  */
object SparkStreamTest {

  def main(args: Array[String]): Unit = {

    val writer = new FileWriter(new File("C:\\sample_age_data.txt"),false)
    val rand = new Random()
    for ( i <- 1 to 10) {
      writer.write( i + " " + rand.nextInt(100))
      writer.write(System.getProperty("line.separator"))
    }
    writer.flush()
    writer.close()



  }

}
