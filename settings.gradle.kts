pluginManagement {
    // Include 'plugins build' to define convention plugins.
    includeBuild("build-plugin")
}

plugins {
    // Apply plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

include("raft-core", "raft-protocol")

rootProject.name = "raft-in-meow"
