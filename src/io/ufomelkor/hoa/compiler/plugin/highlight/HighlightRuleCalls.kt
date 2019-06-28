package io.ufomelkor.hoa.compiler.plugin.highlight

import com.intellij.lang.annotation.*
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes

class HighlightRuleCalls : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.node.elementType != PpTypes.NAMED) {
            return
        }

        holder.createInfoAnnotation(element, null).textAttributes = PpSyntaxHighlighter.RULE_CALL
    }
}

