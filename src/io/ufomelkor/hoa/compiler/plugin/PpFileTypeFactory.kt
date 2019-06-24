package io.ufomelkor.hoa.compiler.plugin


import com.intellij.openapi.fileTypes.*

class PpFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(PpFileType.INSTANCE, PpFileType.INSTANCE.defaultExtension)
    }
}
