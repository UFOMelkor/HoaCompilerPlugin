package io.ufomelkor.hoa.compiler.plugin

import com.intellij.testFramework.ParsingTestCase

class PpParsingTest : ParsingTestCase("", "pp", PpParserDefinition()) {
    fun testComment() {
        doTest(true)
    }

    fun testSkip() {
        doTest(true)
    }

    fun testSkipNs() {
        doTest(true)
    }

    fun testToken() {
        doTest(true)
    }

    fun testTokenNs() {
        doTest(true)
    }

    fun testRuleAtLeast() {
        doTest(true)
    }

    fun testRuleAtMost() {
        doTest(true)
    }

    fun testRuleBetween() {
        doTest(true)
    }

    fun testRuleChoice() {
        doTest(true)
    }

    fun testRuleGroup() {
        doTest(true)
    }

    fun testRuleNamedNode() {
        doTest(true)
    }

    fun testRuleOneOrMore() {
        doTest(true)
    }

    fun testRuleOptional() {
        doTest(true)
    }

    fun testRuleRule() {
        doTest(true)
    }

    fun testRuleToken() {
        doTest(true)
    }

    fun testRuleTokenInvisible() {
        doTest(true)
    }

    fun testRuleUnification() {
        doTest(true)
    }

    fun testRuleZeroOrMore() {
        doTest(true)
    }

    fun testTwoRules() {
        doTest(true)
    }

    fun testRuleWithComment() {
        doTest(true)
    }

    fun testJsonLexemes() {
        doTest(true)
    }

    fun testJsonRules() {
        doTest(true)
    }

    fun testJson() {
        doTest(true)
    }

    override fun getTestDataPath(): String {
        return "testData"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}
