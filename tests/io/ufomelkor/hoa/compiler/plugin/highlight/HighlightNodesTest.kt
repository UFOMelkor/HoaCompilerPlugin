package io.ufomelkor.hoa.compiler.plugin.highlight

class HighlightNodesTest : AnnotationHighlightingTestCase() {

    fun `test it should highlight a node rule as NODE`()
        = checkHighlightingOfElementByText("""
            %token true true
            %token false false
            #boolean: <true> | <false>
            """.trimIndent(), PpSyntaxHighlighter.NODE,"#boolean")

    fun `test it should highlight an inline node as NODE`()
        = checkHighlightingOfElementByText("""
%token true true
%token false false

boolean:
    <true> | <false>

booleans:
    boolean() (boolean()+ #booleans)?
        """.trimIndent(), PpSyntaxHighlighter.NODE, "#booleans")
}
