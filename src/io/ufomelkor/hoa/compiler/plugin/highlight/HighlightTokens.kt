package io.ufomelkor.hoa.compiler.plugin.highlight

import com.intellij.lang.annotation.*
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes

class HighlightTokens : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.node.elementType != PpTypes.T_NAME) {
            return
        }

        val key = when(element.node.treeParent.elementType) {
            PpTypes.TOKEN_NAME -> PpSyntaxHighlighter.TOKEN_NAME
            PpTypes.SKIP_NAME -> PpSyntaxHighlighter.SKIP_NAME
            PpTypes.SKIPPED -> PpSyntaxHighlighter.SKIPPED_TOKEN
            PpTypes.KEPT -> PpSyntaxHighlighter.KEPT_TOKEN
            else -> null
        }
        if (key != null) {
            holder.createInfoAnnotation(element, null).textAttributes = key
        }
    }
}

