# baseball_stats
Big Data example using baseball stats

Examples:
http://spark.apache.org/examples.html

Build the package:
sbt package

Run locally with 4 threads:
spark-submit  --class "SimpleApp" --master local[4] target/scala-2.10/simple-app_2.10-1.0.jar