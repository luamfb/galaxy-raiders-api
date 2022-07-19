@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return Point2D(x + p.x, y + p.y)
  }

  operator fun plus(v: Vector2D): Point2D {
    return Point2D(x + v.dx, y + v.dy)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(x, y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(abs(x - p.x), abs(y - p.y))
  }

  fun impactDirection(p: Point2D): Vector2D {
    return INVALID_VECTOR
  }

  fun contactVector(p: Point2D): Vector2D {
    return impactVector(p).normal
  }

  fun contactDirection(p: Point2D): Vector2D {
    return INVALID_VECTOR
  }

  fun distance(p: Point2D): Double {
    val deltaX = x - p.x
    val deltaY = y - p.y
    return sqrt(deltaX.pow(2) + deltaY.pow(2))
  }
}
