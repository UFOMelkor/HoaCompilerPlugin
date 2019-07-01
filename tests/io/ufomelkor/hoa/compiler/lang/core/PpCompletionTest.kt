package io.ufomelkor.hoa.compiler.lang.core

import junit.framework.TestCase
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase

class PpCompletionTest : LightPlatformCodeInsightFixtureTestCase() {
    override fun getTestDataPath(): String = "testData/completion"

    fun testEmpty() {
        myFixture.configureByFile("Empty.pp")
        myFixture.completeBasic()
        val strings = myFixture.lookupElementStrings

        TestCase.assertTrue(strings?.containsAll(listOf("%skip", "%token")) ?: false)
        TestCase.assertEquals(5, strings?.size)
    }
}
