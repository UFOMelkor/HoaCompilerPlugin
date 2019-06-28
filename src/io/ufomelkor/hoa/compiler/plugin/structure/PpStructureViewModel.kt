package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.structureView.*
import com.intellij.ide.util.treeView.smartTree.Grouper
import com.intellij.ide.util.treeView.smartTree.Sorter
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRule
import io.ufomelkor.hoa.compiler.lang.core.psi.PpSkip
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

class PpStructureViewModel(psiFile: PpFile) : StructureViewModelBase(psiFile, PpStructureViewElement(psiFile)), StructureViewModel.ElementInfoProvider {
    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }

    override fun getGroupers(): Array<Grouper> {
        return arrayOf(TypeGrouper())
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
        return element.value is PpFile
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return element.value is PpToken || element.value is PpRule || element.value is PpSkip
    }
}
