// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.custom_options.FooBar in custom_options.proto
import Wire

public struct FooBar {

    @ProtoDefaulted
    public var foo: Int32?
    @ProtoDefaulted
    public var bar: String?
    @ProtoDefaulted
    public var baz: FooBar.Nested?
    @ProtoDefaulted
    public var qux: UInt64?
    public var fred: [Float] = []
    @ProtoDefaulted
    public var daisy: Double?
    public var nested: [FooBar] = []
    public var ext: FooBar.FooBarBazEnum?
    public var rep: [FooBar.FooBarBazEnum] = []
    @ProtoDefaulted
    public var more_string: String?
    public var unknownFields: UnknownFields = .init()

    public init(configure: (inout Self) -> Swift.Void = { _ in }) {
        configure(&self)
    }

}

#if !WIRE_REMOVE_EQUATABLE
extension FooBar : Equatable {
}
#endif

#if !WIRE_REMOVE_HASHABLE
extension FooBar : Hashable {
}
#endif

extension FooBar : Sendable {
}

extension FooBar : ProtoDefaultedValue {

    public static var defaultedValue: FooBar {
        FooBar()
    }
}

extension FooBar : ProtoExtensible {
}

#if !WIRE_REMOVE_REDACTABLE
extension FooBar : Redactable {

    public enum RedactedKeys : String, RedactedKey {

        case nested

    }

}
#endif

extension FooBar : ProtoMessage {

    public static func protoMessageTypeURL() -> String {
        return "type.googleapis.com/squareup.protos.custom_options.FooBar"
    }

}

extension FooBar : Proto2Codable {

    public init(from protoReader: ProtoReader) throws {
        var foo: Int32? = nil
        var bar: String? = nil
        var baz: FooBar.Nested? = nil
        var qux: UInt64? = nil
        var fred: [Float] = []
        var daisy: Double? = nil
        var nested: [FooBar] = []
        var ext: FooBar.FooBarBazEnum? = nil
        var rep: [FooBar.FooBarBazEnum] = []
        var more_string: String? = nil

        let token = try protoReader.beginMessage()
        while let tag = try protoReader.nextTag(token: token) {
            switch tag {
            case 1: foo = try protoReader.decode(Int32.self)
            case 2: bar = try protoReader.decode(String.self)
            case 3: baz = try protoReader.decode(FooBar.Nested.self)
            case 4: qux = try protoReader.decode(UInt64.self)
            case 5: try protoReader.decode(into: &fred)
            case 6: daisy = try protoReader.decode(Double.self)
            case 7: try protoReader.decode(into: &nested)
            case 101: ext = try protoReader.decode(FooBar.FooBarBazEnum.self)
            case 102: try protoReader.decode(into: &rep)
            case 150: more_string = try protoReader.decode(String.self)
            default: try protoReader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try protoReader.endMessage(token: token)

        self._foo.wrappedValue = foo
        self._bar.wrappedValue = bar
        self._baz.wrappedValue = baz
        self._qux.wrappedValue = qux
        self.fred = fred
        self._daisy.wrappedValue = daisy
        self.nested = nested
        self.ext = ext
        self.rep = rep
        self._more_string.wrappedValue = more_string
    }

    public func encode(to protoWriter: ProtoWriter) throws {
        try protoWriter.encode(tag: 1, value: self.foo)
        try protoWriter.encode(tag: 2, value: self.bar)
        try protoWriter.encode(tag: 3, value: self.baz)
        try protoWriter.encode(tag: 4, value: self.qux)
        try protoWriter.encode(tag: 5, value: self.fred)
        try protoWriter.encode(tag: 6, value: self.daisy)
        try protoWriter.encode(tag: 7, value: self.nested)
        try protoWriter.encode(tag: 101, value: self.ext)
        try protoWriter.encode(tag: 102, value: self.rep)
        try protoWriter.encode(tag: 150, value: self.more_string)
        try protoWriter.writeUnknownFields(unknownFields)
    }

}

#if !WIRE_REMOVE_CODABLE
extension FooBar : Codable {

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: StringLiteralCodingKeys.self)
        self._foo.wrappedValue = try container.decodeIfPresent(Int32.self, forKey: "foo")
        self._bar.wrappedValue = try container.decodeIfPresent(String.self, forKey: "bar")
        self._baz.wrappedValue = try container.decodeIfPresent(FooBar.Nested.self, forKey: "baz")
        self._qux.wrappedValue = try container.decodeIfPresent(stringEncoded: UInt64.self, forKey: "qux")
        self.fred = try container.decodeProtoArray(Float.self, forKey: "fred")
        self._daisy.wrappedValue = try container.decodeIfPresent(Double.self, forKey: "daisy")
        self.nested = try container.decodeProtoArray(FooBar.self, forKey: "nested")
        self.ext = try container.decodeIfPresent(FooBar.FooBarBazEnum.self, forKey: "ext")
        self.rep = try container.decodeProtoArray(FooBar.FooBarBazEnum.self, forKey: "rep")
        self._more_string.wrappedValue = try container.decodeIfPresent(String.self, firstOfKeys: "moreString", "more_string")
    }

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: StringLiteralCodingKeys.self)
        let preferCamelCase = encoder.protoKeyNameEncodingStrategy == .camelCase
        let includeDefaults = encoder.protoDefaultValuesEncodingStrategy == .include

        try container.encodeIfPresent(self.foo, forKey: "foo")
        try container.encodeIfPresent(self.bar, forKey: "bar")
        try container.encodeIfPresent(self.baz, forKey: "baz")
        try container.encodeIfPresent(stringEncoded: self.qux, forKey: "qux")
        if includeDefaults || !self.fred.isEmpty {
            try container.encodeProtoArray(self.fred, forKey: "fred")
        }
        try container.encodeIfPresent(self.daisy, forKey: "daisy")
        if includeDefaults || !self.nested.isEmpty {
            try container.encodeProtoArray(self.nested, forKey: "nested")
        }
        try container.encodeIfPresent(self.ext, forKey: "ext")
        if includeDefaults || !self.rep.isEmpty {
            try container.encodeProtoArray(self.rep, forKey: "rep")
        }
        try container.encodeIfPresent(self.more_string, forKey: preferCamelCase ? "moreString" : "more_string")
    }

}
#endif

/**
 * Subtypes within FooBar
 */
extension FooBar {

    public struct Nested {

        public var value: FooBar.FooBarBazEnum?
        public var unknownFields: UnknownFields = .init()

        public init(configure: (inout Self) -> Swift.Void = { _ in }) {
            configure(&self)
        }

    }

    public struct More {

        public var serial: [Int32] = []
        public var unknownFields: UnknownFields = .init()

        public init(configure: (inout Self) -> Swift.Void = { _ in }) {
            configure(&self)
        }

    }

    public enum FooBarBazEnum : Int32, CaseIterable, ProtoEnum, Proto2Enum {

        case FOO = 1
        case BAR = 2
        case BAZ = 3

        public var description: String {
            switch self {
            case .FOO: return "FOO"
            case .BAR: return "BAR"
            case .BAZ: return "BAZ"
            }
        }

    }

}

#if !WIRE_REMOVE_EQUATABLE
extension FooBar.Nested : Equatable {
}
#endif

#if !WIRE_REMOVE_HASHABLE
extension FooBar.Nested : Hashable {
}
#endif

extension FooBar.Nested : Sendable {
}

extension FooBar.Nested : ProtoDefaultedValue {

    public static var defaultedValue: FooBar.Nested {
        FooBar.Nested()
    }
}

extension FooBar.Nested : ProtoMessage {

    public static func protoMessageTypeURL() -> String {
        return "type.googleapis.com/squareup.protos.custom_options.FooBar.Nested"
    }

}

extension FooBar.Nested : Proto2Codable {

    public init(from protoReader: ProtoReader) throws {
        var value: FooBar.FooBarBazEnum? = nil

        let token = try protoReader.beginMessage()
        while let tag = try protoReader.nextTag(token: token) {
            switch tag {
            case 1: value = try protoReader.decode(FooBar.FooBarBazEnum.self)
            default: try protoReader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try protoReader.endMessage(token: token)

        self.value = value
    }

    public func encode(to protoWriter: ProtoWriter) throws {
        try protoWriter.encode(tag: 1, value: self.value)
        try protoWriter.writeUnknownFields(unknownFields)
    }

}

#if !WIRE_REMOVE_CODABLE
extension FooBar.Nested : Codable {

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: StringLiteralCodingKeys.self)
        self.value = try container.decodeIfPresent(FooBar.FooBarBazEnum.self, forKey: "value")
    }

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: StringLiteralCodingKeys.self)

        try container.encodeIfPresent(self.value, forKey: "value")
    }

}
#endif

#if !WIRE_REMOVE_EQUATABLE
extension FooBar.More : Equatable {
}
#endif

#if !WIRE_REMOVE_HASHABLE
extension FooBar.More : Hashable {
}
#endif

extension FooBar.More : Sendable {
}

extension FooBar.More : ProtoDefaultedValue {

    public static var defaultedValue: FooBar.More {
        FooBar.More()
    }
}

extension FooBar.More : ProtoMessage {

    public static func protoMessageTypeURL() -> String {
        return "type.googleapis.com/squareup.protos.custom_options.FooBar.More"
    }

}

extension FooBar.More : Proto2Codable {

    public init(from protoReader: ProtoReader) throws {
        var serial: [Int32] = []

        let token = try protoReader.beginMessage()
        while let tag = try protoReader.nextTag(token: token) {
            switch tag {
            case 1: try protoReader.decode(into: &serial)
            default: try protoReader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try protoReader.endMessage(token: token)

        self.serial = serial
    }

    public func encode(to protoWriter: ProtoWriter) throws {
        try protoWriter.encode(tag: 1, value: self.serial)
        try protoWriter.writeUnknownFields(unknownFields)
    }

}

#if !WIRE_REMOVE_CODABLE
extension FooBar.More : Codable {

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: StringLiteralCodingKeys.self)
        self.serial = try container.decodeProtoArray(Int32.self, forKey: "serial")
    }

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: StringLiteralCodingKeys.self)
        let includeDefaults = encoder.protoDefaultValuesEncodingStrategy == .include

        if includeDefaults || !self.serial.isEmpty {
            try container.encodeProtoArray(self.serial, forKey: "serial")
        }
    }

}
#endif

extension FooBar.FooBarBazEnum : Sendable {
}
