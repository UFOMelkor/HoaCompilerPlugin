package io.ufomelkor.hoa.compiler.lang.core.psi.ext

import io.ufomelkor.hoa.compiler.lang.core.psi.PpNamespace
import io.ufomelkor.hoa.compiler.lang.core.psi.PpRegExp
import io.ufomelkor.hoa.compiler.lang.core.psi.PpLexemeName

interface PpLexeme : PpNamedElement {
    val namespace: PpNamespace?
    val regExp: PpRegExp?
    val lexemeName: PpLexemeName?
    val currentNamespace: String
}
