package io.ufomelkor.hoa.compiler.plugin.psi

import com.intellij.psi.tree.IElementType
import io.ufomelkor.hoa.compiler.plugin.PpLanguage
import org.jetbrains.annotations.*

class PpElementType(@NonNls debugName: String) : IElementType(debugName, PpLanguage.INSTANCE)
