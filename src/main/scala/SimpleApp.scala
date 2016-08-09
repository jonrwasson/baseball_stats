/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets


object SimpleApp {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile("./data/input/sample_input.txt", 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    //println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    Files.write(Paths.get("./data/output/sample_output.txt"), "Lines with a: %s, Lines with b: %s".format(numAs, numBs).getBytes(StandardCharsets.UTF_8))
  }
}