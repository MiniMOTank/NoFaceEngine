name := "NoFaceEngine"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "io.reactivex" %% "rxscala" % "0.26.1",
  "net.liftweb" %% "lift-json" % "3.0-M8"
)

exportJars := true

unmanagedBase :=  baseDirectory.value / "mylib"
