package com.gability.scala

import com.holdenkarau.spark.testing.{DataFrameSuiteBase, DatasetSuiteBase, SparkSessionProvider}
import org.apache.spark.sql.{DataFrame, Dataset, Row}
import org.scalatest._
import org.scalatest.matchers.should.Matchers

class MainTest extends FunSuite with Matchers with DataFrameSuiteBase {
  test("Testing prepare data logic ") {
    val spark = SparkSessionProvider._sparkSession
    import spark.implicits._


    val actual: Dataset[Row] = Main.convertSeq2Df(Seq(("scala", "2.11.12"), ("spark", "2.4.5")))
    actual.show()
    val expected: Dataset[Row] = Seq(("scala", "2.11.12"), ("spark", "2.4.5")).toDF("lib", "version")
    expected.show()
    assertDataFrameEquals(expected, actual)
  }
}
