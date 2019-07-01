package io.ufomelkor.hoa.compiler.plugin.annotation

import com.intellij.lang.annotation.*
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpComment
import io.ufomelkor.hoa.compiler.plugin.annotation.fix.AddSlashToComment

class MissingSlashAtCommentStart : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is PpComment) {
            return
        }

        if (!element.text.startsWith("//")) {
            holder.createErrorAnnotation(element.textRange, "Missing /").registerFix(AddSlashToComment(element))
        }
    }
}