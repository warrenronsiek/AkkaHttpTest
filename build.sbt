lazy val akkaHttpVersion = "10.1.8"
lazy val akkaVersion    = "2.6.0-M3"

name := "akka-http-docker-test"
packageName in Docker := "akka-http-docker-test"
dockerExposedPorts := Seq(5000)
mainClass in Compile := Some("com.example.QuickstartServer")


lazy val root = (project in file(".")).enablePlugins(JavaAppPackaging).enablePlugins(DockerPlugin).
  settings(
    inThisBuild(List(
      organization    := "com.example",
      scalaVersion    := "2.12.7"
    )),
    name := "AkkaHttpTest",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"            % "3.0.5"         % Test
    )
  )
