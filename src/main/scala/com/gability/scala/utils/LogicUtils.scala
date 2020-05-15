package com.gability.scala.utils

import org.apache.spark.sql.{DataFrame, Dataset, Encoder, SparkSession}

case class LogicUtils(spark: SparkSession) {

  import spark.implicits._

  //dummy function
  def convertSeq2Df(inputSeq: Seq[(String, String)],
                    cols: Seq[String]): DataFrame = {
    inputSeq.toDF(cols: _*)
  }

  def convertSeq2Ds[T](inputSeq: Seq[(String, String)], cols: Seq[String])(
      implicit encoder: Encoder[T]): Dataset[T] = {
    inputSeq.toDF(cols: _*).as[T]
  }
}
