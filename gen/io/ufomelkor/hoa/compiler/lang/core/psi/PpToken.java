// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement;

public interface PpToken extends PpElement {

  @Nullable
  PpNamespace getNamespace();

  @NotNull
  PpRegExp getRegExp();

  @Nullable
  PpSwitchNamespace getSwitchNamespace();

  @NotNull
  PpTokenName getTokenName();

  @Nullable
  String getName();

  @Nullable
  String getCurrentNamespace();

  @Nullable
  String getNextNamespace();

}
