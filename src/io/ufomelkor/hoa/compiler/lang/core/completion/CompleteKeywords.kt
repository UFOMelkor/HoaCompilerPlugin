package io.ufomelkor.hoa.compiler.lang.core.completion

import com.intellij.codeInsight.completion.*
import com.intellij.patterns.PlatformPatterns.*
import com.intellij.patterns.PsiElementPattern
import com.intellij.patterns.StandardPatterns.*
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import io.ufomelkor.hoa.compiler.lang.PpLanguage
import io.ufomelkor.hoa.compiler.lang.core.psi.PpConcatenation
import io.ufomelkor.hoa.compiler.lang.core.psi.PpNamed
import io.ufomelkor.hoa.compiler.lang.core.psi.PpSimple
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

class CompleteKeywords : CompletionContributor() {
    companion object {
        private fun rootPattern() = psiElement().withParent(psiElement(PpFile::class.java))
    }

    init {
        // extend(CompletionType.BASIC, rootPattern().andOr(psiElement().after), StaticWordsProvider("%skip", "%token"))
        // extend(CompletionType.BASIC, psiElement().withParent(PpConcatenation::class.java), StaticWordsProvider("::space::", "<space>"))
        // extend(CompletionType.BASIC, psiElement().withParent(PpNamed::class.java), StaticWordsProvider("::space::", "<space>"))
        // extend(CompletionType.BASIC, psiElement().withParent(PpSimple::class.java), StaticWordsProvider("::space::", "<space>"))
        // extend(CompletionType.BASIC, psiElement().afterLeaf(psiElement(PpTypes.T_NAMED)), StaticWordsProvider("::space::", "<space>"))
        // extend(CompletionType.BASIC, psiElement().afterLeaf(psiElement(TokenType.WHITE_SPACE)), StaticWordsProvider("::space::", "<space>"))
        // extend(CompletionType.BASIC, psiElement(PpTypes.T_SKIP), StaticWordsProvider("%skip"))
        // extend(CompletionType.BASIC, psiElement(PpTypes.T_TOKEN), StaticWordsProvider("%token"))
    }

    private fun basePattern(): PsiElementPattern.Capture<PsiElement> = psiElement().withParent(or(psiElement(PpFile::class.java)))
}