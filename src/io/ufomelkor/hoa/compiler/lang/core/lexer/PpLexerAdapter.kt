package io.ufomelkor.hoa.compiler.lang.core.lexer

import com.intellij.lexer.FlexAdapter

import java.io.Reader

class PpLexerAdapter : FlexAdapter(PpLexer(null as Reader?))
