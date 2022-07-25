package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D

const val EXPLOSION_DURATION = 4

class Explosion(initialPosition: Point2D, radius: Double) :
  SpaceObject("Explosion", '*', initialPosition, Vector2D(0.0, 0.0), radius, 0.0) {
  var countdown: Int = EXPLOSION_DURATION

  fun decreaseCountdown() {
    countdown -= 1
  }
}
