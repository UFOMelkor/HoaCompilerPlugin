package io.ufomelkor.hoa.compiler.lang.core.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes.*;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.psi.TokenType.BAD_CHARACTER;

%%

%class PpLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}
%{
    private int vSpaces = 0;
%}

EOL=\R
T_SPACES=[ \t\f]+
WHITE_SPACE=\s+

T_COMMENT = \/\/[^\n\r]*
T_COMMENT_ONE_SLASH = \/[^\n\r]*
T_SKIP = "%skip"
T_TOKEN = "%token"
T_SWITCH_NAMESPACE = "->"
T_NAME = [a-zA-Z_][a-zA-Z0-9_]*
T_COLON = ":"
T_REGEXP = [^\s:a-zA-Z0-9_]+
T_NUMBER = [0-9]+

T_HASH = "#"
T_OR = "|"
T_ZERO_OR_ONE = "?"
T_ONE_OR_MORE = "+"
T_ZERO_OR_MORE = "*"
T_N_TO_M = \{\s*[0-9]+\s*,\s*[0-9]+\s*\}
T_ZERO_TO_M = \{\s*,\s*[0-9]+\}
T_N_OR_MORE = \{\s*[0-9]+\s*,\s*\}
T_EXACTLY_N = \{\s*[0-9]+\s*\}
T_SKIPPED = "::"
T_KEPT_BEGIN = "<"
T_KEPT_END = ">"
T_NAMED = "()"
T_CAPTURING_BEGIN = "("
T_CAPTURING_END = ")"
T_UNIFICATION_BEGIN = "["
T_UNIFICATION = [0-9]+
T_UNIFICATION_END = "]"

%state LEXEME, RULE, RULE_NAME

%%

<YYINITIAL> {
    {WHITE_SPACE}           { return WHITE_SPACE; }
    {T_COMMENT}             { return T_COMMENT; }
    ^{T_COMMENT_ONE_SLASH}  { return T_COMMENT; }
    {T_SKIP}                { vSpaces = 0; yybegin(LEXEME); return T_SKIP; }
    {T_TOKEN}               { vSpaces = 0; yybegin(LEXEME); return T_TOKEN; }
    {T_SWITCH_NAMESPACE}    { vSpaces = 0; return T_SWITCH_NAMESPACE; }
    ^{T_NAME}               { yybegin(RULE); return T_RULE_NAME; }
    [^]                     { return BAD_CHARACTER; }
}

<LEXEME> {
    {T_SWITCH_NAMESPACE}  { vSpaces = 0; return T_SWITCH_NAMESPACE; }
    {T_SPACES} { vSpaces += 1; return T_SPACES; }
    {T_NAME}   { return vSpaces > 1 ? T_REGEXP : T_NAME; }
    {T_COLON}  { return vSpaces > 1 ? T_REGEXP : T_COLON; }
    {T_NUMBER} { return T_REGEXP; }
    {T_REGEXP} { if (yytext().equals("->")) { vSpaces = 0; return T_SWITCH_NAMESPACE;} return T_REGEXP; }
    \R         { yybegin(YYINITIAL); return WHITE_SPACE; }
    [^]        { return BAD_CHARACTER; }
}

<RULE> {
    {WHITE_SPACE}           { return WHITE_SPACE; }
    ^{T_NAME}               { return T_RULE_NAME; }
    {T_NAME}                { return T_NAME; }
    ^{T_HASH}               { yybegin(RULE_NAME); return T_HASH; }
    {T_HASH}                { return T_HASH; }
    {T_COMMENT}             { return T_COMMENT; }
    ^{T_COMMENT_ONE_SLASH}  { return T_COMMENT; }
    {T_COLON}               { return T_COLON; }
    {T_OR}                  { return T_OR; }
    {T_ZERO_OR_ONE}         { return T_ZERO_OR_ONE; }
    {T_ONE_OR_MORE}         { return T_ONE_OR_MORE; }
    {T_ZERO_OR_MORE}        { return T_ZERO_OR_MORE; }
    {T_N_TO_M}              { return T_N_TO_M; }
    {T_ZERO_TO_M}           { return T_ZERO_TO_M; }
    {T_N_OR_MORE}           { return T_N_OR_MORE; }
    {T_EXACTLY_N}           { return T_EXACTLY_N; }
    {T_SKIPPED}             { return T_SKIPPED; }
    {T_KEPT_BEGIN}          { return T_KEPT_BEGIN; }
    {T_KEPT_END}            { return T_KEPT_END; }
    {T_NAMED}               { return T_NAMED; }
    {T_CAPTURING_BEGIN}     { return T_CAPTURING_BEGIN; }
    {T_CAPTURING_END}       { return T_CAPTURING_END; }
    {T_UNIFICATION_BEGIN}   { return T_UNIFICATION_BEGIN; }
    {T_UNIFICATION}         { return T_UNIFICATION; }
    {T_UNIFICATION_END}     { return T_UNIFICATION_END; }
    [^]                     { return BAD_CHARACTER; }
}

<RULE_NAME> {
    {T_NAME}    { yybegin(RULE); return T_RULE_NAME; }
    {T_COLON}   { yybegin(RULE); return T_COLON; }
    [^]         { return BAD_CHARACTER; }
}
