package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.structureView.*
import com.intellij.ide.util.treeView.smartTree.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRule
import io.ufomelkor.hoa.compiler.lang.core.psi.PpSkip
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTreeNode
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

class PpStructureViewModel(psiFile: PpFile) : StructureViewModelBase(psiFile, PpStructureViewElement(psiFile)), StructureViewModel.ElementInfoProvider {
    override fun getSorters(): Array<Sorter> {
        return arrayOf(TypeSorter(), NameSorter())
    }

    override fun getGroupers(): Array<Grouper> {
        return arrayOf(NameGrouper(), NamespaceGrouper())
    }

    override fun getFilters(): Array<Filter> {
        return arrayOf(
            TypeFilter("Skip", PpSkip::class.java, PpIcons.SKIP),
            TypeFilter("Token", PpToken::class.java, PpIcons.TOKEN),
            TypeFilter("Rule", PpRule::class.java, PpIcons.RULE)
        )
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
        return element.value is PpFile
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return element.value is PpToken || element.value is PpTreeNode || element.value is PpSkip
    }
}
