package io.ufomelkor.hoa.compiler.plugin.highlight

class HighlightRuleCallsTest : AnnotationHighlightingTestCase() {

    fun `test it should highlight a rule call as RULE_CALL`()
        = checkHighlightingOfElementByText("""
            %token true true
            %token false false
            boolean: <true> | <false> 
            booleans: boolean()+
            """.trimIndent(), PpSyntaxHighlighter.RULE_CALL,"boolean()")
}
