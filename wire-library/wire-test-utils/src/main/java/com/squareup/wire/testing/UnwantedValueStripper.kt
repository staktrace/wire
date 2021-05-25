package com.squareup.wire.testing

import com.google.protobuf.DescriptorProtos.DescriptorProto
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto
import com.google.protobuf.DescriptorProtos.FileDescriptorProto

class UnwantedValueStripper(
  val clearJsonName: Boolean = false
) {

  /**
   * TODO: this strips defaults as they're not yet consistent with protoc. We should fix the
   *     implementation to match protoc.
   */
  fun stripOptionsAndDefaults(fileDescriptorProto: FileDescriptorProto): FileDescriptorProto {
    val messageTypeList = fileDescriptorProto.messageTypeList.map { stripOptionsAndDefaults(it) }
    val extensionList = fileDescriptorProto.extensionList.map { stripOptionsAndDefaults(it) }
    return fileDescriptorProto.toBuilder()
      .clearMessageType()
      .addAllMessageType(messageTypeList)
      .clearExtension()
      .addAllExtension(extensionList)
      .build()
  }

  fun stripOptionsAndDefaults(descriptorProto: DescriptorProto): DescriptorProto {
    val nestedTypeList = descriptorProto.nestedTypeList.map { stripOptionsAndDefaults(it) }
    val fieldList = descriptorProto.fieldList.map { stripOptionsAndDefaults(it) }
    return descriptorProto.toBuilder()
      .clearNestedType()
      .addAllNestedType(nestedTypeList)
      .clearField()
      .addAllField(fieldList)
      .clearExtensionRange()
      .build()
  }

  fun stripOptionsAndDefaults(fieldDescriptorProto: FieldDescriptorProto): FieldDescriptorProto {
    return fieldDescriptorProto.toBuilder()
      .clearDefaultValue()
      .apply {
        if (clearJsonName) {
          clearJsonName()
        }
      }
      .build()
  }

}
