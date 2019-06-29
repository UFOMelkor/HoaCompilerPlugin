package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.ide.util.treeView.smartTree.*
import com.intellij.navigation.ItemPresentation
import io.ufomelkor.hoa.compiler.lang.core.psi.*
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons
import javax.swing.Icon

class NamespaceGrouper : Grouper {
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        "Group Lexemes By Namespace",
        null,
        PpIcons.GROUP_BY_NAMESPACE
    )

    override fun getName(): String = presentation.text

    override fun group(parent: AbstractTreeNode<*>, children: MutableCollection<TreeElement>): MutableCollection<Group> {
        if (parent is GroupWrapper) {
            return emptyArray<Group>().toMutableList()
        }
        val structures = children.filterIsInstance<PpStructureViewElement>()
        val skips = structures.filter { it.value is PpSkip }
        val tokens = structures.filter { it.value is PpToken }

        val namespaces = skips
            .map { (it.value as PpSkip).currentNamespace }
            .plus(tokens.map { (it.value as PpToken).currentNamespace})
            .toSet()

        return namespaces.map {
            NamespaceGroup(
                it as String,
                skips
                    .filter { each -> (each.value as PpSkip).currentNamespace == it}
                    .plus(tokens.filter { each -> (each.value as PpToken).currentNamespace == it } )
                    .toMutableList()
            )
        }.toMutableList()
    }
}

class NamespaceGroup (name: String, private val children: MutableCollection<TreeElement>) : Group {
    private val presentation: ItemPresentation = GroupPresentation(name, PpIcons.NAMESPACE)

    override fun getPresentation() = presentation
    override fun getChildren(): MutableCollection<TreeElement> = children
}

private class GroupPresentation(private val name: String, private val icon: Icon) : ItemPresentation {
    override fun getLocationString(): String? = null

    override fun getIcon(dark: Boolean): Icon? = this.icon

    override fun getPresentableText(): String?  = this.name
}