package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRule
import io.ufomelkor.hoa.compiler.lang.core.psi.PpSkip
import io.ufomelkor.hoa.compiler.lang.core.psi.PpToken
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement
import io.ufomelkor.hoa.compiler.lang.core.psi.impl.PpRuleImpl
import io.ufomelkor.hoa.compiler.lang.core.psi.impl.PpSkipImpl
import io.ufomelkor.hoa.compiler.lang.core.psi.impl.PpTokenImpl
import io.ufomelkor.hoa.compiler.plugin.presentation.getPresentationForStructure
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

import java.util.ArrayList

class PpStructureViewElement(private val element: NavigatablePsiElement) : StructureViewTreeElement, SortableTreeElement {

    override fun getValue() = element

    override fun navigate(requestFocus: Boolean) {
        element.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return element.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return element.canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        return element.name ?: ""
    }

    override fun getPresentation(): ItemPresentation {
        if (element is PpFile) {
            return element.presentation ?: PresentationData()
        }
        return getPresentationForStructure(element as PpElement)
    }

    override fun getChildren(): Array<TreeElement> {
        return if (element is PpFile) {
            val skips = PsiTreeUtil.getChildrenOfType(element, PpSkip::class.java)?.map { PpStructureViewElement(it as PpSkipImpl) }
            val tokens = PsiTreeUtil.getChildrenOfType(element, PpToken::class.java)?.map { PpStructureViewElement(it as PpTokenImpl) }
            val rules = PsiTreeUtil.getChildrenOfType(element, PpRule::class.java)?.map { PpStructureViewElement(it as PpRuleImpl) }

            val treeElements = ArrayList<TreeElement>(skips!!.size + tokens!!.size + rules!!.size)
            treeElements.addAll(skips)
            treeElements.addAll(tokens)
            treeElements.addAll(rules)
            treeElements.toTypedArray()
        } else {
            emptyArray()
        }
    }
}


