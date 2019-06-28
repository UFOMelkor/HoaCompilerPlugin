package io.ufomelkor.hoa.compiler.lang

import com.intellij.openapi.fileTypes.*
import io.ufomelkor.hoa.compiler.lang.PpFileType

class PpFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(PpFileType.INSTANCE, PpFileType.INSTANCE.defaultExtension)
    }
}
