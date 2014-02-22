import play.Project._

// organization := "ratnic"

name := "ratnic.tracker"

version := "2.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

playJavaSettings
