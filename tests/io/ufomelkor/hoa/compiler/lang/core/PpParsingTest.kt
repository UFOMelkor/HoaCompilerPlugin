package io.ufomelkor.hoa.compiler.lang.core

import com.intellij.testFramework.ParsingTestCase
import io.ufomelkor.hoa.compiler.lang.core.parser.PpParserDefinition

class PpParsingTest : ParsingTestCase("", "pp", PpParserDefinition()) {
    fun testComment() = doTest(true)

    fun testSkip() = doTest(true)

    fun testSkipNs() = doTest(true)

    fun testToken() = doTest(true)

    fun testTokenNs() = doTest(true)

    fun testRuleAtLeast() = doTest(true)

    fun testRuleAtMost() = doTest(true)

    fun testRuleBetween() = doTest(true)

    fun testRuleChoice() = doTest(true)

    fun testRuleGroup() = doTest(true)

    fun testRuleNamedNode() = doTest(true)

    fun testRuleOneOrMore() = doTest(true)

    fun testRuleOptional() = doTest(true)

    fun testRuleRule() = doTest(true)

    fun testRuleToken() = doTest(true)

    fun testRuleTokenInvisible() = doTest(true)

    fun testRuleUnification() = doTest(true)

    fun testRuleZeroOrMore() = doTest(true)

    fun testTwoRules() = doTest(true)

    fun testRuleWithComment() = doTest(true)

    fun testJsonLexemes() = doTest(true)

    fun testJsonRules() = doTest(true)

    fun testJson() = doTest(true)

    fun testLongRegexp() = doTest(true)

    fun testESwitchNamespaceMissingName() = doTest(true)

    fun testETokenKeyword() = doTest(true)

    fun testETokenName() = doTest(true)

    fun testETokenColonName() = doTest(true)

    fun testETokenNamespace() = doTest(true)

    fun testESkipKeyword() = doTest(true)

    fun testESkipName() = doTest(true)

    fun testESkipNamespace() = doTest(true)

    fun testECommentMissingSlash() = doTest(true)

    fun testECommentMissingSlashBetweenRules() = doTest(true)

    fun testERuleCallMissingClosingParenthesis() = doTest(true)

    fun testERuleCallMissingOpeningParenthesis() = doTest(true)

    fun testERuleMissingColon() = doTest(true)

    fun testERuleStartingPipe() = doTest(true)

    fun testERuleTrailingPipe() = doTest(true)

    fun testERuleEmpty() = doTest(true)

    fun testRuleBooleanNode() = doTest(true)

    fun testRuleBooleansInlineNode() = doTest(true)

    fun testERuleCallMissingParenthesis() = doTest(true)

    fun testEmpty() = doTest(true)

    fun testERuleOpeningParenthesis() = doTest(true)

    fun testERuleClosingParenthesis() = doTest(true)

    fun testERuleDoublePipe() = doTest(true)

    fun testERuleNodeMissingName() = doTest(true)

    fun testERuleInlineNodeMissingName() = doTest(true)

    override fun getTestDataPath(): String {
        return "testData/parsing"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}
