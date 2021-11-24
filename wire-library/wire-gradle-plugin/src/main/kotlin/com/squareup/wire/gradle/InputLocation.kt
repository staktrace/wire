package com.squareup.wire.gradle

import com.squareup.wire.internal.Serializable
import com.squareup.wire.schema.Location
import org.gradle.api.Project
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import java.io.File

data class InputLocation(
  /** The base of this location; typically a directory or .jar file. */
  @get:PathSensitive(PathSensitivity.RELATIVE)
  val base: String,

  /** The path to this location relative to [base]. */
  @get:PathSensitive(PathSensitivity.RELATIVE)
  val path: String,
) : Serializable {
  fun resolveWith(projectDir: File): Location {
    if (base.isEmpty()) {
      return Location.get(projectDir.resolve(path).absolutePath)
    } else {
      return Location.get(projectDir.resolve(base).absolutePath, path)
    }
  }

  companion object {
    @JvmStatic
    fun get(project: Project, path: String): InputLocation {
      return InputLocation("", project.relativePath(path))
    }

    @JvmStatic
    fun get(
      project: Project,
      base: String,
      path: String
    ): InputLocation {
      return InputLocation(project.relativePath(base).trimEnd('/'), path)
    }
  }
}
