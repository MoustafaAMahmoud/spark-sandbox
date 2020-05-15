package com.gability.scala

object TestingUtils {
  final case class DependencyLibraries(libName: String, libVersion: String)
  val sampleDt = Seq(("scala", "2.11.12"), ("spark", "2.4.5"))
  val sampleDS = Seq(DependencyLibraries("scala", "2.11.12"),
                     DependencyLibraries("spark", "2.4.5"))
  val columnNames = Seq("libName", "libVersion")
}
