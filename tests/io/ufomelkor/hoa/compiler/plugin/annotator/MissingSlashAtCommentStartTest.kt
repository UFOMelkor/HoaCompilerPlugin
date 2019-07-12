package io.ufomelkor.hoa.compiler.plugin.annotator

class MissingSlashAtCommentStartTest : AnnotatorTestCase() {
    fun `test it should annotate a comment starting with just one slash with an error`()
        = checkErrors("""
            <error descr="Missing second slash">/ Abc</error>
        """.trimIndent())

    fun `test it should annotate an invalid comment with an error also if it is positioned between two rules`()
        = checkErrors("""
            foo:
                bar()
                
            <error descr="Missing second slash">/ Abc</error>
            
            bar:
                foo()
            """.trimIndent())

    fun `test it should not annotate a comment beginning with two slashes with an error`()
        = checkErrors("""
            // Abc
        """.trimIndent())
}
