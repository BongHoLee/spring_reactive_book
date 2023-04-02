dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("com.github.jasync-sql:jasync-r2dbc-mysql:2.1.21")

    // mongo
    implementation("org.mongodb:mongodb-driver-sync")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("de.flapdoodle.embed:de.flapddodle.embed.mongo")

    // thymleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}
