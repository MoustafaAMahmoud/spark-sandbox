package com.gability.scala

import com.gability.scala.utils.LogicUtils
import com.holdenkarau.spark.testing._
import TestingUtils._
import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.scalatest._
class MainTest extends FunSuite with DataFrameSuiteBase with DatasetSuiteBase {

  var utilFun: LogicUtils = _
  test("Testing Dataframe equality ") {
    import spark.implicits._

    utilFun = LogicUtils(spark)
    val actual: Dataset[Row] = utilFun.convertSeq2Df(sampleDt, columnNames)

    val expected: Dataset[Row] = sampleDt.toDF(columnNames: _*)
    assertDataFrameEquals(expected, actual)

  }

  test("Testing Dataset equality ") {

    import spark.implicits._

    utilFun = LogicUtils(spark)

    val actual: Dataset[DependencyLibraries] =
      utilFun.convertSeq2Ds[DependencyLibraries](sampleDt, columnNames)

    val expected: Dataset[DependencyLibraries] =
      sampleDt.toDF(columnNames: _*).as[DependencyLibraries]
    assertDatasetEquals(expected, actual)

  }

  test("Testing Datasets using Seq assert equality") {

    import spark.implicits._

    utilFun = LogicUtils(spark)

    val actual: Seq[DependencyLibraries] =
      utilFun
        .convertSeq2Ds[DependencyLibraries](sampleDt, columnNames)
        .collect()
        .toSeq

    val expected: Seq[DependencyLibraries] = sampleDS
    assert(expected, actual)

  }
}
