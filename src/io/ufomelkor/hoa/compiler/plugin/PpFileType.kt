package io.ufomelkor.hoa.compiler.plugin

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.*

class PpFileType private constructor() : LanguageFileType(PpLanguage.INSTANCE) {
    companion object {
        val INSTANCE = PpFileType()
    }

    override fun getName(): String {
        return "PP file"
    }

    override fun getDescription(): String {
        return "PHP Parser file for use with Hoa\\Compiler"
    }

    override fun getDefaultExtension(): String {
        return "pp"
    }

    override fun getIcon(): Icon? {
        return SimpleIcons.FILE
    }
}