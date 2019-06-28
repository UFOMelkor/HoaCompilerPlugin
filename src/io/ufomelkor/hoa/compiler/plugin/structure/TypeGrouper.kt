package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.ide.util.treeView.smartTree.*
import com.intellij.navigation.ItemPresentation
import io.ufomelkor.hoa.compiler.lang.core.psi.*
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons
import javax.swing.Icon

class TypeGrouper : Grouper {
    private val presentation = ActionPresentationData(
            "Type",
            "Group by type (Skip, Token, Rule)",
            null
    )

    override fun getPresentation(): ActionPresentation = presentation

    override fun getName(): String = presentation.text

    override fun group(parent: AbstractTreeNode<*>, children: MutableCollection<TreeElement>): MutableCollection<Group> {
        if (parent is GroupWrapper) {
            return emptyArray<Group>().toMutableList()
        }
        val skips = children.filter { it is PpStructureViewElement && it.value is PpSkip }
        val tokens = children.filter { it is PpStructureViewElement && it.value is PpToken }
        val rules = children.filter { it is PpStructureViewElement && it.value is PpRule }
        return arrayListOf(
            PresentableGroup(GroupPresentation("Skips", PpIcons.SKIP), skips.toMutableList()),
            PresentableGroup(GroupPresentation("Tokens", PpIcons.TOKEN), tokens.toMutableList()),
            PresentableGroup(GroupPresentation("Rules", PpIcons.RULE), rules.toMutableList())
        )
    }
}

private class PresentableGroup (private val presentation: ItemPresentation, private val children: MutableCollection<TreeElement>) : Group {
    override fun getPresentation(): ItemPresentation = presentation

    override fun getChildren(): MutableCollection<TreeElement> = children
}

private class GroupPresentation(private val name: String, private val icon: Icon) : ItemPresentation {
    override fun getLocationString(): String? = null

    override fun getIcon(dark: Boolean): Icon? = this.icon

    override fun getPresentableText(): String?  = this.name
}