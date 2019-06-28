package io.ufomelkor.hoa.compiler.lang.core.psi

import com.intellij.psi.tree.IElementType
import io.ufomelkor.hoa.compiler.lang.PpLanguage
import org.jetbrains.annotations.*

class PpElementType(@NonNls debugName: String) : IElementType(debugName, PpLanguage.INSTANCE)
