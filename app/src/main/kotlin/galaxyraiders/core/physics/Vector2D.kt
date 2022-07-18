@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sign
import kotlin.math.sqrt

@JsonIgnoreProperties("unit", "normal", "degree", "magnitude")
data class Vector2D(val dx: Double, val dy: Double) {
  override fun toString(): String {
    return "Vector2D(dx=$dx, dy=$dy)"
  }

  val magnitude: Double
    get() = sqrt(dx.pow(2) + dy.pow(2))

  val radiant: Double
    get() {
      // Calculates angle between this vector and the positive x semi-axis.
      val unitEndpoint = Point2D(unit.dx, unit.dy)
      val angleSign = sign(unit.dy)
      // This formula is obtained from the law of cosines, applied to
      // the triangle formed by points (0, 0), (1, 0) and unitEndpoint.
      val largestSize = unitEndpoint.distance(Point2D(1.0, 0.0))
      return angleSign * acos(1 - largestSize.pow(2) / 2.0)
    }

  val degree: Double
    get() = INVALID_DOUBLE

  val unit: Vector2D
    get() = this / this.magnitude

  val normal: Vector2D
    get() = INVALID_VECTOR

  operator fun times(scalar: Double): Vector2D {
    return Vector2D(dx * scalar, dy * scalar)
  }

  operator fun div(scalar: Double): Vector2D {
    return Vector2D(dx / scalar, dy / scalar)
  }

  operator fun times(v: Vector2D): Double {
    return dx * v.dx + dy * v.dy
  }

  operator fun plus(v: Vector2D): Vector2D {
    return Vector2D(dx + v.dx, dy + v.dy)
  }

  operator fun plus(p: Point2D): Point2D {
    return Point2D(dx + p.x, dy + p.y)
  }

  operator fun unaryMinus(): Vector2D {
    return Vector2D(-dx, -dy)
  }

  operator fun minus(v: Vector2D): Vector2D {
    return Vector2D(dx - v.dx, dy - v.dy)
  }

  fun scalarProject(target: Vector2D): Double {
    return INVALID_DOUBLE
  }

  fun vectorProject(target: Vector2D): Vector2D {
    return INVALID_VECTOR
  }
}

operator fun Double.times(v: Vector2D): Vector2D {
  return v * this
}
