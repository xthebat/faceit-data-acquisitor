val kotlinExtensionsVersion: String by project

dependencies {
    api("com.github.inforion.common", "krest", kotlinExtensionsVersion)
    api("com.github.inforion.common", "uuid", kotlinExtensionsVersion)
    api("com.github.inforion.common", "extensions", kotlinExtensionsVersion)
}