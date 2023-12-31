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
public class MovieCreator extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2570654811493134387L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MovieCreator\",\"namespace\":\"com.kafkastreams.movie.commons.avro\",\"fields\":[{\"name\":\"movie_id\",\"type\":\"int\"},{\"name\":\"creator_id\",\"type\":\"int\"},{\"name\":\"created_on\",\"type\":{\"type\":\"long\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<MovieCreator> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MovieCreator> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<MovieCreator> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<MovieCreator> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<MovieCreator> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this MovieCreator to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a MovieCreator from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a MovieCreator instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static MovieCreator fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int movie_id;
  private int creator_id;
  private java.time.Instant created_on;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MovieCreator() {}

  /**
   * All-args constructor.
   * @param movie_id The new value for movie_id
   * @param creator_id The new value for creator_id
   * @param created_on The new value for created_on
   */
  public MovieCreator(java.lang.Integer movie_id, java.lang.Integer creator_id, java.time.Instant created_on) {
    this.movie_id = movie_id;
    this.creator_id = creator_id;
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
    case 0: return movie_id;
    case 1: return creator_id;
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
    case 0: movie_id = (java.lang.Integer)value$; break;
    case 1: creator_id = (java.lang.Integer)value$; break;
    case 2: created_on = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'movie_id' field.
   * @return The value of the 'movie_id' field.
   */
  public int getMovieId() {
    return movie_id;
  }


  /**
   * Sets the value of the 'movie_id' field.
   * @param value the value to set.
   */
  public void setMovieId(int value) {
    this.movie_id = value;
  }

  /**
   * Gets the value of the 'creator_id' field.
   * @return The value of the 'creator_id' field.
   */
  public int getCreatorId() {
    return creator_id;
  }


  /**
   * Sets the value of the 'creator_id' field.
   * @param value the value to set.
   */
  public void setCreatorId(int value) {
    this.creator_id = value;
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
   * Creates a new MovieCreator RecordBuilder.
   * @return A new MovieCreator RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieCreator.Builder newBuilder() {
    return new com.kafkastreams.movie.commons.avro.MovieCreator.Builder();
  }

  /**
   * Creates a new MovieCreator RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MovieCreator RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieCreator.Builder newBuilder(com.kafkastreams.movie.commons.avro.MovieCreator.Builder other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.MovieCreator.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.MovieCreator.Builder(other);
    }
  }

  /**
   * Creates a new MovieCreator RecordBuilder by copying an existing MovieCreator instance.
   * @param other The existing instance to copy.
   * @return A new MovieCreator RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieCreator.Builder newBuilder(com.kafkastreams.movie.commons.avro.MovieCreator other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.MovieCreator.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.MovieCreator.Builder(other);
    }
  }

  /**
   * RecordBuilder for MovieCreator instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MovieCreator>
    implements org.apache.avro.data.RecordBuilder<MovieCreator> {

    private int movie_id;
    private int creator_id;
    private java.time.Instant created_on;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.MovieCreator.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.creator_id)) {
        this.creator_id = data().deepCopy(fields()[1].schema(), other.creator_id);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.created_on)) {
        this.created_on = data().deepCopy(fields()[2].schema(), other.created_on);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing MovieCreator instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.MovieCreator other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.creator_id)) {
        this.creator_id = data().deepCopy(fields()[1].schema(), other.creator_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.created_on)) {
        this.created_on = data().deepCopy(fields()[2].schema(), other.created_on);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'movie_id' field.
      * @return The value.
      */
    public int getMovieId() {
      return movie_id;
    }


    /**
      * Sets the value of the 'movie_id' field.
      * @param value The value of 'movie_id'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieCreator.Builder setMovieId(int value) {
      validate(fields()[0], value);
      this.movie_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'movie_id' field has been set.
      * @return True if the 'movie_id' field has been set, false otherwise.
      */
    public boolean hasMovieId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'movie_id' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieCreator.Builder clearMovieId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'creator_id' field.
      * @return The value.
      */
    public int getCreatorId() {
      return creator_id;
    }


    /**
      * Sets the value of the 'creator_id' field.
      * @param value The value of 'creator_id'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieCreator.Builder setCreatorId(int value) {
      validate(fields()[1], value);
      this.creator_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'creator_id' field has been set.
      * @return True if the 'creator_id' field has been set, false otherwise.
      */
    public boolean hasCreatorId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'creator_id' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieCreator.Builder clearCreatorId() {
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
    public com.kafkastreams.movie.commons.avro.MovieCreator.Builder setCreatedOn(java.time.Instant value) {
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
    public com.kafkastreams.movie.commons.avro.MovieCreator.Builder clearCreatedOn() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MovieCreator build() {
      try {
        MovieCreator record = new MovieCreator();
        record.movie_id = fieldSetFlags()[0] ? this.movie_id : (java.lang.Integer) defaultValue(fields()[0]);
        record.creator_id = fieldSetFlags()[1] ? this.creator_id : (java.lang.Integer) defaultValue(fields()[1]);
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
  private static final org.apache.avro.io.DatumWriter<MovieCreator>
    WRITER$ = (org.apache.avro.io.DatumWriter<MovieCreator>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MovieCreator>
    READER$ = (org.apache.avro.io.DatumReader<MovieCreator>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










