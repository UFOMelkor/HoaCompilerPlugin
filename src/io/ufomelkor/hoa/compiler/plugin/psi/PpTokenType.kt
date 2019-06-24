package io.ufomelkor.hoa.compiler.plugin.psi


import com.intellij.psi.tree.IElementType
import io.ufomelkor.hoa.compiler.plugin.PpLanguage
import org.jetbrains.annotations.*

class PpTokenType(@NonNls debugName: String) : IElementType(debugName, PpLanguage.INSTANCE) {
    override fun toString(): String {
        return "PpTokenType." + super.toString()
    }
}
