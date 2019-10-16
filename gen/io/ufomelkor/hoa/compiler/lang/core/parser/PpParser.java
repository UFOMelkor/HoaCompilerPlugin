// This is a generated file. Not intended for manual editing.
package io.ufomelkor.hoa.compiler.lang.core.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PpParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t instanceof IFileElementType) {
      r = parse_root_(t, b, 0);
    }
    else {
      r = false;
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return File(b, l + 1);
  }

  /* ********************************************************** */
  // (T_CAPTURING_BEGIN (Choice|Concatenation|Repetition|Simple) TreeNode? T_CAPTURING_END?)
  //     | T_CAPTURING_BEGIN
  public static boolean Capturing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Capturing")) return false;
    if (!nextTokenIs(b, T_CAPTURING_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Capturing_0(b, l + 1);
    if (!r) r = consumeToken(b, T_CAPTURING_BEGIN);
    exit_section_(b, m, CAPTURING, r);
    return r;
  }

  // T_CAPTURING_BEGIN (Choice|Concatenation|Repetition|Simple) TreeNode? T_CAPTURING_END?
  private static boolean Capturing_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Capturing_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_CAPTURING_BEGIN);
    r = r && Capturing_0_1(b, l + 1);
    r = r && Capturing_0_2(b, l + 1);
    r = r && Capturing_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Choice|Concatenation|Repetition|Simple
  private static boolean Capturing_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Capturing_0_1")) return false;
    boolean r;
    r = Choice(b, l + 1);
    if (!r) r = Concatenation(b, l + 1);
    if (!r) r = Repetition(b, l + 1);
    if (!r) r = Simple(b, l + 1);
    return r;
  }

  // TreeNode?
  private static boolean Capturing_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Capturing_0_2")) return false;
    TreeNode(b, l + 1);
    return true;
  }

  // T_CAPTURING_END?
  private static boolean Capturing_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Capturing_0_3")) return false;
    consumeToken(b, T_CAPTURING_END);
    return true;
  }

  /* ********************************************************** */
  // T_OR? (Concatenation|Repetition|Simple) (T_OR+ (Concatenation|Repetition|Simple))+ T_OR?
  public static boolean Choice(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Choice")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHOICE, "<choice>");
    r = Choice_0(b, l + 1);
    r = r && Choice_1(b, l + 1);
    r = r && Choice_2(b, l + 1);
    r = r && Choice_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_OR?
  private static boolean Choice_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Choice_0")) return false;
    consumeToken(b, T_OR);
    return true;
  }

  // Concatenation|Repetition|Simple
  private static boolean Choice_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Choice_1")) return false;
    boolean r;
    r = Concatenation(b, l + 1);
    if (!r) r = Repetition(b, l + 1);
    if (!r) r = Simple(b, l + 1);
    return r;
  }

  // (T_OR+ (Concatenation|Repetition|Simple))+
  private static boolean Choice_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Choice_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Choice_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!Choice_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Choice_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // T_OR+ (Concatenation|Repetition|Simple)
  private static boolean Choice_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Choice_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Choice_2_0_0(b, l + 1);
    r = r && Choice_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_OR+
  private static boolean Choice_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Choice_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_OR);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, T_OR)) break;
      if (!empty_element_parsed_guard_(b, "Choice_2_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // Concatenation|Repetition|Simple
  private static boolean Choice_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Choice_2_0_1")) return false;
    boolean r;
    r = Concatenation(b, l + 1);
    if (!r) r = Repetition(b, l + 1);
    if (!r) r = Simple(b, l + 1);
    return r;
  }

  // T_OR?
  private static boolean Choice_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Choice_3")) return false;
    consumeToken(b, T_OR);
    return true;
  }

  /* ********************************************************** */
  // T_COMMENT
  public static boolean Comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Comment")) return false;
    if (!nextTokenIs(b, T_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMENT);
    exit_section_(b, m, COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // (Repetition|Simple) (Repetition|Simple)+ TreeNode?
  public static boolean Concatenation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concatenation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONCATENATION, "<concatenation>");
    r = Concatenation_0(b, l + 1);
    r = r && Concatenation_1(b, l + 1);
    r = r && Concatenation_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Repetition|Simple
  private static boolean Concatenation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concatenation_0")) return false;
    boolean r;
    r = Repetition(b, l + 1);
    if (!r) r = Simple(b, l + 1);
    return r;
  }

  // (Repetition|Simple)+
  private static boolean Concatenation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concatenation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Concatenation_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!Concatenation_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Concatenation_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // Repetition|Simple
  private static boolean Concatenation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concatenation_1_0")) return false;
    boolean r;
    r = Repetition(b, l + 1);
    if (!r) r = Simple(b, l + 1);
    return r;
  }

  // TreeNode?
  private static boolean Concatenation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Concatenation_2")) return false;
    TreeNode(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (Comment|Skip|Token|Rule)*
  static boolean File(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File")) return false;
    while (true) {
      int c = current_position_(b);
      if (!File_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "File", c)) break;
    }
    return true;
  }

  // Comment|Skip|Token|Rule
  private static boolean File_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File_0")) return false;
    boolean r;
    r = Comment(b, l + 1);
    if (!r) r = Skip(b, l + 1);
    if (!r) r = Token(b, l + 1);
    if (!r) r = Rule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_KEPT_BEGIN TokenCall Unification? T_KEPT_END
  public static boolean Kept(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Kept")) return false;
    if (!nextTokenIs(b, T_KEPT_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_KEPT_BEGIN);
    r = r && TokenCall(b, l + 1);
    r = r && Kept_2(b, l + 1);
    r = r && consumeToken(b, T_KEPT_END);
    exit_section_(b, m, KEPT, r);
    return r;
  }

  // Unification?
  private static boolean Kept_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Kept_2")) return false;
    Unification(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // T_NAME
  public static boolean LexemeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LexemeName")) return false;
    if (!nextTokenIs(b, T_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_NAME);
    exit_section_(b, m, LEXEME_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // RuleCall T_NAMED?
  public static boolean Named(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Named")) return false;
    if (!nextTokenIs(b, T_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RuleCall(b, l + 1);
    r = r && Named_1(b, l + 1);
    exit_section_(b, m, NAMED, r);
    return r;
  }

  // T_NAMED?
  private static boolean Named_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Named_1")) return false;
    consumeToken(b, T_NAMED);
    return true;
  }

  /* ********************************************************** */
  // T_NAME
  public static boolean Namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Namespace")) return false;
    if (!nextTokenIs(b, T_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_NAME);
    exit_section_(b, m, NAMESPACE, r);
    return r;
  }

  /* ********************************************************** */
  // T_NAME
  public static boolean NamespaceCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamespaceCall")) return false;
    if (!nextTokenIs(b, T_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_NAME);
    exit_section_(b, m, NAMESPACE_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // T_HASH_LINE_START T_RULE_NAME?
  public static boolean NodeRuleName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NodeRuleName")) return false;
    if (!nextTokenIs(b, T_HASH_LINE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_HASH_LINE_START);
    r = r && NodeRuleName_1(b, l + 1);
    exit_section_(b, m, NODE_RULE_NAME, r);
    return r;
  }

  // T_RULE_NAME?
  private static boolean NodeRuleName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NodeRuleName_1")) return false;
    consumeToken(b, T_RULE_NAME);
    return true;
  }

  /* ********************************************************** */
  // T_ZERO_OR_ONE
  //     | T_ONE_OR_MORE
  //     | T_ZERO_OR_MORE
  //     | T_ZERO_TO_M
  //     | T_N_TO_M
  //     | T_N_OR_MORE
  //     | T_EXACTLY_N
  public static boolean Quantifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Quantifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUANTIFIER, "<quantifier>");
    r = consumeToken(b, T_ZERO_OR_ONE);
    if (!r) r = consumeToken(b, T_ONE_OR_MORE);
    if (!r) r = consumeToken(b, T_ZERO_OR_MORE);
    if (!r) r = consumeToken(b, T_ZERO_TO_M);
    if (!r) r = consumeToken(b, T_N_TO_M);
    if (!r) r = consumeToken(b, T_N_OR_MORE);
    if (!r) r = consumeToken(b, T_EXACTLY_N);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_REGEXP+
  public static boolean RegExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegExp")) return false;
    if (!nextTokenIs(b, T_REGEXP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_REGEXP);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, T_REGEXP)) break;
      if (!empty_element_parsed_guard_(b, "RegExp", c)) break;
    }
    exit_section_(b, m, REG_EXP, r);
    return r;
  }

  /* ********************************************************** */
  // Simple Quantifier
  public static boolean Repetition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Repetition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REPETITION, "<repetition>");
    r = Simple(b, l + 1);
    r = r && Quantifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (RuleName|NodeRuleName) T_COLON? Comment? (Choice|Concatenation|Repetition|Simple)?
  public static boolean Rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule")) return false;
    if (!nextTokenIs(b, "<rule>", T_HASH_LINE_START, T_RULE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE, "<rule>");
    r = Rule_0(b, l + 1);
    r = r && Rule_1(b, l + 1);
    r = r && Rule_2(b, l + 1);
    r = r && Rule_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RuleName|NodeRuleName
  private static boolean Rule_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule_0")) return false;
    boolean r;
    r = RuleName(b, l + 1);
    if (!r) r = NodeRuleName(b, l + 1);
    return r;
  }

  // T_COLON?
  private static boolean Rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule_1")) return false;
    consumeToken(b, T_COLON);
    return true;
  }

  // Comment?
  private static boolean Rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule_2")) return false;
    Comment(b, l + 1);
    return true;
  }

  // (Choice|Concatenation|Repetition|Simple)?
  private static boolean Rule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule_3")) return false;
    Rule_3_0(b, l + 1);
    return true;
  }

  // Choice|Concatenation|Repetition|Simple
  private static boolean Rule_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rule_3_0")) return false;
    boolean r;
    r = Choice(b, l + 1);
    if (!r) r = Concatenation(b, l + 1);
    if (!r) r = Repetition(b, l + 1);
    if (!r) r = Simple(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_NAME
  public static boolean RuleCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleCall")) return false;
    if (!nextTokenIs(b, T_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_NAME);
    exit_section_(b, m, RULE_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // T_RULE_NAME
  public static boolean RuleName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RuleName")) return false;
    if (!nextTokenIs(b, T_RULE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_RULE_NAME);
    exit_section_(b, m, RULE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // (Capturing | Skipped | Kept | Named) TreeNode? Comment?
  public static boolean Simple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Simple")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE, "<simple>");
    r = Simple_0(b, l + 1);
    r = r && Simple_1(b, l + 1);
    r = r && Simple_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Capturing | Skipped | Kept | Named
  private static boolean Simple_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Simple_0")) return false;
    boolean r;
    r = Capturing(b, l + 1);
    if (!r) r = Skipped(b, l + 1);
    if (!r) r = Kept(b, l + 1);
    if (!r) r = Named(b, l + 1);
    return r;
  }

  // TreeNode?
  private static boolean Simple_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Simple_1")) return false;
    TreeNode(b, l + 1);
    return true;
  }

  // Comment?
  private static boolean Simple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Simple_2")) return false;
    Comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // T_SKIP (T_SPACES (Namespace T_COLON)? LexemeName?)? (T_SPACES RegExp)?
  public static boolean Skip(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skip")) return false;
    if (!nextTokenIs(b, T_SKIP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SKIP);
    r = r && Skip_1(b, l + 1);
    r = r && Skip_2(b, l + 1);
    exit_section_(b, m, SKIP, r);
    return r;
  }

  // (T_SPACES (Namespace T_COLON)? LexemeName?)?
  private static boolean Skip_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skip_1")) return false;
    Skip_1_0(b, l + 1);
    return true;
  }

  // T_SPACES (Namespace T_COLON)? LexemeName?
  private static boolean Skip_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skip_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SPACES);
    r = r && Skip_1_0_1(b, l + 1);
    r = r && Skip_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Namespace T_COLON)?
  private static boolean Skip_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skip_1_0_1")) return false;
    Skip_1_0_1_0(b, l + 1);
    return true;
  }

  // Namespace T_COLON
  private static boolean Skip_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skip_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Namespace(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // LexemeName?
  private static boolean Skip_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skip_1_0_2")) return false;
    LexemeName(b, l + 1);
    return true;
  }

  // (T_SPACES RegExp)?
  private static boolean Skip_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skip_2")) return false;
    Skip_2_0(b, l + 1);
    return true;
  }

  // T_SPACES RegExp
  private static boolean Skip_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skip_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SPACES);
    r = r && RegExp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_SKIPPED TokenCall Unification? T_SKIPPED
  public static boolean Skipped(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skipped")) return false;
    if (!nextTokenIs(b, T_SKIPPED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SKIPPED);
    r = r && TokenCall(b, l + 1);
    r = r && Skipped_2(b, l + 1);
    r = r && consumeToken(b, T_SKIPPED);
    exit_section_(b, m, SKIPPED, r);
    return r;
  }

  // Unification?
  private static boolean Skipped_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Skipped_2")) return false;
    Unification(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // T_SWITCH_NAMESPACE T_SPACES? NamespaceCall?
  public static boolean SwitchNamespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchNamespace")) return false;
    if (!nextTokenIs(b, T_SWITCH_NAMESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SWITCH_NAMESPACE);
    r = r && SwitchNamespace_1(b, l + 1);
    r = r && SwitchNamespace_2(b, l + 1);
    exit_section_(b, m, SWITCH_NAMESPACE, r);
    return r;
  }

  // T_SPACES?
  private static boolean SwitchNamespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchNamespace_1")) return false;
    consumeToken(b, T_SPACES);
    return true;
  }

  // NamespaceCall?
  private static boolean SwitchNamespace_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchNamespace_2")) return false;
    NamespaceCall(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // T_TOKEN (T_SPACES (Namespace T_COLON|T_COLON)? LexemeName?)? (T_SPACES RegExp)? (T_SPACES SwitchNamespace)?
  public static boolean Token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token")) return false;
    if (!nextTokenIs(b, T_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_TOKEN);
    r = r && Token_1(b, l + 1);
    r = r && Token_2(b, l + 1);
    r = r && Token_3(b, l + 1);
    exit_section_(b, m, TOKEN, r);
    return r;
  }

  // (T_SPACES (Namespace T_COLON|T_COLON)? LexemeName?)?
  private static boolean Token_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_1")) return false;
    Token_1_0(b, l + 1);
    return true;
  }

  // T_SPACES (Namespace T_COLON|T_COLON)? LexemeName?
  private static boolean Token_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SPACES);
    r = r && Token_1_0_1(b, l + 1);
    r = r && Token_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Namespace T_COLON|T_COLON)?
  private static boolean Token_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_1_0_1")) return false;
    Token_1_0_1_0(b, l + 1);
    return true;
  }

  // Namespace T_COLON|T_COLON
  private static boolean Token_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Token_1_0_1_0_0(b, l + 1);
    if (!r) r = consumeToken(b, T_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // Namespace T_COLON
  private static boolean Token_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Namespace(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // LexemeName?
  private static boolean Token_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_1_0_2")) return false;
    LexemeName(b, l + 1);
    return true;
  }

  // (T_SPACES RegExp)?
  private static boolean Token_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_2")) return false;
    Token_2_0(b, l + 1);
    return true;
  }

  // T_SPACES RegExp
  private static boolean Token_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SPACES);
    r = r && RegExp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_SPACES SwitchNamespace)?
  private static boolean Token_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_3")) return false;
    Token_3_0(b, l + 1);
    return true;
  }

  // T_SPACES SwitchNamespace
  private static boolean Token_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Token_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SPACES);
    r = r && SwitchNamespace(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_NAME
  public static boolean TokenCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TokenCall")) return false;
    if (!nextTokenIs(b, T_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_NAME);
    exit_section_(b, m, TOKEN_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // T_HASH T_NAME?
  public static boolean TreeNode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TreeNode")) return false;
    if (!nextTokenIs(b, T_HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_HASH);
    r = r && TreeNode_1(b, l + 1);
    exit_section_(b, m, TREE_NODE, r);
    return r;
  }

  // T_NAME?
  private static boolean TreeNode_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TreeNode_1")) return false;
    consumeToken(b, T_NAME);
    return true;
  }

  /* ********************************************************** */
  // T_UNIFICATION_BEGIN T_UNIFICATION T_UNIFICATION_END
  public static boolean Unification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Unification")) return false;
    if (!nextTokenIs(b, T_UNIFICATION_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_UNIFICATION_BEGIN, T_UNIFICATION, T_UNIFICATION_END);
    exit_section_(b, m, UNIFICATION, r);
    return r;
  }

}
