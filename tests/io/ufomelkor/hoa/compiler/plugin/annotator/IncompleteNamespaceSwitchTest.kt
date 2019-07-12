package io.ufomelkor.hoa.compiler.plugin.annotator

class IncompleteNamespaceSwitchTest : AnnotatorTestCase() {
    fun `test namespace switch without namespace should be annotated as error`()
        = checkErrors("%token quote_ \" <error descr=\"Expected namespace\">-> </error>")

    fun `test it does not annotate a full switch`()
        = checkErrors("%token quote_ \" -> quote")
}
