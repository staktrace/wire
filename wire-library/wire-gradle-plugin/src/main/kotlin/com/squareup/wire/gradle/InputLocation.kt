package com.squareup.wire.gradle

import com.squareup.wire.internal.Serializable
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity

data class InputLocation(
  /** The base of this location; typically a directory or .jar file. */
  @get:PathSensitive(PathSensitivity.RELATIVE)
  val base: String,

  /** The path to this location relative to [base]. */
  @get:PathSensitive(PathSensitivity.RELATIVE)
  val path: String,
) : Serializable {
  companion object {
    @JvmStatic
    fun get(path: String): InputLocation {
      return get("", path)
    }

    @JvmStatic
    fun get(
      base: String,
      path: String
    ): InputLocation {
      return InputLocation(base.trimEnd('/'), path)
    }
  }
}
