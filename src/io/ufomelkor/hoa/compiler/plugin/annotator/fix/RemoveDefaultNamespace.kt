package io.ufomelkor.hoa.compiler.plugin.annotator.fix

import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import io.ufomelkor.hoa.compiler.lang.core.psi.PpNamespace

class RemoveDefaultNamespace(expr: PsiElement) : LocalQuickFixAndIntentionActionOnPsiElement(expr) {
    override fun getText(): String = "Remove default namespace"
    override fun getFamilyName(): String = "Remove default namespace"

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
        if (startElement is PpNamespace && startElement.text == "default") {
            startElement.nextSibling?.delete()
            startElement.delete()
        }
    }
}
