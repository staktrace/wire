import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
  id("java-library")
  kotlin("jvm")
  id("com.google.protobuf")
}

val jar by tasks.getting(Jar::class) {
  manifest {
    attributes("Automatic-Module-Name" to "wire-test-utils")
  }
}

protobuf {
  protoc {
    artifact = deps.protobuf.protoc
  }
}

dependencies {
  api(deps.moshi)
  api(project(":wire-runtime"))
  api(project(":wire-schema"))
  implementation(project(":wire-compiler"))
  implementation(project(":wire-java-generator"))
  implementation(project(":wire-kotlin-generator"))
  implementation(project(":wire-profiles"))
  implementation(deps.assertj)
  implementation(deps.guava)
  implementation(deps.jimfs)
  implementation(deps.junit)
  implementation(deps.protobuf.java)
  implementation(deps.okio.jvm)
  implementation(deps.okio.fakefilesystem)
}
