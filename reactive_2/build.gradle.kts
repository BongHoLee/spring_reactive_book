dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("com.github.jasync-sql:jasync-r2dbc-mysql:2.1.21")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("mysql:mysql-connector-java")
    implementation("org.hibernate:hibernate-core:5.4.9.Final")

    // mongo
//    implementation("org.mongodb:mongodb-driver-sync")
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
//    implementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")

    // thymleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}
