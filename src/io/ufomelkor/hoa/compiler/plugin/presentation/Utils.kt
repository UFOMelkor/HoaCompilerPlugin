package io.ufomelkor.hoa.compiler.plugin.presentation

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import io.ufomelkor.hoa.compiler.lang.core.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons
import javax.swing.Icon

fun getPresentation(psi: PpElement): ItemPresentation {
    val name = presentableName(psi)
    return PresentationData(name, psi.containingFile.name, psi.getIcon(0), null)
}

fun getPresentationForStructure(psi: PpElement): ItemPresentation {
    return PresentationData(presentableName(psi), null, presentableIcon(psi) ?: psi.getIcon(0), null)
}

private fun presentableIcon(psi: PpElement): Icon? {
    return when(psi) {
        is PpSkip -> AllIcons.Ide.LookupAlphanumeric
        is PpToken -> PpIcons.TOKEN
        is PpRule -> PpIcons.RULE
        else -> null
    }
}

private fun presentableName(psi: PpElement): String? {
    return when (psi) {
        is PpSkip -> psi.name
        is PpToken -> psi.name
        is PpRule -> psi.name
        else -> null
    }
}
