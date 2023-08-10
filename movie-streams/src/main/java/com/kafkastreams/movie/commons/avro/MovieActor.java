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
public class MovieActor extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4158623895035734055L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MovieActor\",\"namespace\":\"com.kafkastreams.movie.commons.avro\",\"fields\":[{\"name\":\"movie_id\",\"type\":\"int\"},{\"name\":\"actor_id\",\"type\":\"int\"},{\"name\":\"created_on\",\"type\":{\"type\":\"long\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"last_updated_on\",\"type\":{\"type\":\"long\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<MovieActor> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MovieActor> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<MovieActor> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<MovieActor> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<MovieActor> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this MovieActor to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a MovieActor from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a MovieActor instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static MovieActor fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int movie_id;
  private int actor_id;
  private java.time.Instant created_on;
  private java.time.Instant last_updated_on;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MovieActor() {}

  /**
   * All-args constructor.
   * @param movie_id The new value for movie_id
   * @param actor_id The new value for actor_id
   * @param created_on The new value for created_on
   * @param last_updated_on The new value for last_updated_on
   */
  public MovieActor(java.lang.Integer movie_id, java.lang.Integer actor_id, java.time.Instant created_on, java.time.Instant last_updated_on) {
    this.movie_id = movie_id;
    this.actor_id = actor_id;
    this.created_on = created_on.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.last_updated_on = last_updated_on.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
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
    case 1: return actor_id;
    case 2: return created_on;
    case 3: return last_updated_on;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
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
    case 1: actor_id = (java.lang.Integer)value$; break;
    case 2: created_on = (java.time.Instant)value$; break;
    case 3: last_updated_on = (java.time.Instant)value$; break;
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
   * Gets the value of the 'actor_id' field.
   * @return The value of the 'actor_id' field.
   */
  public int getActorId() {
    return actor_id;
  }


  /**
   * Sets the value of the 'actor_id' field.
   * @param value the value to set.
   */
  public void setActorId(int value) {
    this.actor_id = value;
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
   * Gets the value of the 'last_updated_on' field.
   * @return The value of the 'last_updated_on' field.
   */
  public java.time.Instant getLastUpdatedOn() {
    return last_updated_on;
  }


  /**
   * Sets the value of the 'last_updated_on' field.
   * @param value the value to set.
   */
  public void setLastUpdatedOn(java.time.Instant value) {
    this.last_updated_on = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new MovieActor RecordBuilder.
   * @return A new MovieActor RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieActor.Builder newBuilder() {
    return new com.kafkastreams.movie.commons.avro.MovieActor.Builder();
  }

  /**
   * Creates a new MovieActor RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MovieActor RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieActor.Builder newBuilder(com.kafkastreams.movie.commons.avro.MovieActor.Builder other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.MovieActor.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.MovieActor.Builder(other);
    }
  }

  /**
   * Creates a new MovieActor RecordBuilder by copying an existing MovieActor instance.
   * @param other The existing instance to copy.
   * @return A new MovieActor RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieActor.Builder newBuilder(com.kafkastreams.movie.commons.avro.MovieActor other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.MovieActor.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.MovieActor.Builder(other);
    }
  }

  /**
   * RecordBuilder for MovieActor instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MovieActor>
    implements org.apache.avro.data.RecordBuilder<MovieActor> {

    private int movie_id;
    private int actor_id;
    private java.time.Instant created_on;
    private java.time.Instant last_updated_on;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.MovieActor.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.actor_id)) {
        this.actor_id = data().deepCopy(fields()[1].schema(), other.actor_id);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.created_on)) {
        this.created_on = data().deepCopy(fields()[2].schema(), other.created_on);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.last_updated_on)) {
        this.last_updated_on = data().deepCopy(fields()[3].schema(), other.last_updated_on);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing MovieActor instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.MovieActor other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.actor_id)) {
        this.actor_id = data().deepCopy(fields()[1].schema(), other.actor_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.created_on)) {
        this.created_on = data().deepCopy(fields()[2].schema(), other.created_on);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.last_updated_on)) {
        this.last_updated_on = data().deepCopy(fields()[3].schema(), other.last_updated_on);
        fieldSetFlags()[3] = true;
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
    public com.kafkastreams.movie.commons.avro.MovieActor.Builder setMovieId(int value) {
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
    public com.kafkastreams.movie.commons.avro.MovieActor.Builder clearMovieId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'actor_id' field.
      * @return The value.
      */
    public int getActorId() {
      return actor_id;
    }


    /**
      * Sets the value of the 'actor_id' field.
      * @param value The value of 'actor_id'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieActor.Builder setActorId(int value) {
      validate(fields()[1], value);
      this.actor_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'actor_id' field has been set.
      * @return True if the 'actor_id' field has been set, false otherwise.
      */
    public boolean hasActorId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'actor_id' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieActor.Builder clearActorId() {
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
    public com.kafkastreams.movie.commons.avro.MovieActor.Builder setCreatedOn(java.time.Instant value) {
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
    public com.kafkastreams.movie.commons.avro.MovieActor.Builder clearCreatedOn() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'last_updated_on' field.
      * @return The value.
      */
    public java.time.Instant getLastUpdatedOn() {
      return last_updated_on;
    }


    /**
      * Sets the value of the 'last_updated_on' field.
      * @param value The value of 'last_updated_on'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieActor.Builder setLastUpdatedOn(java.time.Instant value) {
      validate(fields()[3], value);
      this.last_updated_on = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'last_updated_on' field has been set.
      * @return True if the 'last_updated_on' field has been set, false otherwise.
      */
    public boolean hasLastUpdatedOn() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'last_updated_on' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieActor.Builder clearLastUpdatedOn() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MovieActor build() {
      try {
        MovieActor record = new MovieActor();
        record.movie_id = fieldSetFlags()[0] ? this.movie_id : (java.lang.Integer) defaultValue(fields()[0]);
        record.actor_id = fieldSetFlags()[1] ? this.actor_id : (java.lang.Integer) defaultValue(fields()[1]);
        record.created_on = fieldSetFlags()[2] ? this.created_on : (java.time.Instant) defaultValue(fields()[2]);
        record.last_updated_on = fieldSetFlags()[3] ? this.last_updated_on : (java.time.Instant) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MovieActor>
    WRITER$ = (org.apache.avro.io.DatumWriter<MovieActor>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MovieActor>
    READER$ = (org.apache.avro.io.DatumReader<MovieActor>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}









