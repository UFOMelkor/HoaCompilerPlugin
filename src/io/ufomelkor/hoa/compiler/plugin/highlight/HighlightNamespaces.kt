package io.ufomelkor.hoa.compiler.plugin.highlight

import com.intellij.lang.annotation.*
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes

class HighlightNamespaces : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.node.elementType != PpTypes.T_NAME) {
            return
        }

        val key = when(element.node.treeParent.elementType) {
            PpTypes.NAMESPACE_CALL -> PpSyntaxHighlighter.NAMESPACE
            PpTypes.NAMESPACE -> PpSyntaxHighlighter.NAMESPACE
            else -> null
        }
        if (key != null) {
            holder.createInfoAnnotation(element, null).textAttributes = key
        }
    }
}

