/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.copyright.rup.works.broker.thrift.gen;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Work
 */
public class ThriftAuthor implements org.apache.thrift.TBase<ThriftAuthor, ThriftAuthor._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftAuthor");

  private static final org.apache.thrift.protocol.TField BIRTH_YEAR_FIELD_DESC = new org.apache.thrift.protocol.TField("birthYear", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DEATH_YEAR_FIELD_DESC = new org.apache.thrift.protocol.TField("deathYear", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ThriftAuthorStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ThriftAuthorTupleSchemeFactory());
  }

  public String birthYear; // required
  public String deathYear; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BIRTH_YEAR((short)1, "birthYear"),
    DEATH_YEAR((short)2, "deathYear");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // BIRTH_YEAR
          return BIRTH_YEAR;
        case 2: // DEATH_YEAR
          return DEATH_YEAR;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BIRTH_YEAR, new org.apache.thrift.meta_data.FieldMetaData("birthYear", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEATH_YEAR, new org.apache.thrift.meta_data.FieldMetaData("deathYear", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftAuthor.class, metaDataMap);
  }

  public ThriftAuthor() {
  }

  public ThriftAuthor(
    String birthYear,
    String deathYear)
  {
    this();
    this.birthYear = birthYear;
    this.deathYear = deathYear;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftAuthor(ThriftAuthor other) {
    if (other.isSetBirthYear()) {
      this.birthYear = other.birthYear;
    }
    if (other.isSetDeathYear()) {
      this.deathYear = other.deathYear;
    }
  }

  public ThriftAuthor deepCopy() {
    return new ThriftAuthor(this);
  }

  @Override
  public void clear() {
    this.birthYear = null;
    this.deathYear = null;
  }

  public String getBirthYear() {
    return this.birthYear;
  }

  public ThriftAuthor setBirthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  public void unsetBirthYear() {
    this.birthYear = null;
  }

  /** Returns true if field birthYear is set (has been assigned a value) and false otherwise */
  public boolean isSetBirthYear() {
    return this.birthYear != null;
  }

  public void setBirthYearIsSet(boolean value) {
    if (!value) {
      this.birthYear = null;
    }
  }

  public String getDeathYear() {
    return this.deathYear;
  }

  public ThriftAuthor setDeathYear(String deathYear) {
    this.deathYear = deathYear;
    return this;
  }

  public void unsetDeathYear() {
    this.deathYear = null;
  }

  /** Returns true if field deathYear is set (has been assigned a value) and false otherwise */
  public boolean isSetDeathYear() {
    return this.deathYear != null;
  }

  public void setDeathYearIsSet(boolean value) {
    if (!value) {
      this.deathYear = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BIRTH_YEAR:
      if (value == null) {
        unsetBirthYear();
      } else {
        setBirthYear((String)value);
      }
      break;

    case DEATH_YEAR:
      if (value == null) {
        unsetDeathYear();
      } else {
        setDeathYear((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BIRTH_YEAR:
      return getBirthYear();

    case DEATH_YEAR:
      return getDeathYear();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BIRTH_YEAR:
      return isSetBirthYear();
    case DEATH_YEAR:
      return isSetDeathYear();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftAuthor)
      return this.equals((ThriftAuthor)that);
    return false;
  }

  public boolean equals(ThriftAuthor that) {
    if (that == null)
      return false;

    boolean this_present_birthYear = true && this.isSetBirthYear();
    boolean that_present_birthYear = true && that.isSetBirthYear();
    if (this_present_birthYear || that_present_birthYear) {
      if (!(this_present_birthYear && that_present_birthYear))
        return false;
      if (!this.birthYear.equals(that.birthYear))
        return false;
    }

    boolean this_present_deathYear = true && this.isSetDeathYear();
    boolean that_present_deathYear = true && that.isSetDeathYear();
    if (this_present_deathYear || that_present_deathYear) {
      if (!(this_present_deathYear && that_present_deathYear))
        return false;
      if (!this.deathYear.equals(that.deathYear))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_birthYear = true && (isSetBirthYear());
    builder.append(present_birthYear);
    if (present_birthYear)
      builder.append(birthYear);

    boolean present_deathYear = true && (isSetDeathYear());
    builder.append(present_deathYear);
    if (present_deathYear)
      builder.append(deathYear);

    return builder.toHashCode();
  }

  public int compareTo(ThriftAuthor other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ThriftAuthor typedOther = (ThriftAuthor)other;

    lastComparison = Boolean.valueOf(isSetBirthYear()).compareTo(typedOther.isSetBirthYear());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBirthYear()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.birthYear, typedOther.birthYear);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeathYear()).compareTo(typedOther.isSetDeathYear());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeathYear()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deathYear, typedOther.deathYear);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftAuthor(");
    boolean first = true;

    sb.append("birthYear:");
    if (this.birthYear == null) {
      sb.append("null");
    } else {
      sb.append(this.birthYear);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("deathYear:");
    if (this.deathYear == null) {
      sb.append("null");
    } else {
      sb.append(this.deathYear);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ThriftAuthorStandardSchemeFactory implements SchemeFactory {
    public ThriftAuthorStandardScheme getScheme() {
      return new ThriftAuthorStandardScheme();
    }
  }

  private static class ThriftAuthorStandardScheme extends StandardScheme<ThriftAuthor> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftAuthor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BIRTH_YEAR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.birthYear = iprot.readString();
              struct.setBirthYearIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DEATH_YEAR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.deathYear = iprot.readString();
              struct.setDeathYearIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftAuthor struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.birthYear != null) {
        oprot.writeFieldBegin(BIRTH_YEAR_FIELD_DESC);
        oprot.writeString(struct.birthYear);
        oprot.writeFieldEnd();
      }
      if (struct.deathYear != null) {
        oprot.writeFieldBegin(DEATH_YEAR_FIELD_DESC);
        oprot.writeString(struct.deathYear);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftAuthorTupleSchemeFactory implements SchemeFactory {
    public ThriftAuthorTupleScheme getScheme() {
      return new ThriftAuthorTupleScheme();
    }
  }

  private static class ThriftAuthorTupleScheme extends TupleScheme<ThriftAuthor> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftAuthor struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBirthYear()) {
        optionals.set(0);
      }
      if (struct.isSetDeathYear()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetBirthYear()) {
        oprot.writeString(struct.birthYear);
      }
      if (struct.isSetDeathYear()) {
        oprot.writeString(struct.deathYear);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftAuthor struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.birthYear = iprot.readString();
        struct.setBirthYearIsSet(true);
      }
      if (incoming.get(1)) {
        struct.deathYear = iprot.readString();
        struct.setDeathYearIsSet(true);
      }
    }
  }

}

