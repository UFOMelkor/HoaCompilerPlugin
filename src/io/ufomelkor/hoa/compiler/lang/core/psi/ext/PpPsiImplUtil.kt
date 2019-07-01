package io.ufomelkor.hoa.compiler.lang.core.psi.ext

import com.intellij.psi.PsiElement
import io.ufomelkor.hoa.compiler.lang.core.psi.*

object PpPsiImplUtil {
    @JvmStatic
    fun getName(element: PpRule): String? {
        val name = element.node?.findChildByType(PpTypes.RULE_NAME) ?: element.node?.findChildByType(PpTypes.NODE_RULE_NAME)

        return name?.findChildByType(PpTypes.T_RULE_NAME)?.text
    }

    @JvmStatic
    fun isNode(element: PpRule): Boolean
        = element.node?.findChildByType(PpTypes.NODE_RULE_NAME) != null

    @JvmStatic
    fun getName(element: PpToken): String?
        = element.node?.findChildByType(PpTypes.TOKEN_NAME)?.findChildByType(PpTypes.T_NAME)?.text

    @JvmStatic
    fun getName(element: PpSkip): String?
        = element.node?.findChildByType(PpTypes.SKIP_NAME)?.findChildByType(PpTypes.T_NAME)?.text

    @JvmStatic
    fun getCurrentNamespace(element: PpSkip): String
        = element.node?.findChildByType(PpTypes.NAMESPACE)?.findChildByType(PpTypes.T_NAME)?.text ?: "default"

    @JvmStatic
    fun getCurrentNamespace(element: PpToken): String?
        = element.node?.findChildByType(PpTypes.NAMESPACE)?.findChildByType(PpTypes.T_NAME)?.text ?: "default"

    @JvmStatic
    fun getNextNamespace(element: PpToken): String?
        = element.node?.findChildByType(PpTypes.SWITCH_NAMESPACE)?.findChildByType(PpTypes.T_NAME)?.text ?: getCurrentNamespace(element)

    @JvmStatic
    fun setName(element: PpToken, newName: String): PsiElement {
        val nameNode = element.node.findChildByType(PpTypes.TOKEN_NAME)
        if (nameNode != null) {
            val newNameNode = PpElementFactory.createTokenName(element.project, newName).firstChild.node
            element.node.replaceChild(nameNode, newNameNode)
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: PpToken) = element.node?.findChildByType(PpTypes.TOKEN_NAME)?.psi
}
