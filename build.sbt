import play.Project._

organization := "com.ratnic"

name := "tracker"

version := "2.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

playJavaSettings
