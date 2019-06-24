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

public class PpChoiceImpl extends ASTWrapperPsiElement implements PpChoice {

  public PpChoiceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitChoice(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PpConcatenation> getConcatenationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PpConcatenation.class);
  }

  @Override
  @NotNull
  public List<PpRepetition> getRepetitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PpRepetition.class);
  }

  @Override
  @NotNull
  public List<PpSimple> getSimpleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PpSimple.class);
  }

}