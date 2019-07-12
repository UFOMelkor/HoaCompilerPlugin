package io.ufomelkor.hoa.compiler.lang.core.search

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile
import com.intellij.psi.util.PsiTreeUtil
import io.ufomelkor.hoa.compiler.lang.PpFileType
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRule
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken

object PpSearchUtil {
    @JvmStatic
    fun findTokens(project: Project, name: String): List<PpToken> {
        val tokens = mutableListOf<PpToken>()
        FileTypeIndex.getFiles(PpFileType.INSTANCE, GlobalSearchScope.allScope(project)).forEach {
            val file = PsiManager.getInstance(project).findFile(it) as PpFile
            tokens.addAll(findTokens(file, name))
        }
        return tokens
    }

    @JvmStatic
    fun findTokens(project: Project): List<PpToken> {
        val tokens = mutableListOf<PpToken>()
        FileTypeIndex.getFiles(PpFileType.INSTANCE, GlobalSearchScope.allScope(project)).forEach {
            val file = PsiManager.getInstance(project).findFile(it) as PpFile
            tokens.addAll(findTokens(file))
        }
        return tokens
    }

    @JvmStatic
    fun findTokens(file: PpFile, name: String): List<PpToken> = findTokens(file).filter { it.name == name }

    @JvmStatic
    fun findTokens(file: PpFile): List<PpToken>
        = PsiTreeUtil.getChildrenOfType(file, PpToken::class.java)
            .orEmpty()
            .filterNotNull()
            .toList()

    @JvmStatic
    fun findRules(file: PpFile, name: String): List<PpRule> = findRules(file).filter { it.name == name }

    @JvmStatic
    fun findRules(file: PpFile): List<PpRule>
        = PsiTreeUtil.getChildrenOfType(file, PpRule::class.java)
        .orEmpty()
        .filterNotNull()
        .toList()
}
