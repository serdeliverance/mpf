import Dependencies._

ThisBuild / organization := "io.github.sdev.mpf"
ThisBuild / scalaVersion := "3.1.2"

lazy val budget = (project in file("budget"))
  .settings(
    name := "budget"
  )

lazy val expenses = (project in file("expenses"))
  .settings(
    name := "expenses"
  )

lazy val balance = (project in file("balance"))
  .settings(
    name := "balance"
  )

lazy val account = (project in file("account"))
  .settings(
    name := "account",
    libraryDependencies ++= Seq(
      catsCore,
      catsEffect,
      catsEffectKernel,
      catsEffectStd,
      catsEffectTestingSpecs2 % Test,
      munitCatsEffect3        % Test
    )
  )
