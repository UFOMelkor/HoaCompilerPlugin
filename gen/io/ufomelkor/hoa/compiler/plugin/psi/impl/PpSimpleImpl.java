// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.ufomelkor.hoa.compiler.plugin.psi.PpTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.ufomelkor.hoa.compiler.plugin.psi.*;

public class PpSimpleImpl extends ASTWrapperPsiElement implements PpSimple {

  public PpSimpleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitSimple(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PpCapturing getCapturing() {
    return findChildByClass(PpCapturing.class);
  }

  @Override
  @Nullable
  public PpComment getComment() {
    return findChildByClass(PpComment.class);
  }

  @Override
  @Nullable
  public PpKept getKept() {
    return findChildByClass(PpKept.class);
  }

  @Override
  @Nullable
  public PpNamed getNamed() {
    return findChildByClass(PpNamed.class);
  }

  @Override
  @Nullable
  public PpNamedNode getNamedNode() {
    return findChildByClass(PpNamedNode.class);
  }

  @Override
  @Nullable
  public PpSkipped getSkipped() {
    return findChildByClass(PpSkipped.class);
  }

}
