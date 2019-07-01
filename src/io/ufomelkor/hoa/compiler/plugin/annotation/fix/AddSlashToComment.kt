package io.ufomelkor.hoa.compiler.plugin.annotation.fix

import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import io.ufomelkor.hoa.compiler.lang.core.psi.PpComment
import io.ufomelkor.hoa.compiler.lang.core.psi.PpElementFactory

class AddSlashToComment(expr: PsiElement) : LocalQuickFixAndIntentionActionOnPsiElement(expr) {
    override fun getText(): String = "Add slash"
    override fun getFamilyName(): String = "Add slash"

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
        if (startElement !is PpComment || startElement.text.startsWith("//")) {
            return
        }

        startElement.replace(PpElementFactory.createComma(project, startElement.text.trimStart('/')))
    }

}
