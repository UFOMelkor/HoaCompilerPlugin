package io.ufomelkor.hoa.compiler.plugin.annotator

class RuleMissesColonTest : AnnotatorTestCase() {

    fun `test if a colon follows the rule name everything is ok`()
        = checkErrors("""
%token  true    true
%token  false   false

value:
    <true> | <false>
        """.trimIndent())

    fun `test after the name of the rule a colon must follow`()
        = checkErrors("""
%token  true    true
%token  false   false

valu<error descr="Expected colon">e</error>
    <true> | <false>
            """.trimIndent())
}
