package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Sorter
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRule
import io.ufomelkor.hoa.compiler.lang.core.psi.PpSkip
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons
import java.util.Comparator

class TypeSorter : Sorter {
    override fun getName(): String = "PP_SORTER_TYPE"

    override fun isVisible(): Boolean = true

    override fun getComparator(): Comparator<Any>  = compareBy{ calculateWeight(it) }

    private fun calculateWeight(element: Any): String {
        if (element is NamespaceGroup) {
            return "a"
        }
        if (element !is PpStructureViewElement) {
            return "z"
        }
        return when (element.value) {
            is PpSkip -> "e"
            is PpToken -> "g"
            is PpRule -> "r"
            else -> "o"
        }
    }

    override fun getPresentation(): ActionPresentation = ActionPresentationData("Sort By Type (skip, token, rule", null, PpIcons.SORT_BY_TYPE)
}
