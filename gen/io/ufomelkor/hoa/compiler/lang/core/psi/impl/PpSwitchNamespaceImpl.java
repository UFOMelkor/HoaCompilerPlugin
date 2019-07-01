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

public class PpSwitchNamespaceImpl extends ASTWrapperPsiElement implements PpSwitchNamespace {

  public PpSwitchNamespaceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PpVisitor visitor) {
    visitor.visitSwitchNamespace(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PpVisitor) accept((PpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getTSpaces() {
    return findChildByType(T_SPACES);
  }

}
