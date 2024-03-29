// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.ufomelkor.hoa.compiler.lang.core.psi.impl.*;

public interface PpTypes {

  IElementType CAPTURING = new PpElementType("CAPTURING");
  IElementType CHOICE = new PpElementType("CHOICE");
  IElementType COMMENT = new PpElementType("COMMENT");
  IElementType CONCATENATION = new PpElementType("CONCATENATION");
  IElementType KEPT = new PpElementType("KEPT");
  IElementType LEXEME_NAME = new PpElementType("LEXEME_NAME");
  IElementType NAMED = new PpElementType("NAMED");
  IElementType NAMESPACE = new PpElementType("NAMESPACE");
  IElementType NAMESPACE_CALL = new PpElementType("NAMESPACE_CALL");
  IElementType NODE_RULE_NAME = new PpElementType("NODE_RULE_NAME");
  IElementType QUANTIFIER = new PpElementType("QUANTIFIER");
  IElementType REG_EXP = new PpElementType("REG_EXP");
  IElementType REPETITION = new PpElementType("REPETITION");
  IElementType RULE = new PpElementType("RULE");
  IElementType RULE_CALL = new PpElementType("RULE_CALL");
  IElementType RULE_NAME = new PpElementType("RULE_NAME");
  IElementType SIMPLE = new PpElementType("SIMPLE");
  IElementType SKIP = new PpElementType("SKIP");
  IElementType SKIPPED = new PpElementType("SKIPPED");
  IElementType SWITCH_NAMESPACE = new PpElementType("SWITCH_NAMESPACE");
  IElementType TOKEN = new PpElementType("TOKEN");
  IElementType TOKEN_CALL = new PpElementType("TOKEN_CALL");
  IElementType TREE_NODE = new PpElementType("TREE_NODE");
  IElementType UNIFICATION = new PpElementType("UNIFICATION");

  IElementType T_CAPTURING_BEGIN = new PpTokenType("(");
  IElementType T_CAPTURING_END = new PpTokenType(")");
  IElementType T_COLON = new PpTokenType(":");
  IElementType T_COMMENT = new PpTokenType("//[^\\n\\r]*");
  IElementType T_EXACTLY_N = new PpTokenType("T_EXACTLY_N");
  IElementType T_HASH = new PpTokenType("#");
  IElementType T_HASH_LINE_START = new PpTokenType("T_HASH_LINE_START");
  IElementType T_KEPT_BEGIN = new PpTokenType("<");
  IElementType T_KEPT_END = new PpTokenType(">");
  IElementType T_NAME = new PpTokenType("[a-zA-Z_][a-zA-Z0-9_]*");
  IElementType T_NAMED = new PpTokenType("()");
  IElementType T_N_OR_MORE = new PpTokenType("T_N_OR_MORE");
  IElementType T_N_TO_M = new PpTokenType("T_N_TO_M");
  IElementType T_ONE_OR_MORE = new PpTokenType("+");
  IElementType T_OR = new PpTokenType("|");
  IElementType T_REGEXP = new PpTokenType("T_REGEXP");
  IElementType T_RULE_NAME = new PpTokenType("T_RULE_NAME");
  IElementType T_SKIP = new PpTokenType("%skip");
  IElementType T_SKIPPED = new PpTokenType("::");
  IElementType T_SPACES = new PpTokenType("T_SPACES");
  IElementType T_SWITCH_NAMESPACE = new PpTokenType("->");
  IElementType T_TOKEN = new PpTokenType("%token");
  IElementType T_UNIFICATION = new PpTokenType("T_UNIFICATION");
  IElementType T_UNIFICATION_BEGIN = new PpTokenType("[");
  IElementType T_UNIFICATION_END = new PpTokenType("]");
  IElementType T_ZERO_OR_MORE = new PpTokenType("*");
  IElementType T_ZERO_OR_ONE = new PpTokenType("?");
  IElementType T_ZERO_TO_M = new PpTokenType("T_ZERO_TO_M");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CAPTURING) {
        return new PpCapturingImpl(node);
      }
      else if (type == CHOICE) {
        return new PpChoiceImpl(node);
      }
      else if (type == COMMENT) {
        return new PpCommentImpl(node);
      }
      else if (type == CONCATENATION) {
        return new PpConcatenationImpl(node);
      }
      else if (type == KEPT) {
        return new PpKeptImpl(node);
      }
      else if (type == LEXEME_NAME) {
        return new PpLexemeNameImpl(node);
      }
      else if (type == NAMED) {
        return new PpNamedImpl(node);
      }
      else if (type == NAMESPACE) {
        return new PpNamespaceImpl(node);
      }
      else if (type == NAMESPACE_CALL) {
        return new PpNamespaceCallImpl(node);
      }
      else if (type == NODE_RULE_NAME) {
        return new PpNodeRuleNameImpl(node);
      }
      else if (type == QUANTIFIER) {
        return new PpQuantifierImpl(node);
      }
      else if (type == REG_EXP) {
        return new PpRegExpImpl(node);
      }
      else if (type == REPETITION) {
        return new PpRepetitionImpl(node);
      }
      else if (type == RULE) {
        return new PpRuleImpl(node);
      }
      else if (type == RULE_CALL) {
        return new PpRuleCallImpl(node);
      }
      else if (type == RULE_NAME) {
        return new PpRuleNameImpl(node);
      }
      else if (type == SIMPLE) {
        return new PpSimpleImpl(node);
      }
      else if (type == SKIP) {
        return new PpSkipImpl(node);
      }
      else if (type == SKIPPED) {
        return new PpSkippedImpl(node);
      }
      else if (type == SWITCH_NAMESPACE) {
        return new PpSwitchNamespaceImpl(node);
      }
      else if (type == TOKEN) {
        return new PpTokenImpl(node);
      }
      else if (type == TOKEN_CALL) {
        return new PpTokenCallImpl(node);
      }
      else if (type == TREE_NODE) {
        return new PpTreeNodeImpl(node);
      }
      else if (type == UNIFICATION) {
        return new PpUnificationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
