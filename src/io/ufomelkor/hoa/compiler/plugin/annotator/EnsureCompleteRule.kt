package io.ufomelkor.hoa.compiler.plugin.annotator

import com.intellij.lang.annotation.*
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpNamed
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRule
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRuleCall
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.plugin.annotator.fix.RemoveNamespaceSwitch

class EnsureCompleteRule : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        ensureColonAfterRuleName(element, holder)
        ensureRuleHasContent(element, holder)
        ensureParenthesesAfterRuleCall(element, holder)
    }

    private fun ensureColonAfterRuleName(element: PsiElement, holder: AnnotationHolder) {
        if (element is PpRule
            && ! (element.ruleName ?: element.nodeRuleName)!!.nextSibling.textMatches(":")
        ) {
            holder
                .createErrorAnnotation(TextRange(element.ruleName!!.textRange.endOffset-1, element.ruleName!!.textRange.endOffset), "Expected colon")
        }
    }

    private fun ensureRuleHasContent(element: PsiElement, holder: AnnotationHolder) {
        if (element is PpRule
            && element.simple === null
            && element.concatenation === null
            && element.repetition === null
            && element.choice === null
        ) {
            holder
                .createErrorAnnotation(element.textRange, "Empty rules are not allowed")
        }
    }

    private fun ensureParenthesesAfterRuleCall(element: PsiElement, holder: AnnotationHolder) {
        if (element is PpNamed
            && ! element.lastChild.textMatches("()")
        ) {
            holder
                .createErrorAnnotation(element.textRange, "Invalid rule call, missing ()")
        }
    }
}
