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

public class PpRepetitionImpl extends ASTWrapperPsiElement implements PpRepetition {

  public PpRepetitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitRepetition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PpQuantifier getQuantifier() {
    return findNotNullChildByClass(PpQuantifier.class);
  }

  @Override
  @NotNull
  public PpSimple getSimple() {
    return findNotNullChildByClass(PpSimple.class);
  }

  @Override
  @Nullable
  public PpTreeNode getTreeNode() {
    return findChildByClass(PpTreeNode.class);
  }

}
