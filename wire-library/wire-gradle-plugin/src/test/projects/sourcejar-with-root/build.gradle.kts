plugins {
  kotlin("jvm") version "1.5.21"
  id("com.squareup.wire")
}

wire {
  sourcePath {
    srcJar("src/main/proto/protos.jar")
  }

  root("squareup.geology.Period")

  kotlin {
  }
}
