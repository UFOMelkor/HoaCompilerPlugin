package io.ufomelkor.hoa.compiler.lang.core

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTokenCall

class PpReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PpTokenCall::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                    val reference = element as PpTokenCall
                    val value = reference.text
                    return arrayOf(PpTokenReference(element, TextRange(0, value.length + 1)))
                }
            }
        )
    }
}
