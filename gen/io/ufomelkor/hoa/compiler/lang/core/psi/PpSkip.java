// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement;

public interface PpSkip extends PpElement {

  @Nullable
  PpNamespace getNamespace();

  @NotNull
  PpRegExp getRegExp();

  @NotNull
  PpSkipName getSkipName();

  @Nullable
  String getName();

}
