package io.ufomelkor.hoa.compiler.plugin.highlight

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase
import junit.framework.TestCase
import org.intellij.lang.annotations.Language

abstract class AnnotationHighlightingTestCase : LightPlatformCodeInsightFixtureTestCase() {
    protected fun checkHighlightingOfElementByText(@Language("PP") code: String, highlightedAs: TextAttributesKey, vararg elementContent: String) {
        myFixture.configureByText("dummy.pp", code)
        doCheckHighlightingOfElement(highlightedAs, *elementContent)
    }

    protected fun checkHighlightingOfElementByFile(fileName: String, elementContent: String, highlightedAs: TextAttributesKey) {
        myFixture.configureByFile(fileName)
        doCheckHighlightingOfElement(highlightedAs, elementContent)
    }

    private fun doCheckHighlightingOfElement(highlightedAs: TextAttributesKey, vararg elementContent: String) {
        val allInfo = myFixture.doHighlighting()
        TestCase.assertTrue(
            "Expected no errors but got\n - ${allInfo.filter { it.severity == HighlightSeverity.ERROR }.joinToString("\n - ")}",
            allInfo.none { it.severity == HighlightSeverity.ERROR }
        )

        val foundLists = mutableListOf<String>()
        var lastOffsetEnd = -1
        allInfo.filter { it.forcedTextAttributesKey == highlightedAs }.forEach {
            if (lastOffsetEnd != it.actualStartOffset) {
                foundLists.add("")
            }
            foundLists[foundLists.lastIndex] += it.text
            lastOffsetEnd = it.actualEndOffset
        }

        val searchedContent = elementContent.joinToString("")
        TestCase.assertTrue(
            "Expected \"$searchedContent\" of type \"$highlightedAs\" but got only this contents with \"$highlightedAs\": [${foundLists.joinToString(", ")}]\n"
                + "These types were found generally: ${allInfo.filter { it.forcedTextAttributesKey !== null }.map { "${it.text} [${it.forcedTextAttributesKey}]" }.joinToString(", ")}",
            foundLists.contains(searchedContent)
        )
    }
}
