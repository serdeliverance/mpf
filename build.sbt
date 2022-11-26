import Dependencies._

ThisBuild / organization := "io.github.sdev.mpf"
ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "mpf",
    libraryDependencies ++= Seq(
      catsEffect,
      catsEffectKernel,
      catsEffectStd,
      skunk,
      flyway,
      catsEffectTestingSpecs2 % Test,
      munitCatsEffect3        % Test
    )
  )

