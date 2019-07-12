package io.ufomelkor.hoa.compiler.plugin.annotator.fix

import io.ufomelkor.hoa.compiler.lang.core.psi.PpSwitchNamespace
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement

class RemoveNamespaceSwitch(expr: PsiElement) : LocalQuickFixAndIntentionActionOnPsiElement(expr) {
    override fun getText(): String = "Remove namespace switch"
    override fun getFamilyName(): String = "Remove namespace switch"

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
        if (startElement is PpSwitchNamespace) {
            if (startElement.prevSibling !is PpElement) {
                // remove whitespaces
                startElement.prevSibling.delete()
            }
            startElement.delete()
        }
    }
}
