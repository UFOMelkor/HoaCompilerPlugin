// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.*;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpPsiImplUtil;

public class PpTokenImpl extends ASTWrapperPsiElement implements PpToken {

  public PpTokenImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitToken(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PpNamespace getNamespace() {
    return findChildByClass(PpNamespace.class);
  }

  @Override
  @NotNull
  public PpRegExp getRegExp() {
    return findNotNullChildByClass(PpRegExp.class);
  }

  @Override
  @Nullable
  public PpSwitchNamespace getSwitchNamespace() {
    return findChildByClass(PpSwitchNamespace.class);
  }

  @Override
  @NotNull
  public PpTokenName getTokenName() {
    return findNotNullChildByClass(PpTokenName.class);
  }

  @Override
  @Nullable
  public String getName() {
    return PpPsiImplUtil.getName(this);
  }

  @Override
  @Nullable
  public String getCurrentNamespace() {
    return PpPsiImplUtil.getCurrentNamespace(this);
  }

  @Override
  @Nullable
  public String getNextNamespace() {
    return PpPsiImplUtil.getNextNamespace(this);
  }

}
