package io.ufomelkor.hoa.compiler.plugin.structure

import com.intellij.ide.structureView.*
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

class PpStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder? {
        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel {
                return PpStructureViewModel(psiFile as PpFile)
            }
        }
    }
}
