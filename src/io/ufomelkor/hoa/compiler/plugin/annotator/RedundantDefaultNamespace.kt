package io.ufomelkor.hoa.compiler.plugin.annotator

import com.intellij.lang.annotation.*
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpNamespace
import io.ufomelkor.hoa.compiler.plugin.annotator.fix.RemoveDefaultNamespace

class RedundantDefaultNamespace : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PpNamespace && element.text == "default") {
            holder
                .createWeakWarningAnnotation(element.textRange, "default namespace can be omitted")
                .registerFix(RemoveDefaultNamespace(element))
        }
    }
}
