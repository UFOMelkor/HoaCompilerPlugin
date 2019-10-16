package io.ufomelkor.hoa.compiler.plugin.highlight

class HighlightTokensTest : AnnotationHighlightingTestCase() {

    fun `test it should highlight a kept token KEPT_TOKEN`()
        = checkHighlightingOfElementByText("""
            %token boolean true|false
            type: <boolean>
            """.trimIndent(), PpSyntaxHighlighter.KEPT_TOKEN,"boolean")

    fun `test it should highlight a skipped token SKIPPED_TOKEN`()
        = checkHighlightingOfElementByText("""
            %token boolean true|false
            type: ::boolean::
            """.trimIndent(), PpSyntaxHighlighter.SKIPPED_TOKEN,"boolean")

    fun `test it should highlight a token name as TOKEN_NAME`()
        = checkHighlightingOfElementByText("%token op:string_ \"", PpSyntaxHighlighter.TOKEN_NAME, "string_")

    fun `test it should highlight a skip name as SKIP_NAME`()
        = checkHighlightingOfElementByText("%skip op:space \\s", PpSyntaxHighlighter.SKIP_NAME, "space")
}
