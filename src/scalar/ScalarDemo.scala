import java.io.{PrintWriter, File}

/**
  * Created by CYF on 2017/11/21.
  */
class ScalarDemo {

  def sayHello(x: String): Unit = {

    val writer = new PrintWriter(new File("F:\\test.txt" ))

    writer.write(x+"菜鸟教程")
    writer.close()

    println("hello," + x)
    var A:Map[String,String] =  Map("a" -> "#FF0000")


    A.+("C" -> "C值")
    A + ("b" -> "b值")
    A += ("d" -> "d值")

    A.keys.foreach{ i =>
      print( "Key = " + i )
      println(" Value = " + A(i) )
    }

  }

  def main(args: Array[String]) {

  }

}
