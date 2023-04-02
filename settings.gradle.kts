rootProject.name = "spring_reactive_book"
pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
		gradlePluginPortal()
	}
}

include("r2dbc_example")
include("reactive_1")
include("reactive_2")

