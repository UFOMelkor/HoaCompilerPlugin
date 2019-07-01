package io.ufomelkor.hoa.compiler.lang.core.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpNamedElement

abstract class PpNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), PpNamedElement
