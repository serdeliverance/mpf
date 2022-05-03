import Dependencies._

ThisBuild / organization := "io.github.sdev.mpf"
ThisBuild / scalaVersion := "3.1.2"

lazy val account = (project in file("account"))
  .settings(
    name := "account",
    libraryDependencies ++= Seq(
      catsCore,
      catsEffect,
      catsEffectKernel,
      catsEffectStd,
      scalatic,
      scalatest               % Test,
      catsEffectTestingSpecs2 % Test,
      munitCatsEffect3        % Test
    )
  )

lazy val balance = (project in file("balance"))
  .settings(
    name := "balance"
  )

lazy val budget = (project in file("budget"))
  .settings(
    name := "budget",
    libraryDependencies ++= Seq(
      catsEffect,
      catsEffectTestingSpecs2 % Test,
      munitCatsEffect3        % Test
    )
  )

lazy val expenses = (project in file("expenses"))
  .settings(
    name := "expenses",
    libraryDependencies ++= Seq(
      catsEffect,
      catsEffectTestingSpecs2 % Test,
      munitCatsEffect3        % Test
    )
  )
