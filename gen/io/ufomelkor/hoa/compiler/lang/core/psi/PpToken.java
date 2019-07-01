// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpNamedElement;

public interface PpToken extends PpNamedElement {

  @Nullable
  PpNamespace getNamespace();

  @Nullable
  PpRegExp getRegExp();

  @Nullable
  PpSwitchNamespace getSwitchNamespace();

  @Nullable
  PpTokenName getTokenName();

  @Nullable
  String getCurrentNamespace();

  @Nullable
  String getNextNamespace();

  @Nullable
  String getName();

  @NotNull
  PsiElement setName(@NotNull String newName);

  @Nullable
  PsiElement getNameIdentifier();

}
