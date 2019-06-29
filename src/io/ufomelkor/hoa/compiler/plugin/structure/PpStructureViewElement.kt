package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import io.ufomelkor.hoa.compiler.lang.core.psi.*
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement
import io.ufomelkor.hoa.compiler.lang.core.psi.impl.PpRuleImpl
import io.ufomelkor.hoa.compiler.lang.core.psi.impl.PpSkipImpl
import io.ufomelkor.hoa.compiler.lang.core.psi.impl.PpTokenImpl
import io.ufomelkor.hoa.compiler.lang.core.psi.impl.PpTreeNodeImpl
import io.ufomelkor.hoa.compiler.plugin.presentation.getPresentationForStructure
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

import java.util.ArrayList

class PpStructureViewElement(private val element: NavigatablePsiElement) : StructureViewTreeElement, SortableTreeElement {
    companion object {
        private fun findTreeNodes(rule: PpRule): Array<PpTreeNode> {
            if (rule.choice != null) {
                return findTreeNodes(rule.choice as PpChoice)
            }
            if (rule.concatenation != null) {
                return findTreeNodes(rule.concatenation as PpConcatenation)
            }
            if (rule.repetition != null) {
                return findTreeNodes(rule.repetition as PpRepetition)
            }
            if (rule.simple != null) {
                return findTreeNodes(rule.simple as PpSimple)
            }
            return emptyArray()
        }
        private fun findTreeNodes(choice: PpChoice): Array<PpTreeNode> {
            val treeNodes = mutableListOf<PpTreeNode>()
            PsiTreeUtil.getChildrenOfType(choice, PpConcatenation::class.java)?.forEach { treeNodes.addAll(findTreeNodes(it as PpConcatenation)) }
            PsiTreeUtil.getChildrenOfType(choice, PpRepetition::class.java)?.forEach { treeNodes.addAll(findTreeNodes(it as PpRepetition)) }
            PsiTreeUtil.getChildrenOfType(choice, PpSimple::class.java)?.forEach { treeNodes.addAll(findTreeNodes(it as PpSimple)) }
            return treeNodes.toTypedArray()
        }
        private fun findTreeNodes(concatenation: PpConcatenation): Array<PpTreeNode> {
            val treeNodes = mutableListOf<PpTreeNode>()
            PsiTreeUtil.getChildrenOfType(concatenation, PpRepetition::class.java)?.forEach { treeNodes.addAll(findTreeNodes(it as PpRepetition)) }
            PsiTreeUtil.getChildrenOfType(concatenation, PpSimple::class.java)?.forEach { treeNodes.addAll(findTreeNodes(it as PpSimple)) }
            if (concatenation.treeNode != null) {
                treeNodes.add(concatenation.treeNode as PpTreeNode)
            }
            return treeNodes.toTypedArray()
        }
        private fun findTreeNodes(repetition: PpRepetition): Array<PpTreeNode> {
            return findTreeNodes(repetition.simple)
        }
        private fun findTreeNodes(simple: PpSimple): Array<PpTreeNode> {
            val treeNodes = mutableListOf<PpTreeNode>()
            if (simple.capturing != null) {
                treeNodes.addAll(findTreeNodes(simple.capturing as PpCapturing))
            }
            if (simple.treeNode != null) {
                treeNodes.add(simple.treeNode as PpTreeNode)
            }
            return treeNodes.toTypedArray()
        }
        private fun findTreeNodes(capturing: PpCapturing): Array<PpTreeNode> {
            val treeNodes = mutableListOf<PpTreeNode>()
            if (capturing.choice != null) {
                treeNodes.addAll(findTreeNodes(capturing.choice as PpChoice))
            }
            if (capturing.concatenation != null) {
                treeNodes.addAll(findTreeNodes(capturing.concatenation as PpConcatenation))
            }
            if (capturing.repetition != null) {
                treeNodes.addAll(findTreeNodes(capturing.repetition as PpRepetition))
            }
            if (capturing.simple != null) {
                treeNodes.addAll(findTreeNodes(capturing.simple as PpSimple))
            }
            if (capturing.treeNode != null) {
                treeNodes.add(capturing.treeNode as PpTreeNode)
            }
            return treeNodes.toTypedArray()
        }
    }

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
        return when (element) {
            is PpFile -> {
                val skips = PsiTreeUtil.getChildrenOfType(element, PpSkip::class.java)?.map { PpStructureViewElement(it as PpSkipImpl) } ?: emptyList()
                val tokens = PsiTreeUtil.getChildrenOfType(element, PpToken::class.java)?.map { PpStructureViewElement(it as PpTokenImpl) } ?: emptyList()
                val rules = PsiTreeUtil.getChildrenOfType(element, PpRule::class.java)?.map { PpStructureViewElement(it as PpRuleImpl) } ?: emptyList()

                val treeElements = ArrayList<TreeElement>(skips.size + tokens.size + rules.size)
                treeElements.addAll(skips)
                treeElements.addAll(tokens)
                treeElements.addAll(rules)
                treeElements.toTypedArray()
            }
            is PpRule -> {
                val nodes = findTreeNodes(element).map { PpStructureViewElement(it as PpTreeNodeImpl)}
                ArrayList<TreeElement>(nodes).toTypedArray()
            }
            else -> emptyArray()
        }
    }
}
