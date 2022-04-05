import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.dokka") version "1.4.0"
}

val jvmTestsOptions: String by project

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}


subprojects
    .filter { it.childProjects.isEmpty() }
    .forEach {
        it.beforeEvaluate {
            apply(plugin = "org.jetbrains.kotlin.jvm")
            apply(plugin = "org.jetbrains.dokka")

            repositories {
                mavenLocal()
                mavenCentral()
                maven { url = uri("https://jitpack.io") }
            }

            group = "com.github.mblw.faceit"
            version = "0.1.0"
        }

        it.afterEvaluate {
            tasks {

                withType<Test>().all {
                    jvmArgs!!.plusAssign(jvmTestsOptions.split(" "))

                    testLogging {
                        events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)

                        showExceptions = true
                        exceptionFormat = TestExceptionFormat.FULL
                        showCauses = true
                        showStackTraces = true
                        // showStandardStreams = false
                    }
                }

                withType<KotlinCompile> {
                    kotlinOptions.jvmTarget = "11"
                    kotlinOptions.freeCompilerArgs += listOf("-Xopt-in=kotlin.ExperimentalUnsignedTypes")
                }

                if (findByName("sourcesJar") == null) {
                    val sourcesJar by creating(Jar::class) {
                        dependsOn("classes")
                        classifier = "sources"
                        from(sourceSets["main"].allSource)
                    }
                }

                if (findByName("dokkaJar") == null) {
                    val dokkaJar by creating(Jar::class) {
                        dependsOn("dokkaJavadoc")
                        classifier = "javadoc"
                        from("dokkaJavadoc")
                    }
                }
            }

            val junitVersion: String by project

            dependencies {
                api("org.jetbrains.kotlin:kotlin-stdlib")
                api("org.jetbrains.kotlin:kotlin-reflect")
                api("org.jetbrains.kotlin:kotlin-test")

                testImplementation("junit:junit:$junitVersion")
            }
        }
    }