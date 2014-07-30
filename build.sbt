name := "tracker"

version := "2.1.0-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(javaJdbc, javaEbean, cache, javaWs)

//postgres driver
//libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"   

lazy val root = (project in file(".")).enablePlugins(PlayJava)

