package io.ufomelkor.hoa.compiler.plugin.annotator

class EnsureCompleteRuleTest : AnnotatorTestCase() {

    fun `test it should not annotate a rule name if a colon follows`()
        = checkErrors("""
%token  true    true
%token  false   false

value:
    <true> | <false>
        """.trimIndent())

    fun `test it should annotate a rule name with an error if no colon follows`()
        = checkErrors("""
%token  true    true
%token  false   false

valu<error descr="Expected colon">e</error>
    <true> | <false>
            """.trimIndent())

    fun `test it should not annotate rule name call`() = checkErrors("""
%token  true    true
%token  false   false

boolean: <true> | <false>
type: boolean()
    """.trimIndent())

    fun `test it should annotate a rule call without parentheses with an error`() = checkErrors("""
%token  true    true
%token  false   false

boolean: <true> | <false>
type: <error descr="Invalid rule call, missing ()">boolean</error>
    """.trimIndent())

    fun `test it should annotate a rule without content with an error`() = checkErrors("""
<error descr="Empty rules are not allowed">type:</error>
    """.trimIndent())
}
