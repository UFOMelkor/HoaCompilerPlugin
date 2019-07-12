package io.ufomelkor.hoa.compiler.plugin.annotator

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase
import org.intellij.lang.annotations.Language

abstract class AnnotatorTestCase : LightPlatformCodeInsightFixtureTestCase() {
    protected fun checkErrors(@Language("PP") code: String) {
        myFixture.configureByText("dummy.pp", code)
        myFixture.checkHighlighting(false, false, false)
    }

    protected fun checkWarnings(@Language("PP") code: String) {
        myFixture.configureByText("dummy.pp", code)
        myFixture.checkHighlighting(true, false, true)
    }

    protected fun checkInfo(@Language("PP") code: String) {
        myFixture.configureByText("dummy.pp", code)
        myFixture.checkHighlighting(false, true, false)
    }
}
