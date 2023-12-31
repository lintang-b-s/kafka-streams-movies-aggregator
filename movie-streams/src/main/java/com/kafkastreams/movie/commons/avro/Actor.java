/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kafkastreams.movie.commons.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Actor extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 295268378614673996L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Actor\",\"namespace\":\"com.kafkastreams.movie.commons.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"created_on\",\"type\":{\"type\":\"long\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<Actor> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Actor> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Actor> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Actor> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Actor> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Actor to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Actor from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Actor instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Actor fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int id;
  private java.lang.String name;
  private java.time.Instant created_on;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Actor() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param created_on The new value for created_on
   */
  public Actor(java.lang.Integer id, java.lang.String name, java.time.Instant created_on) {
    this.id = id;
    this.name = name;
    this.created_on = created_on.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return created_on;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: name = value$ != null ? value$.toString() : null; break;
    case 2: created_on = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public int getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(int value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'created_on' field.
   * @return The value of the 'created_on' field.
   */
  public java.time.Instant getCreatedOn() {
    return created_on;
  }


  /**
   * Sets the value of the 'created_on' field.
   * @param value the value to set.
   */
  public void setCreatedOn(java.time.Instant value) {
    this.created_on = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new Actor RecordBuilder.
   * @return A new Actor RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.Actor.Builder newBuilder() {
    return new com.kafkastreams.movie.commons.avro.Actor.Builder();
  }

  /**
   * Creates a new Actor RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Actor RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.Actor.Builder newBuilder(com.kafkastreams.movie.commons.avro.Actor.Builder other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.Actor.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.Actor.Builder(other);
    }
  }

  /**
   * Creates a new Actor RecordBuilder by copying an existing Actor instance.
   * @param other The existing instance to copy.
   * @return A new Actor RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.Actor.Builder newBuilder(com.kafkastreams.movie.commons.avro.Actor other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.Actor.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.Actor.Builder(other);
    }
  }

  /**
   * RecordBuilder for Actor instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Actor>
    implements org.apache.avro.data.RecordBuilder<Actor> {

    private int id;
    private java.lang.String name;
    private java.time.Instant created_on;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.Actor.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.created_on)) {
        this.created_on = data().deepCopy(fields()[2].schema(), other.created_on);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Actor instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.Actor other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.created_on)) {
        this.created_on = data().deepCopy(fields()[2].schema(), other.created_on);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public int getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Actor.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Actor.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Actor.Builder setName(java.lang.String value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Actor.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'created_on' field.
      * @return The value.
      */
    public java.time.Instant getCreatedOn() {
      return created_on;
    }


    /**
      * Sets the value of the 'created_on' field.
      * @param value The value of 'created_on'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Actor.Builder setCreatedOn(java.time.Instant value) {
      validate(fields()[2], value);
      this.created_on = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'created_on' field has been set.
      * @return True if the 'created_on' field has been set, false otherwise.
      */
    public boolean hasCreatedOn() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'created_on' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Actor.Builder clearCreatedOn() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Actor build() {
      try {
        Actor record = new Actor();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.String) defaultValue(fields()[1]);
        record.created_on = fieldSetFlags()[2] ? this.created_on : (java.time.Instant) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Actor>
    WRITER$ = (org.apache.avro.io.DatumWriter<Actor>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Actor>
    READER$ = (org.apache.avro.io.DatumReader<Actor>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










