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

public class PpRuleImpl extends ASTWrapperPsiElement implements PpRule {

  public PpRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitRule(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PpChoice getChoice() {
    return findChildByClass(PpChoice.class);
  }

  @Override
  @Nullable
  public PpComment getComment() {
    return findChildByClass(PpComment.class);
  }

  @Override
  @Nullable
  public PpConcatenation getConcatenation() {
    return findChildByClass(PpConcatenation.class);
  }

  @Override
  @Nullable
  public PpNodeRuleName getNodeRuleName() {
    return findChildByClass(PpNodeRuleName.class);
  }

  @Override
  @Nullable
  public PpRepetition getRepetition() {
    return findChildByClass(PpRepetition.class);
  }

  @Override
  @Nullable
  public PpRuleName getRuleName() {
    return findChildByClass(PpRuleName.class);
  }

  @Override
  @Nullable
  public PpSimple getSimple() {
    return findChildByClass(PpSimple.class);
  }

  @Override
  @Nullable
  public String getName() {
    return PpPsiImplUtil.getName(this);
  }

}
