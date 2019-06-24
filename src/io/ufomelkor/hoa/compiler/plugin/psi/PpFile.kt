package io.ufomelkor.hoa.compiler.plugin.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import io.ufomelkor.hoa.compiler.plugin.PpFileType
import io.ufomelkor.hoa.compiler.plugin.PpLanguage

class PpFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, PpLanguage.INSTANCE) {

    override fun getFileType(): FileType {
        return PpFileType.INSTANCE
    }

    override fun toString(): String {
        return "PP File"
    }
}
