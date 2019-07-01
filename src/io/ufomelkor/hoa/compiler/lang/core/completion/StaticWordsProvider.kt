package io.ufomelkor.hoa.compiler.lang.core.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

internal class StaticWordsProvider(vararg items: String) : CompletionProvider<CompletionParameters>() {
    private val myItems: Array<out String> = items

    public override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        for (item in myItems) {
            result.addElement(LookupElementBuilder.create(item).withCaseSensitivity(false))
        }
    }
}
