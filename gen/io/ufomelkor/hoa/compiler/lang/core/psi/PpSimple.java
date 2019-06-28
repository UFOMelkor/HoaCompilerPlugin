// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement;

public interface PpSimple extends PpElement {

  @Nullable
  PpCapturing getCapturing();

  @Nullable
  PpComment getComment();

  @Nullable
  PpKept getKept();

  @Nullable
  PpNamed getNamed();

  @Nullable
  PpSkipped getSkipped();

  @Nullable
  PpTreeNode getTreeNode();

}
