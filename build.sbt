import Dependencies._

ThisBuild / organization := "io.github.sdev.mpf"
ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    name := "mpf",
    Defaults.itSettings,
    libraryDependencies ++= Seq(
      catsEffect,
      catsEffectKernel,
      catsEffectStd,
      http4sDsl,
      http4sEmberServer,
      http4sCirce,
      circeGeneric,
      skunk,
      skunkCirce,
      flyway,
      postgres,
      logback,
      log4cats,
      catsEffectTestingSpecs2 % "it,test",
      munitCatsEffect3        % Test
    )
  )
