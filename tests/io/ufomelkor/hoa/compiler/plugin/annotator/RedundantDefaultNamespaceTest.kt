package io.ufomelkor.hoa.compiler.plugin.annotator

class RedundantDefaultNamespaceTest : AnnotatorTestCase() {
    fun `test it should mark a namespace switch to the current namespace as weak warning`() =
        checkWarnings("""
            %token <weak_warning descr="default namespace can be omitted">default</weak_warning>:op =
        """.trimIndent())
}
