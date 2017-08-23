enablePlugins(ScalaJSPlugin)

name := "jstest"

version := "0.1"

scalaVersion := "2.12.3"

scalaJSUseMainModuleInitializer := true

libraryDependencies ++= Seq(
  "be.doeraene" %%% "scalajs-jquery" % "0.9.1",
  "io.monix" %%% "monix" % "2.3.0"
)

skip in packageJSDependencies := false
jsDependencies +=
  "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"