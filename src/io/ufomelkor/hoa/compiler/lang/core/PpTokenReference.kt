package io.ufomelkor.hoa.compiler.lang.core

import com.intellij.codeInsight.lookup.*
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import io.ufomelkor.hoa.compiler.lang.core.search.PpSearchUtil
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons

class PpTokenReference(element: PsiElement, textRange: TextRange) : PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {
    private val name: String = element.text.substring(textRange.startOffset, textRange.endOffset)

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult>
        = PpSearchUtil.findTokens(myElement.project, name).map { PsiElementResolveResult(it) }.toTypedArray()

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun getVariants(): Array<Any>
        = PpSearchUtil.findTokens(myElement.project)
            .filter { it.name ?: "" != "" }
            .map {
                LookupElementBuilder.create(it)
                    .withIcon(PpIcons.TOKEN)
                    .withTypeText("${it.currentNamespace} → ${it.nextNamespace} (${it.containingFile.name})")
            }
            .toTypedArray()
}
