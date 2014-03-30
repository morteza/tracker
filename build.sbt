import play.Project._

// organization := "ratnic"

name := "ratnic.tracker"

version := "2.0-SNAPSHOT"

libraryDependencies ++= Seq(javaJdbc, javaEbean, cache)

//postgres driver
//libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"   

playJavaSettings
