import sbt._

object Dependencies {

  object V {
    val cats                    = "2.7.0"
    val catsEffect              = "3.3.11"
    val catsEffectTestingSpecs2 = "1.4.0"
    val munitCatsEffect3        = "1.0.7"
    val scalatest               = "3.2.11"

    val organizeImports = "0.6.0"
  }

  val catsCore                = "org.typelevel"        %% "cats-core"                  % V.cats
  val catsEffect              = "org.typelevel"        %% "cats-effect"                % V.catsEffect
  val catsEffectKernel        = "org.typelevel"        %% "cats-effect-kernel"         % V.catsEffect
  val catsEffectStd           = "org.typelevel"        %% "cats-effect-std"            % V.catsEffect
  val catsEffectTestingSpecs2 = "org.typelevel"        %% "cats-effect-testing-specs2" % V.catsEffectTestingSpecs2
  val munitCatsEffect3        = "org.typelevel"        %% "munit-cats-effect-3"        % V.munitCatsEffect3
  val scalatic                = "org.scalactic"        %% "scalactic"                  % V.scalatest
  val scalatest               = "org.scalatest"        %% "scalatest"                  % V.scalatest
  val organizeImports         = "com.github.liancheng" %% "organize-imports"           % V.organizeImports
}
