package com.gability.scala

import org.apache.logging.log4j.scala.Logging
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object Main extends App with Logging {

  logger.info("Application Started ..")

  logger.info("Initialize Spark Session ..")

  val spark: SparkSession = SparkSession
    .builder()
    .master("local[*]")
    .appName("Spark-Sandbox-App")
    .getOrCreate()

  import spark.implicits._

  logger.info("Starting Spark ..")

  case class Person(name: String, age: Int)
  val sampleDt = Seq(Person("Moustafa", 27), Person("Mahmoud", 23)).toDS()
  sampleDt.show()
  sampleDt.printSchema()

}
