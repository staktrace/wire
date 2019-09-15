// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: one_of.proto
package com.squareup.wire.protos.kotlin

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireField
import com.squareup.wire.internal.countNonNull
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.hashCode
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * It's a one of message.
 */
class OneOfMessage(
  /**
   * What foo.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  @JvmField
  val foo: Int? = null,
  /**
   * Such bar.
   */
  @field:WireField(
    tag = 3,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  @JvmField
  val bar: String? = null,
  /**
   * Nice baz.
   */
  @field:WireField(
    tag = 4,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  @JvmField
  val baz: String? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<OneOfMessage, OneOfMessage.Builder>(ADAPTER, unknownFields) {
  init {
    require(countNonNull(foo, bar, baz) <= 1) {
      "At most one of foo, bar, baz may be non-null"
    }
  }

  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.foo = foo
    builder.bar = bar
    builder.baz = baz
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is OneOfMessage) return false
    return unknownFields == other.unknownFields
        && foo == other.foo
        && bar == other.bar
        && baz == other.baz
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + foo.hashCode()
      result = result * 37 + bar.hashCode()
      result = result * 37 + baz.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (foo != null) result += """foo=$foo"""
    if (bar != null) result += """bar=$bar"""
    if (baz != null) result += """baz=$baz"""
    return result.joinToString(prefix = "OneOfMessage{", separator = ", ", postfix = "}")
  }

  fun copy(
    foo: Int? = this.foo,
    bar: String? = this.bar,
    baz: String? = this.baz,
    unknownFields: ByteString = this.unknownFields
  ): OneOfMessage = OneOfMessage(foo, bar, baz, unknownFields)

  class Builder : Message.Builder<OneOfMessage, Builder>() {
    @JvmField
    var foo: Int? = null

    @JvmField
    var bar: String? = null

    @JvmField
    var baz: String? = null

    /**
     * What foo.
     */
    fun foo(foo: Int): Builder {
      this.foo = foo
      return this
    }

    /**
     * Such bar.
     */
    fun bar(bar: String): Builder {
      this.bar = bar
      return this
    }

    /**
     * Nice baz.
     */
    fun baz(baz: String): Builder {
      this.baz = baz
      return this
    }

    override fun build(): OneOfMessage = OneOfMessage(
      foo = foo,
      bar = bar,
      baz = baz,
      unknownFields = buildUnknownFields()
    )
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<OneOfMessage> = object : ProtoAdapter<OneOfMessage>(
      FieldEncoding.LENGTH_DELIMITED, 
      OneOfMessage::class
    ) {
      override fun encodedSize(value: OneOfMessage): Int = 
        ProtoAdapter.INT32.encodedSizeWithTag(1, value.foo) +
        ProtoAdapter.STRING.encodedSizeWithTag(3, value.bar) +
        ProtoAdapter.STRING.encodedSizeWithTag(4, value.baz) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: OneOfMessage) {
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.foo)
        ProtoAdapter.STRING.encodeWithTag(writer, 3, value.bar)
        ProtoAdapter.STRING.encodeWithTag(writer, 4, value.baz)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): OneOfMessage {
        var foo: Int? = null
        var bar: String? = null
        var baz: String? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> foo = ProtoAdapter.INT32.decode(reader)
            3 -> bar = ProtoAdapter.STRING.decode(reader)
            4 -> baz = ProtoAdapter.STRING.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return OneOfMessage(
          foo = foo,
          bar = bar,
          baz = baz,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: OneOfMessage): OneOfMessage = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
