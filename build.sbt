name := "factdb2"

version := "0.1"

scalaVersion := "2.12.10"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

val akkaVersion = "2.6.0"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "com.google.guava" % "guava" % "27.1-jre",
  "org.apache.commons" % "commons-lang3" % "3.8.1",

  "org.scala-lang.modules" %% "scala-collection-compat" % "2.0.0",

  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",

  "org.scala-lang.modules" %% "scala-collection-compat" % "2.0.0",
  "org.scala-lang.modules" % "scala-java8-compat_2.12" % "0.9.0",
  //"com.yugabyte" % "cassandra-driver-core" % "3.2.0-yb-19"
  "com.datastax.cassandra" % "cassandra-driver-core" % "3.7.2",

  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion

  /*"com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
  "com.typesafe.akka" %% "akka-distributed-data" % akkaVersion*/
)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)