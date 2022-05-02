import Dependencies._

ThisBuild / organization := "io.github.sdev.mpf"
ThisBuild / scalaVersion := "3.1.2"

lazy val budget = (project in file("budget"))
  .settings(
    name := "budget",
    libraryDependencies ++= Seq(
      catsEffect,
      catsEffectKernel,
      catsEffectStd,
      catsEffectTestingSpecs2 % Test,
      munitCatsEffect3        % Test
    )
  )

lazy val expenses = (project in file("expenses"))
  .settings(
    name := "expenses",
    libraryDependencies ++= Seq(
      catsEffect,
      catsEffectKernel,
      catsEffectStd,
      catsEffectTestingSpecs2 % Test,
      munitCatsEffect3        % Test
    )
  )

lazy val balance = (project in file("balance"))
  .settings(
    name := "balance",
    libraryDependencies ++= Seq(
      catsEffect,
      catsEffectKernel,
      catsEffectStd,
      catsEffectTestingSpecs2 % Test,
      munitCatsEffect3        % Test
    )
  )
