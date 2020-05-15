package com.gability.scala

import org.apache.logging.log4j.scala.Logging
import org.apache.spark.sql.{DataFrame, SparkSession}

object Main extends App with Logging {

    logger.info("Application Started ..")

    logger.info("Initialize Spark Session ..")

    val spark: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("Spark-Sandbox-App")
      .getOrCreate()

    logger.info("Start Transformation Pipeline ..")
    import spark.implicits._

    //dummy function
    def convertSeq2Df(inputDt: Seq[(String, String)]): DataFrame = {
      inputDt.toDF("lib", "version")
    }

}
