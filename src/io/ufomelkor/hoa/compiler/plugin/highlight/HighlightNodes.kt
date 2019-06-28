package io.ufomelkor.hoa.compiler.plugin.highlight

import com.intellij.lang.annotation.*
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes

class HighlightNodes : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.node.elementType !in arrayOf(PpTypes.T_NAME, PpTypes.T_RULE_NAME, PpTypes.T_HASH)) {
            return
        }

        if (element.node.treeParent.elementType == PpTypes.NODE_RULE_NAME || element.node.treeParent.elementType == PpTypes.TREE_NODE) {
            holder.createInfoAnnotation(element, null).textAttributes = PpSyntaxHighlighter.NODE
        }
    }
}
