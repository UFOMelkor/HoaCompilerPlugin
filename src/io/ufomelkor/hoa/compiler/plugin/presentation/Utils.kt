package io.ufomelkor.hoa.compiler.plugin.presentation

import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import io.ufomelkor.hoa.compiler.lang.core.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons
import javax.swing.Icon

fun getPresentationForStructure(psi: PpElement): ItemPresentation {
    return PresentationData(presentableName(psi), null, presentableIcon(psi) ?: psi.getIcon(0), null)
}

private fun presentableIcon(psi: PpElement): Icon? {
    return when(psi) {
        is PpSkip -> PpIcons.SKIP
        is PpToken -> PpIcons.TOKEN
        is PpRule -> if (psi.isNode) PpIcons.RULE_NODE else PpIcons.RULE
        is PpTreeNode -> PpIcons.NODE
        else -> null
    }
}

private fun presentableName(psi: PpElement): String? {
    return when (psi) {
        is PpSkip -> psi.name + if (psi.currentNamespace == "default") "" else ": ${psi.currentNamespace}"
        is PpToken -> psi.name + if (psi.currentNamespace == "default" && psi.nextNamespace == "default") ""
            else if (psi.currentNamespace == psi.nextNamespace) ": ${psi.currentNamespace}"
            else ": ${psi.currentNamespace} → ${psi.nextNamespace}"
        is PpRule -> psi.name
        is PpTreeNode -> psi.text
        else -> null
    }
}
