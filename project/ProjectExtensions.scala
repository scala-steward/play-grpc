package build.play.grpc

import sbt._
import sbt.Keys._

import akka.grpc.sbt.AkkaGrpcPlugin.autoImport._

// helper to define projects that test the plugin infrastructure
object ProjectExtensions {
  implicit class AddPluginTest(project: Project) {

    /** Add settings to test the sbt-plugin in-process */
    def pluginTestingSettings: Project =
      project
        .settings(
          libraryDependencies += Dependencies.Compile.akkaGrpcRuntime,
        )
        .enablePlugins(ReflectiveCodeGen)
        .settings(
          // Defaults to `Seq("Scala")` so we only need to add Java
          ReflectiveCodeGen.generatedLanguages += AkkaGrpc.Java,
          ReflectiveCodeGen.codeGeneratorSettings -= "flat_package", // avoid Java+Scala fqcn conflicts
        )
  }
}
