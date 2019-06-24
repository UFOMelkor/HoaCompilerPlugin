// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PpChoice extends PsiElement {

  @NotNull
  List<PpConcatenation> getConcatenationList();

  @NotNull
  List<PpRepetition> getRepetitionList();

  @NotNull
  List<PpSimple> getSimpleList();

}
