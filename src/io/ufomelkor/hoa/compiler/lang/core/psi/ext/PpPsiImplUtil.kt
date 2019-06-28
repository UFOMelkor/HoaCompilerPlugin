package io.ufomelkor.hoa.compiler.lang.core.psi.ext

import io.ufomelkor.hoa.compiler.lang.core.psi.PpRule
import io.ufomelkor.hoa.compiler.lang.core.psi.PpSkip
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes

object PpPsiImplUtil {
    @JvmStatic
    fun getName(element: PpRule): String? {
        val name = element.node?.findChildByType(PpTypes.RULE_NAME) ?: element.node?.findChildByType(PpTypes.NODE_RULE_NAME)

        return name?.findChildByType(PpTypes.T_RULE_NAME)?.text
    }

    @JvmStatic
    fun getName(element: PpToken): String? = element.node?.findChildByType(PpTypes.TOKEN_NAME)?.findChildByType(PpTypes.T_NAME)?.text

    @JvmStatic
    fun getName(element: PpSkip): String? = element.node?.findChildByType(PpTypes.SKIP_NAME)?.findChildByType(PpTypes.T_NAME)?.text
}