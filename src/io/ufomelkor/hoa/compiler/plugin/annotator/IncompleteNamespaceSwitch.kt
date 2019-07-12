package io.ufomelkor.hoa.compiler.plugin.annotator

import com.intellij.lang.annotation.*
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.plugin.annotator.fix.RemoveNamespaceSwitch

class IncompleteNamespaceSwitch : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PpToken
            && element.switchNamespace != null
            && element.switchNamespace!!.namespaceCall == null
        ) {
            holder
                .createErrorAnnotation(element.switchNamespace!!.textRange, "Expected namespace")
                .registerFix(RemoveNamespaceSwitch(element.switchNamespace!!))
        }
    }
}
