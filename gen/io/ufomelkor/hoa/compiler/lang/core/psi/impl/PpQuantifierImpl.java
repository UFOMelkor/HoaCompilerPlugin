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

public class PpQuantifierImpl extends ASTWrapperPsiElement implements PpQuantifier {

  public PpQuantifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitQuantifier(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getTExactlyN() {
    return findChildByType(T_EXACTLY_N);
  }

  @Override
  @Nullable
  public PsiElement getTNOrMore() {
    return findChildByType(T_N_OR_MORE);
  }

  @Override
  @Nullable
  public PsiElement getTNToM() {
    return findChildByType(T_N_TO_M);
  }

  @Override
  @Nullable
  public PsiElement getTZeroToM() {
    return findChildByType(T_ZERO_TO_M);
  }

}
