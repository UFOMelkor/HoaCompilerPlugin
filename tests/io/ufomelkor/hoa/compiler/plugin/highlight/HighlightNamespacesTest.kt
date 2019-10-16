package io.ufomelkor.hoa.compiler.plugin.highlight

class HighlightNamespacesTest : AnnotationHighlightingTestCase() {
    fun `test it should highlight the current namespaces of skips as NAMESPACE`()
        = checkHighlightingOfElementByText("%skip op:space \\s", PpSyntaxHighlighter.NAMESPACE, "op")

    fun `test it should highlight the current namespaces of tokens as NAMESPACE`()
        = checkHighlightingOfElementByText("%token op:space \\s", PpSyntaxHighlighter.NAMESPACE, "op")

    fun `test it should highlight the next namespaces of tokens as NAMESPACE`()
        = checkHighlightingOfElementByText("%token string_ \" -> string", PpSyntaxHighlighter.NAMESPACE, "string")
}
