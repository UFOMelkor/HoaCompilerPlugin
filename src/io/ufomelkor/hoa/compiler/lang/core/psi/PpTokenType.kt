package io.ufomelkor.hoa.compiler.lang.core.psi


import com.intellij.psi.tree.IElementType
import io.ufomelkor.hoa.compiler.lang.PpLanguage
import org.jetbrains.annotations.*

class PpTokenType(@NonNls debugName: String) : IElementType(debugName, PpLanguage.INSTANCE) {
    override fun toString(): String {
        return "PpTokenType." + super.toString()
    }
}
