package io.ufomelkor.hoa.compiler.plugin.annotator

import com.intellij.lang.annotation.*
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpSkip
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpLexeme
import io.ufomelkor.hoa.compiler.plugin.annotator.fix.RemoveNamespaceSwitch

class EnsureCompleteLexemes : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is PpLexeme) {
            return
        }

        if (element.lexemeName == null) {
            holder
                .createErrorAnnotation(TextRange(
                    element.lastChild.textRange.endOffset - 1,
                    element.lastChild.textRange.endOffset
                ), "Expected name")
            return
        }

        if (element.regExp == null) {
            holder
                .createErrorAnnotation(TextRange(
                    element.lastChild.textRange.endOffset - 1,
                    element.lastChild.textRange.endOffset
                ), "Expected regular expression")
        }
    }
}
