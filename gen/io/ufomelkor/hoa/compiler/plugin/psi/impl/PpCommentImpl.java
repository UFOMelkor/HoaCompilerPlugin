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

public class PpCommentImpl extends ASTWrapperPsiElement implements PpComment {

  public PpCommentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitComment(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

}
