// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement;

public interface PpRepetition extends PpElement {

  @NotNull
  PpQuantifier getQuantifier();

  @NotNull
  PpSimple getSimple();

  @Nullable
  PpTreeNode getTreeNode();

}