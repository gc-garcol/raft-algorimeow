plugins {
    id("java-application-conventions")
}

dependencies {
    implementation(libs.slf4j)
    implementation(libs.logback)
    implementation(project(":raft-core"))
}
