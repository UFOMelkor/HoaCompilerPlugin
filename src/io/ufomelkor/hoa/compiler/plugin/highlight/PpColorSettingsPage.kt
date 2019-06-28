package io.ufomelkor.hoa.compiler.plugin.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.*
import io.ufomelkor.hoa.compiler.plugin.icons.PpIcons

import javax.swing.*

class PpColorSettingsPage : ColorSettingsPage {

    companion object {
        private val DESCRIPTORS = arrayOf(
                AttributesDescriptor("Comment", PpSyntaxHighlighter.COMMENT),
                AttributesDescriptor("Skip keyword", PpSyntaxHighlighter.SKIP_KEYWORD),
                AttributesDescriptor("Skip name", PpSyntaxHighlighter.SKIP_NAME),
                AttributesDescriptor("Token keyword", PpSyntaxHighlighter.TOKEN_KEYWORD),
                AttributesDescriptor("Token name", PpSyntaxHighlighter.TOKEN_NAME),
                AttributesDescriptor("RegExp", PpSyntaxHighlighter.REGEXP),
                AttributesDescriptor("Node", PpSyntaxHighlighter.NODE),
                AttributesDescriptor("Rule name", PpSyntaxHighlighter.RULE_NAME),
                AttributesDescriptor("Quantifier", PpSyntaxHighlighter.QUANTIFIER),
                AttributesDescriptor("Unification", PpSyntaxHighlighter.UNIFICATION),
                AttributesDescriptor("Group", PpSyntaxHighlighter.GROUP),
                AttributesDescriptor("Rule call", PpSyntaxHighlighter.RULE_CALL),
                AttributesDescriptor("Colon", PpSyntaxHighlighter.COLON),
                AttributesDescriptor("Switch namespace", PpSyntaxHighlighter.SWITCH_NAMESPACE),
                AttributesDescriptor("Namespace", PpSyntaxHighlighter.NAMESPACE),
                AttributesDescriptor("Disjunction", PpSyntaxHighlighter.DISJUNCTION),
                AttributesDescriptor("Kept token", PpSyntaxHighlighter.KEPT_TOKEN),
                AttributesDescriptor("Skipped token", PpSyntaxHighlighter.SKIPPED_TOKEN)
        )
    }

    override fun getIcon(): Icon? {
        return PpIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return PpSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """%skip   <SkipName>space</SkipName>          \s
// Scalars.
%token  <TokenName>true</TokenName>           true
%token  <TokenName>false</TokenName>          false
%token  <TokenName>null</TokenName>           null
// Strings.
%token  <TokenName>quote_</TokenName>         "        -> <Namespace>string</Namespace>
%token  <Namespace>string</Namespace>:<TokenName>string</TokenName>  [^"]+
%token  <Namespace>string</Namespace>:<TokenName>_quote</TokenName>  "        -> <Namespace>default</Namespace>
// Objects.
%token  <TokenName>brace_</TokenName>         {
%token <TokenName>_brace</TokenName>          }
// Arrays.
%token  <TokenName>bracket_</TokenName>       \[
%token <TokenName>_bracket</TokenName>        \]
// Rest.
%token  <TokenName>colon</TokenName>          :
%token  <TokenName>comma</TokenName>          ,
%token  <TokenName>number</TokenName>         \d+

value:
    <KeptToken><true></KeptToken> | <KeptToken><false></KeptToken> | <KeptToken><null></KeptToken> | <RuleCall>string()</RuleCall> | <RuleCall>object()</RuleCall> | <RuleCall>array()</RuleCall> | <RuleCall>number()</RuleCall>

string:
    <SkippedToken>::quote_::<SkippedToken> <KeptToken><string></KeptToken> <SkippedToken>::_quote::</SkippedToken>

number:
    <KeptToken><number></KeptToken>

<Node>#object</Node>:
    <SkippedToken>::brace_::</SkippedToken> <RuleCall>pair()</RuleCall> ( <SkippedToken>::comma::</SkippedToken> <RuleCall>pair()</RuleCall> )* <SkippedToken>::_brace::</SkippedToken>

<Node>#pair</Node>:
    <RuleCall>string()</RuleCall> <SkippedToken>::colon::</SkippedToken> <RuleCall>value()</RuleCall>

<Node>#array</Node>:
    <SkippedToken>::bracket_::</SkippedToken> <RuleCall>value()</RuleCall> ( <SkippedToken>::comma::</SkippedToken> <RuleCall>value()</RuleCall> )* <SkippedToken>::_bracket::</SkippedToken>
"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return mapOf(
                "Node" to PpSyntaxHighlighter.NODE,
                "SkipName" to PpSyntaxHighlighter.SKIP_NAME,
                "TokenName" to PpSyntaxHighlighter.TOKEN_NAME,
                "RuleCall" to PpSyntaxHighlighter.RULE_CALL,
                "Namespace" to PpSyntaxHighlighter.NAMESPACE,
                "KeptToken" to PpSyntaxHighlighter.KEPT_TOKEN,
                "SkippedToken" to PpSyntaxHighlighter.SKIPPED_TOKEN
        )
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Hoa\\Compiler PP"
    }
}