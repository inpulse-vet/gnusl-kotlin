plugins {

}

/*
library {
    val basePath = rootProject.file("gsl")
    val modules = listOf(
        "vector"
    )
    for (module in modules) {
        val sources = basePath.resolve(module).listFiles()?.filter { it.extension == "c" }?.toList()
        println(sources)
        source.from(sources)
        privateHeaders.from(basePath.resolve(module))
        publicHeaders.from(basePath.resolve(module))
    }
}
*/
