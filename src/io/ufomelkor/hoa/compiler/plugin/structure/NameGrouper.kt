package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.ide.util.treeView.smartTree.*
import com.intellij.navigation.ItemPresentation
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons
import javax.swing.Icon

class NameGrouper : Grouper {
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        "Group By Name",
        null,
        PpIcons.GROUP_BY_NAMES
    )

    override fun getName(): String = presentation.text

    override fun group(parent: AbstractTreeNode<*>, children: MutableCollection<TreeElement>): MutableCollection<Group> {
        if (parent is GroupWrapper) {
            return emptyArray<Group>().toMutableList()
        }
        val nameOccurrences = mutableMapOf<String, Int>()
        children.map { SorterUtil.getStringPresentation(it).trim('_') }.filter{ it != "" }.forEach{
            nameOccurrences[it] = nameOccurrences.getOrDefault(it, 0) + 1
        }
        val namesForGrouping = nameOccurrences.filter { it.value > 1 }.keys.toSet()
        val groupItems = mutableMapOf<String, MutableCollection<TreeElement>>()
        namesForGrouping.forEach{ groupItems[it] = mutableListOf() }

        children.forEach {
            val groupName = SorterUtil.getStringPresentation(it).trim('_')
            groupItems[groupName]?.add(it)
        }

        return groupItems.map { NameGroup(it.key, it.value) }.toMutableList()
    }
}

class NameGroup (name: String, private val children: MutableCollection<TreeElement>) : Group {
    private val presentation: ItemPresentation = NamePresentation(name, PpIcons.NAMESPACE)

    override fun getPresentation() = presentation
    override fun getChildren(): MutableCollection<TreeElement> = children
}

private class NamePresentation(private val name: String, private val icon: Icon) : ItemPresentation {
    override fun getLocationString(): String? = null

    override fun getIcon(dark: Boolean): Icon? = null

    override fun getPresentableText(): String?  = this.name
}