package dependencies

import org.gradle.api.JavaVersion

object Dep {

    object GradlePlugin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        const val grpc = "com.google.protobuf:protobuf-gradle-plugin:0.8.15"
    }

    object Kotlin {
        const val version = "1.4.30"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val common = "org.jetbrains.kotlin:kotlin-stdlib-common:$version"

        object Coroutines {
            private const val version = "1.4.2"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Java {
        val version = JavaVersion.VERSION_11
    }

    object GCP {
        const val bom = "com.google.cloud:libraries-bom:16.4.0"
        const val core = "com.google.cloud:google-cloud-core"
        const val firestore = "com.google.cloud:google-cloud-firestore"
        const val gcs = "com.google.cloud:google-cloud-storage"
    }

    object Grpc {
        private const val version = "1.36.0"
        const val netty = "io.grpc:grpc-netty-shaded:$version"
        const val protobuf = "io.grpc:grpc-protobuf:$version"
        const val stub = "io.grpc:grpc-stub:$version"

        object CompileOnly {
            const val tomcatAnn = "org.apache.tomcat:annotations-api:6.0.53"
        }
    }

    object DI {
        const val kodein = "org.kodein.di:kodein-di:7.4.0"
    }

    object Server {
        const val netty = "io.netty:netty-all:4.1.60.Final"
    }

}
