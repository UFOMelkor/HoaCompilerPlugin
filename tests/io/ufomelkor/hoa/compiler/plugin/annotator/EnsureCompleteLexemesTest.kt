package io.ufomelkor.hoa.compiler.plugin.annotator

class EnsureCompleteLexemesTest : AnnotatorTestCase() {
    fun `test it should not annotate a minimal skip`()
        = checkErrors("%skip space \\s")

    fun `test it should not annotate a full token`()
        = checkErrors("%token quote_ \" -> quote")

    fun `test it should annotate a skip keyword without any followers with an error`()
        = checkErrors("%ski<error descr=\"Expected name\">p</error>")

    fun `test it should annotate a skip keyword with namespace but without name with an error`()
        = checkErrors("%skip op<error descr=\"Expected name\">:</error>")

    fun `test it should annotate a skip without a regexp with an error`()
        = checkErrors("%skip spac<error descr=\"Expected regular expression\">e</error>")

    fun `test it should not annotate a minimal token`()
        = checkErrors("%token string_ \"")

    fun `test it should annotate a token keyword without any followers with an error`()
        = checkErrors("%toke<error descr=\"Expected name\">n</error>")

    fun `test it should annotate a token keyword with namespace but without name with an error`()
        = checkErrors("%skip op<error descr=\"Expected name\">:</error>")

    fun `test it should annotate a token without a regexp with an error`()
        = checkErrors("%token string<error descr=\"Expected regular expression\">_</error>")

    fun `test it should annotate a token with switch but without a namespace with an error`()
        = checkErrors("%token quote_ \" <error descr=\"Expected namespace\">-> </error>")

    fun `test it should annotate a token name with a leading colon with an error`()
        = checkErrors("%token <error descr=\"Expected namespace or name, got colon\">:</error>string_ \"")
}
