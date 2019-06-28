package io.ufomelkor.hoa.compiler.plugin.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import io.ufomelkor.hoa.compiler.lang.core.lexer.PpLexerAdapter
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes

class PpSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        val COMMENT = createTextAttributesKey("PP_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

        val SKIP_KEYWORD = createTextAttributesKey("PP_SKIP", DefaultLanguageHighlighterColors.KEYWORD)
        val TOKEN_KEYWORD = createTextAttributesKey("PP_TOKEN", DefaultLanguageHighlighterColors.KEYWORD)
        val SWITCH_NAMESPACE = createTextAttributesKey("PP_SWITCH_NAMESPACE", DefaultLanguageHighlighterColors.KEYWORD)

        val SKIP_NAME = createTextAttributesKey("PP_SKIP_NAME", DefaultLanguageHighlighterColors.IDENTIFIER)
        val TOKEN_NAME = createTextAttributesKey("PP_TOKEN_NAME", DefaultLanguageHighlighterColors.IDENTIFIER)

        val REGEXP = createTextAttributesKey("PP_REGEXP", DefaultLanguageHighlighterColors.STRING)

        val NODE = createTextAttributesKey("PP_NODE", DefaultLanguageHighlighterColors.CLASS_NAME)

        val RULE_NAME = createTextAttributesKey("PP_RULE_NAME", DefaultLanguageHighlighterColors.INTERFACE_NAME)

        val UNIFICATION = createTextAttributesKey("PP_UNIFICATION", DefaultLanguageHighlighterColors.BRACKETS)
        val GROUP = createTextAttributesKey("PP_GROUP", DefaultLanguageHighlighterColors.PARENTHESES)
        val DISJUNCTION = createTextAttributesKey("PP_DISJUNCTION", DefaultLanguageHighlighterColors.COMMA)
        val QUANTIFIER = createTextAttributesKey("PP_QUANTIFIER", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val RULE_CALL = createTextAttributesKey("PP_RULE_CALL", DefaultLanguageHighlighterColors.CLASS_REFERENCE)
        val COLON = createTextAttributesKey("PP_COLON", DefaultLanguageHighlighterColors.OPERATION_SIGN)

        val NAMESPACE = createTextAttributesKey("PP_NAMESPACE", DefaultLanguageHighlighterColors.PARAMETER)
        val KEPT_TOKEN = createTextAttributesKey("PP_KEPT_TOKEN", DefaultLanguageHighlighterColors.PARAMETER)
        val SKIPPED_TOKEN = createTextAttributesKey("PP_SKIPPED_TOKEN", DefaultLanguageHighlighterColors.IDENTIFIER)

        val BAD_CHARACTER = createTextAttributesKey("PP_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val COLON_KEYS = arrayOf(COLON)
        private val SKIP_KEYWORD_KEYS = arrayOf(SKIP_KEYWORD)
        private val TOKEN_KEYWORD_KEYS = arrayOf(TOKEN_KEYWORD)
        private val SWITCH_NAMESPACE_KEYS = arrayOf(SWITCH_NAMESPACE)
        private val REGEXP_KEYS = arrayOf(REGEXP)
        private val RULE_NAME_KEYS = arrayOf(RULE_NAME)
        private val QUANTIFIER_KEYS = arrayOf(QUANTIFIER)
        private val UNIFICATION_KEYS = arrayOf(UNIFICATION)
        private val GROUP_KEYS = arrayOf(GROUP)
        private val DISJUNCTION_KEYS = arrayOf(DISJUNCTION)
        private val KEPT_TOKEN_KEYS = arrayOf(KEPT_TOKEN)
        private val SKIPPED_TOKEN_KEYS = arrayOf(SKIPPED_TOKEN)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when(tokenType) {
            PpTypes.T_COMMENT -> COMMENT_KEYS
            PpTypes.T_COLON -> COLON_KEYS
            PpTypes.T_SKIP -> SKIP_KEYWORD_KEYS
            PpTypes.T_TOKEN -> TOKEN_KEYWORD_KEYS
            PpTypes.T_SWITCH_NAMESPACE -> SWITCH_NAMESPACE_KEYS
            PpTypes.T_REGEXP -> REGEXP_KEYS
            PpTypes.T_RULE_NAME -> RULE_NAME_KEYS
            PpTypes.T_ZERO_OR_ONE -> QUANTIFIER_KEYS
            PpTypes.T_ONE_OR_MORE -> QUANTIFIER_KEYS
            PpTypes.T_ZERO_OR_MORE -> QUANTIFIER_KEYS
            PpTypes.T_N_TO_M -> QUANTIFIER_KEYS
            PpTypes.T_ZERO_TO_M -> QUANTIFIER_KEYS
            PpTypes.T_EXACTLY_N -> QUANTIFIER_KEYS
            PpTypes.T_UNIFICATION_BEGIN -> UNIFICATION_KEYS
            PpTypes.T_UNIFICATION -> UNIFICATION_KEYS
            PpTypes.T_UNIFICATION_END -> UNIFICATION_KEYS
            PpTypes.T_CAPTURING_BEGIN -> GROUP_KEYS
            PpTypes.T_CAPTURING_END -> GROUP_KEYS
            PpTypes.T_OR -> DISJUNCTION_KEYS
            PpTypes.T_KEPT_BEGIN -> KEPT_TOKEN_KEYS
            PpTypes.T_KEPT_END -> KEPT_TOKEN_KEYS
            PpTypes.T_SKIPPED -> SKIPPED_TOKEN_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    override fun getHighlightingLexer(): Lexer {
        return PpLexerAdapter()
    }
}