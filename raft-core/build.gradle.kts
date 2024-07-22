plugins {
    id("java-library-conventions")
}

dependencies {
    implementation(libs.slf4j)
    implementation(libs.logback)
    compileOnly("org.projectlombok:lombok:${libs.versions.lombokVersion.get()}")
    annotationProcessor("org.projectlombok:lombok:${libs.versions.lombokVersion.get()}")
}
