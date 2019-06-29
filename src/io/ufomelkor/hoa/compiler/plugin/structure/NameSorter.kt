package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.IdeBundle
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.ide.util.treeView.smartTree.SorterUtil
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons
import java.util.Comparator

class NameSorter : Sorter {
    override fun getName(): String = "PP_SORTER_NAME"

    override fun isVisible(): Boolean = true

    override fun getComparator(): Comparator<Any> = compareBy( { nameWithoutUnderscore(it) }, { reversedNameWithUnderscore(it) } )

    private fun nameWithoutUnderscore(element: Any): String = SorterUtil.getStringPresentation(element).trim('_')
    private fun reversedNameWithUnderscore(element: Any): String = SorterUtil.getStringPresentation(element).reversed()

    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        IdeBundle.message("action.sort.alphabetically", arrayOfNulls<Any>(0)),
        null,
        PpIcons.SORT_BY_NAME
    )
}
