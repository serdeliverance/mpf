import sbt._

object Dependencies {

  object V {
    val catsEffect              = "3.3.11"
    val catsEffectTestingSpecs2 = "1.4.0"
    val munitCatsEffect3        = "1.0.7"
    val skunk = "0.2.3"
    val flyway = "9.8.1"
    val http4s = "0.23.1"

    val organizeImports = "0.6.0"

    val postgres = "42.2.18"
    val logback = "1.2.6"
    val log4cats = "2.2.0"
  }

  val catsEffect              = "org.typelevel"        %% "cats-effect"                % V.catsEffect
  val catsEffectKernel        = "org.typelevel"        %% "cats-effect-kernel"         % V.catsEffect
  val catsEffectStd           = "org.typelevel"        %% "cats-effect-std"            % V.catsEffect
  val catsEffectTestingSpecs2 = "org.typelevel"        %% "cats-effect-testing-specs2" % V.catsEffectTestingSpecs2
  val munitCatsEffect3        = "org.typelevel"        %% "munit-cats-effect-3"        % V.munitCatsEffect3
  val organizeImports         = "com.github.liancheng" %% "organize-imports"           % V.organizeImports
  val http4sDsl = "org.http4s" %% "http4s-dsl" % V.http4s
  val http4sEmberServer =  "org.http4s" %% "http4s-ember-server" % V.http4s
  val http4sCirce = "org.http4s" %% "http4s-circe" % V.http4s

  val skunk = "org.tpolecat" %% "skunk-core" % V.skunk
  val flyway =  "org.flywaydb" % "flyway-core" % V.flyway
  val postgres = "org.postgresql" % "postgresql" % V.postgres
  val logback = "ch.qos.logback" % "logback-classic" % V.logback
  val log4cats = "org.typelevel" %% "log4cats-slf4j" % V.log4cats
}
