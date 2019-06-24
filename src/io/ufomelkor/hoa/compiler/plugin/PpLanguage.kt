package io.ufomelkor.hoa.compiler.plugin

import com.intellij.lang.Language

class PpLanguage private constructor() : Language("PP") {
    companion object {
        val INSTANCE = PpLanguage()
    }
}
