package io.ufomelkor.hoa.compiler.plugin.annotator

class RedundantNamespaceSwitchTest : AnnotatorTestCase() {
    fun `test it should mark a namespace switch to the current namespace as weak warning`()
        = checkWarnings("""
            %token string:content [^"]  <weak_warning descr="namespace does not change">-> string</weak_warning>
        """.trimIndent())
}
