package io.ufomelkor.hoa.compiler.lang.core.psi

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import io.ufomelkor.hoa.compiler.lang.PpFileType
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

object PpElementFactory {
    @JvmStatic
    fun createFile(project: Project, text: String): PpFile
        = (PsiFileFactory.getInstance(project).createFileFromText("dummy.pp", PpFileType.INSTANCE, text) as PpFile)

    @JvmStatic
    fun createTokenName(project: Project, name: String): PpTokenName {
        val file = createFile(project, "%token $name")
        return file.lastChild as PpTokenName
    }


    @JvmStatic
    fun createComma(project: Project, text: String): PpComment
        = createFile(project, "//$text").firstChild as PpComment
}