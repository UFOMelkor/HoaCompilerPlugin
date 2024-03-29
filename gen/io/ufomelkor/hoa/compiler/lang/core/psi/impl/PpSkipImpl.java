// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes.*;
import io.ufomelkor.hoa.compiler.lang.core.psi.*;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpPsiImplUtil;

public class PpSkipImpl extends PpNamedElementImpl implements PpSkip {

  public PpSkipImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitSkip(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PpLexemeName getLexemeName() {
    return findChildByClass(PpLexemeName.class);
  }

  @Override
  @Nullable
  public PpNamespace getNamespace() {
    return findChildByClass(PpNamespace.class);
  }

  @Override
  @Nullable
  public PpRegExp getRegExp() {
    return findChildByClass(PpRegExp.class);
  }

  @Override
  @NotNull
  public String getCurrentNamespace() {
    return PpPsiImplUtil.getCurrentNamespace(this);
  }

  @Override
  @Nullable
  public String getName() {
    return PpPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String newName) {
    return PpPsiImplUtil.setName(this, newName);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return PpPsiImplUtil.getNameIdentifier(this);
  }

}
