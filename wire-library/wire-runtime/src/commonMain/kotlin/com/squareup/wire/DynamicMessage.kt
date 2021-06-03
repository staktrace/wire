/*
 * Copyright 2021 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire

import okio.Buffer
import okio.ByteString

class DynamicMessage(val data: ByteString) {
  private val reader = ProtoReader(Buffer().write(data))

  private val tagToOffsets: Map<Int, List<Long>> = run {
    val result = mutableMapOf<Int, MutableList<Long>>()
    reader.forEachTag { tag ->
      val offsets = result.getOrPut(tag) { mutableListOf() }
      offsets.add(reader.pos)
    }
    return@run result
  }

  fun get(tag: Int): ByteString {
    return getList(tag).first()
  }

  fun getList(tag: Int): List<ByteString> {
    val result = mutableListOf<ByteString>()
    for (offset in tagToOffsets[tag]!!) {
      reader.move(offset)
      result += reader.readBytes()
    }
    return result
  }

  fun getString(tag: Int): String {
    return getStringList(tag).first()
  }

  fun getStringList(tag: Int): List<String> {
    val result = mutableListOf<String>()
    for (offset in tagToOffsets[tag]!!) {
      reader.move(offset)
      result += reader.readString()
    }
    return result
  }

  fun getInt32(tag: Int): Int {
    return getInt32List(tag).first()
  }

  fun getInt32List(tag: Int): List<Int> {
    val result = mutableListOf<Int>()
    for (offset in tagToOffsets[tag]!!) {
      reader.move(offset)
      result += reader.readVarint32()
    }
    return result
  }

  fun tags(): List<Int> {
    return tagToOffsets.keys.toList()
  }
}
