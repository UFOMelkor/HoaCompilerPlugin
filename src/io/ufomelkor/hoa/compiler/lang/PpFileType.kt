package io.ufomelkor.hoa.compiler.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons

import javax.swing.*

class PpFileType private constructor() : LanguageFileType(PpLanguage.INSTANCE) {
    companion object {
        val INSTANCE = PpFileType()
    }

    override fun getName(): String {
        return "PP file"
    }

    override fun getDescription(): String {
        return "Hoa\\Compiler PP file"
    }

    override fun getDefaultExtension(): String {
        return "pp"
    }

    override fun getIcon(): Icon? {
        return PpIcons.FILE
    }
}