// Comment to get more information during initialization
//logLevel := Level.Warn

val ScalaJSVersion = Option(System.getenv("SCALAJS_VERSION")).getOrElse("1.0.0")

// Resolvers
//resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// Sbt plugins
addSbtPlugin("com.vmunier"        % "sbt-web-scalajs"           % "1.0.11")
addSbtPlugin("org.scala-js"       % "sbt-scalajs"               % ScalaJSVersion)
addSbtPlugin("com.typesafe.play"  % "sbt-plugin"                % "2.8.1")
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject"  % "1.0.0")
addSbtPlugin("com.typesafe.sbt"   % "sbt-gzip"                  % "1.0.2")
addSbtPlugin("com.typesafe.sbt"   % "sbt-digest"                % "1.1.4")
addSbtPlugin("net.virtual-void"   % "sbt-dependency-graph"      % "0.10.0-RC1")
