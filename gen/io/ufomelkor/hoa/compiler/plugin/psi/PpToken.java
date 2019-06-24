// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PpToken extends PsiElement {

  @Nullable
  PpNamespace getNamespace();

  @NotNull
  PpRegExp getRegExp();

  @Nullable
  PpSwitchNamespace getSwitchNamespace();

  @NotNull
  PpTokenName getTokenName();

}
