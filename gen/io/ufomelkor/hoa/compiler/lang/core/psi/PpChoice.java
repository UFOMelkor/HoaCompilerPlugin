// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement;

public interface PpChoice extends PpElement {

  @NotNull
  List<PpConcatenation> getConcatenationList();

  @NotNull
  List<PpRepetition> getRepetitionList();

  @NotNull
  List<PpSimple> getSimpleList();

}
