package io.ufomelkor.hoa.compiler.plugin.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTokenCall
import io.ufomelkor.hoa.compiler.lang.core.search.PpSearchUtil
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

class UnknownToken : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is PpTokenCall) {
            return
        }
        if (PpSearchUtil.findTokens(element.containingFile as PpFile, element.text).isEmpty()) {
            holder.createErrorAnnotation(element.parent.textRange, "Unknown token ${element.text}")
        }
    }
}