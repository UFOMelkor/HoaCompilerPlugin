package io.ufomelkor.hoa.compiler.plugin.annotator

import com.intellij.lang.annotation.*
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRule
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.plugin.annotator.fix.RemoveNamespaceSwitch

class RuleMissesColon : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PpRule
            && ! (element.ruleName ?: element.nodeRuleName)!!.nextSibling.textMatches(":")
        ) {
            holder
                .createErrorAnnotation(TextRange(element.ruleName!!.textRange.endOffset-1, element.ruleName!!.textRange.endOffset), "Expected colon")
        }
    }
}
