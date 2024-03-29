package io.ufomelkor.hoa.compiler.lang.core.parser

import com.intellij.lang.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.*
import com.intellij.psi.tree.*
import io.ufomelkor.hoa.compiler.lang.core.psi.PpTypes
import io.ufomelkor.hoa.compiler.lang.PpLanguage
import io.ufomelkor.hoa.compiler.lang.core.lexer.PpLexerAdapter
import io.ufomelkor.hoa.compiler.plugin.psi.PpFile

class PpParserDefinition : ParserDefinition {
    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(PpTypes.COMMENT)

        val FILE = IFileElementType(PpLanguage.INSTANCE)
    }

    override fun createLexer(project: Project): Lexer {
        return PpLexerAdapter()
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return PpParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return PpFile(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun createElement(node: ASTNode): PsiElement {
        return PpTypes.Factory.createElement(node)
    }
}
