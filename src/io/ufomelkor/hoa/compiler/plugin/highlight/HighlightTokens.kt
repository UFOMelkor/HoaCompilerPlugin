package io.ufomelkor.hoa.compiler.plugin.highlight

import com.intellij.lang.annotation.*
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes

class HighlightTokens : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.node.elementType != PpTypes.T_NAME || element.node.treeParent.treeParent == null) {
            return
        }

        val key = when(element.node.treeParent.treeParent.elementType) {
            PpTypes.SKIP -> PpSyntaxHighlighter.SKIP_NAME
            PpTypes.TOKEN -> PpSyntaxHighlighter.TOKEN_NAME
            PpTypes.SKIPPED -> PpSyntaxHighlighter.SKIPPED_TOKEN
            PpTypes.KEPT -> PpSyntaxHighlighter.KEPT_TOKEN
            else -> null
        }
        if (key != null) {
            holder.createInfoAnnotation(element, null).textAttributes = key
        }
    }
}

