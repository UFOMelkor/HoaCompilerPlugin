package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import javax.swing.Icon

class TypeFilter(private val typeName: String, private val type: Class<*>, private val icon: Icon) : Filter {
    override fun isReverted(): Boolean = true

    override fun getPresentation(): ActionPresentation = ActionPresentationData("Show $typeName", null, icon)

    override fun getName(): String = "PP_TYPE_FILTER_${typeName.toUpperCase()}"

    override fun isVisible(element: TreeElement?): Boolean {
        return element !is PpStructureViewElement
            || ! type.isInstance(element.value)
    }
}
