// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.SomeRequest in service_kotlin_with_all_flags.proto
package com.squareup.wire.protos.kotlin.services.all_flags_on

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.`internal`.JvmField
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import okio.ByteString

public class SomeRequest internal constructor(
  unknownFields: ByteString = ByteString.EMPTY,
) : Message<SomeRequest, SomeRequest.Builder>(ADAPTER, unknownFields) {
  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is SomeRequest) return false
    if (unknownFields != other.unknownFields) return false
    return true
  }

  override fun hashCode(): Int = unknownFields.hashCode()

  override fun toString(): String = "SomeRequest{}"

  public fun copy(unknownFields: ByteString = this.unknownFields): SomeRequest =
      SomeRequest(unknownFields)

  public class Builder : Message.Builder<SomeRequest, Builder>() {
    override fun build(): SomeRequest = SomeRequest(
      unknownFields = buildUnknownFields()
    )
  }

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<SomeRequest> = object : ProtoAdapter<SomeRequest>(
      FieldEncoding.LENGTH_DELIMITED, 
      SomeRequest::class, 
      "type.googleapis.com/squareup.protos.kotlin.SomeRequest", 
      PROTO_2, 
      null, 
      "service_kotlin_with_all_flags.proto"
    ) {
      override fun encodedSize(`value`: SomeRequest): Int {
        var size = value.unknownFields.size
        return size
      }

      override fun encode(writer: ProtoWriter, `value`: SomeRequest) {
        writer.writeBytes(value.unknownFields)
      }

      override fun encode(writer: ReverseProtoWriter, `value`: SomeRequest) {
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): SomeRequest {
        val unknownFields = reader.forEachTag(reader::readUnknownField)
        return SomeRequest(
          unknownFields = unknownFields
        )
      }

      override fun redact(`value`: SomeRequest): SomeRequest = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
