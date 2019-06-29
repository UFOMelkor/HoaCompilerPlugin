// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement;

public interface PpRule extends PpElement {

  @Nullable
  PpChoice getChoice();

  @Nullable
  PpComment getComment();

  @Nullable
  PpConcatenation getConcatenation();

  @Nullable
  PpNodeRuleName getNodeRuleName();

  @Nullable
  PpRepetition getRepetition();

  @Nullable
  PpRuleName getRuleName();

  @Nullable
  PpSimple getSimple();

  boolean isNode();

  @Nullable
  String getName();

}
