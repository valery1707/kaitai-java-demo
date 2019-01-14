plugins {
	java
	id("nebula.kotlin") version "1.3.11"
	id("name.valery1707.kaitai") version "0.1.0"
}

repositories {
	jcenter()
}

val libJunitVersion = "5.3.2"

dependencies {
	implementation("io.kaitai:kaitai-struct-runtime:0.8")

	testImplementation("org.junit.jupiter:junit-jupiter-api:$libJunitVersion")
	testImplementation("org.junit.jupiter:junit-jupiter-params:$libJunitVersion")
	testRuntime("org.junit.jupiter:junit-jupiter-engine:$libJunitVersion")
	testImplementation("org.assertj:assertj-core:2.9.0")
}

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

//todo Use more useful name
configure<name.valery1707.kaitai.GenerateConfig> {
	packageName = "name.valery1707.kaitai.demo"
}

tasks.withType<Test> {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}
