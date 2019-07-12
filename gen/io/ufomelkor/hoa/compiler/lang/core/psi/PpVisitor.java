// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpElement;
import io.ufomelkor.hoa.compiler.lang.core.psi.ext.PpLexeme;

public class PpVisitor extends PsiElementVisitor {

  public void visitCapturing(@NotNull PpCapturing o) {
    visitElement(o);
  }

  public void visitChoice(@NotNull PpChoice o) {
    visitElement(o);
  }

  public void visitComment(@NotNull PpComment o) {
    visitElement(o);
  }

  public void visitConcatenation(@NotNull PpConcatenation o) {
    visitElement(o);
  }

  public void visitKept(@NotNull PpKept o) {
    visitElement(o);
  }

  public void visitLexemeName(@NotNull PpLexemeName o) {
    visitElement(o);
  }

  public void visitNamed(@NotNull PpNamed o) {
    visitElement(o);
  }

  public void visitNamespace(@NotNull PpNamespace o) {
    visitElement(o);
  }

  public void visitNamespaceCall(@NotNull PpNamespaceCall o) {
    visitElement(o);
  }

  public void visitNodeRuleName(@NotNull PpNodeRuleName o) {
    visitElement(o);
  }

  public void visitQuantifier(@NotNull PpQuantifier o) {
    visitElement(o);
  }

  public void visitRegExp(@NotNull PpRegExp o) {
    visitElement(o);
  }

  public void visitRepetition(@NotNull PpRepetition o) {
    visitElement(o);
  }

  public void visitRule(@NotNull PpRule o) {
    visitElement(o);
  }

  public void visitRuleCall(@NotNull PpRuleCall o) {
    visitElement(o);
  }

  public void visitRuleName(@NotNull PpRuleName o) {
    visitElement(o);
  }

  public void visitSimple(@NotNull PpSimple o) {
    visitElement(o);
  }

  public void visitSkip(@NotNull PpSkip o) {
    visitLexeme(o);
  }

  public void visitSkipped(@NotNull PpSkipped o) {
    visitElement(o);
  }

  public void visitSwitchNamespace(@NotNull PpSwitchNamespace o) {
    visitElement(o);
  }

  public void visitToken(@NotNull PpToken o) {
    visitLexeme(o);
  }

  public void visitTokenCall(@NotNull PpTokenCall o) {
    visitElement(o);
  }

  public void visitTreeNode(@NotNull PpTreeNode o) {
    visitElement(o);
  }

  public void visitUnification(@NotNull PpUnification o) {
    visitElement(o);
  }

  public void visitLexeme(@NotNull PpLexeme o) {
    visitElement(o);
  }

  public void visitElement(@NotNull PpElement o) {
    super.visitElement(o);
  }

}
