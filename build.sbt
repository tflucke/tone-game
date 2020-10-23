scalaVersion := "2.11.12"
val ScalaJSVersion = Option(System.getenv("SCALAJS_VERSION")).getOrElse("1.0.0")

import DebianConstants._

lazy val server: Project = (project in file("server"))
  .settings(commonSettings)
  .settings(
    scalaJSProjects := Seq(client),
    pipelineStages in Assets := Seq(scalaJSPipeline),
    pipelineStages := Seq(digest, gzip),
    // triggers scalaJSPipeline when using compile or continuous compilation
    compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value,
    libraryDependencies ++= Seq(
      // Integrate compiled JS files to HTML
      // Wiki: https://index.scala-lang.org/vmunier/scalajs-scripts/scalajs-scripts/1.1.4
      "com.vmunier" %% "scalajs-scripts" % "1.1.4",
      // Dependency Injection Module
      // Wiki: https://github.com/google/guice/wiki
      guice,
      specs2 % Test,
      // Unit Test Framework
      // Wiki: https://www.playframework.com/documentation/2.8.x/ScalaTestingWithScalaTest
      //"org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      // Automatically set references for webjars assets
      // Wiki: https://www.webjars.org/documentation
      "org.webjars" %% "webjars-play" % "2.8.0",
      // Simplifies JS usage and browser cross-compatibility
      // Wiki: https://api.jquery.com/
      "org.webjars" % "jquery" % "3.4.1",
      // Clean, cross-platform CSS sheet
      // Wiki: https://getbootstrap.com/docs/4.4/getting-started/introduction/
      "org.webjars" % "bootstrap" % "4.4.1-1",
      // Enable database integration
      jdbc,
      // Enable database evolution tracking
      // Docs: https://www.playframework.com/documentation/2.8.x/Evolutions#Managing-database-evolutions
      evolutions,
      // SQL ORM
      // Wiki: https://www.squeryl.org/docs/0.9.5/getting-started.html
      // Scaladocs: https://www.squeryl.org/docs/0.9.5/api/index.html#package
      //"org.squeryl" %% "squeryl" % "0.9.14",
      // QUILL ORM
      // Docs: https://index.scala-lang.org/fwbrasil/quill/quill-async/0.7.0
      // Scaladoc: https://www.javadoc.io/static/io.getquill/quill-jdbc_2.13/3.5.0/io/index.html
      "io.getquill" %% "quill-jdbc" % "3.5.1",
      "io.getquill" %% "quill-async-postgres" % "3.5.1",
      // Postgres Driver
      "org.postgresql" % "postgresql" % "42.2.11"
    )
  )
  .enablePlugins(SystemdPlugin)
  .settings(distributionSettings)
  .enablePlugins(PlayScala)
  .dependsOn(sharedJvm)

import com.tflucke.webroutes.endpoints.PlayEndpointFile

lazy val client = (project in file("client"))
  .settings(commonSettings)
  .settings(
    Compile / apiDefinitions += PlayEndpointFile(server),
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      // Wrapper library for JS dom to scala
      // Docs: https://scala-js.github.io/scala-js-dom/
      // Scaladocs: https://www.javadoc.io/doc/org.scala-js/scalajs-dom_sjs1.0.0-M7_2.12/0.9.6/org/scalajs/dom/index.html
      (if (ScalaJSVersion.startsWith("0.6.")) "org.scala-js" %%% "scalajs-dom" % "0.9.8"
       else                                   "org.scala-js" %%% "scalajs-dom" % "1.0.0"),
      // Wrapper class for jquery to scala
      // Docs: https://index.scala-lang.org/exoego/scala-js-jquery/scalajs-jquery2/1.0.0
      // Scaladoc: https://www.javadoc.io/doc/net.exoego/scalajs-jquery3_sjs0.6_2.12/0.9.6/index.html
      "net.exoego" %%% "scalajs-jquery3" % "1.0.0",
      // Json Parsing
      // Wiki:
      (if (ScalaJSVersion.startsWith("0.6.")) "com.typesafe.play" %%% "play-json" % "2.8.1"
       else                                   "com.typesafe.play" %%% "play-json" % "2.9.0"),
      // Easy DOM creation/manipulation
      // Wiki: https://www.lihaoyi.com/scalatags/
      // Scaladoc: https://www.lihaoyi.com/scalatags/api/index.html
      //"com.lihaoyi" %%% "scalatags" % "0.8.6"
    ),
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSWeb, RestRPC)
  .dependsOn(sharedJs)

lazy val shared = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("shared"))
  .settings(commonSettings)
  .jsConfigure(_ enablePlugins ScalaJSWeb)
lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

lazy val commonSettings = Seq(
  //scalaVersion := "2.13.1",
  organization := "name.tflucke",
  version      := "0.1.0",
  maintainer := "Thomas Flucke <admin@tflucke.name>",
  libraryDependencies ++= Seq(
    // Json Parsing
    // Wiki:
    "com.typesafe.play" %% "play-json" % "2.8.1"
  ),
  scalacOptions += "-target:jvm-1.8",
  javacOptions ++= Seq("-source", "1.7", "-target", "1.7"),
)

lazy val distributionSettings = Seq(
  name in Universal := """tone-game""",
  packageName := s"${(Universal/name).value}",
  packageSummary := "Game to practice learning Vietnamese pronunciations.",
  packageDescription := "Game to practice learning Vietnamese pronunciations.",
  debianPackageDependencies := Seq("java8-runtime-headless", "postgresql"),
  maintainerScripts in Debian := maintainerScriptsAppend((maintainerScripts in Debian).value)(
    Postinst -> IO.read(((baseDirectory) apply (_ / "install" / "debian" / "postinst")).value)
  ),
  javaOptions in Universal ++= Seq(
    // Use run for PID file
    s"-Dpidfile.path=/run/${packageName.value}/play.pid",
    // Use separate configuration file for production environment
    s"-Dconfig.file=/usr/share/${packageName.value}/conf/production.conf",
    // You may also want to include this setting if you use play evolutions
    "-Dplay.evolutions.db.default.autoApply=true",
    ""
  ),
  // TODO: This doesn't seem to apply for some reason
  requiredStartFacilities := Some("network.target postgresql.service")
)

// loads the server project at sbt startup
onLoad in Global := (onLoad in Global).value.andThen(
  state => "project server" :: state
)
