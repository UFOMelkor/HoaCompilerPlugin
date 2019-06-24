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

public class PpCapturingImpl extends ASTWrapperPsiElement implements PpCapturing {

  public PpCapturingImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitCapturing(this);
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
  public PpConcatenation getConcatenation() {
    return findChildByClass(PpConcatenation.class);
  }

  @Override
  @Nullable
  public PpRepetition getRepetition() {
    return findChildByClass(PpRepetition.class);
  }

  @Override
  @Nullable
  public PpSimple getSimple() {
    return findChildByClass(PpSimple.class);
  }

}
