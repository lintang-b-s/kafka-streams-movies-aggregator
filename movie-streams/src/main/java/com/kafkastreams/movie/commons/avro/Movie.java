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
public class Movie extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4905697135138398986L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Movie\",\"namespace\":\"com.kafkastreams.movie.commons.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"created_on\",\"type\":{\"type\":\"long\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"synopsis\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mpa_rating\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"image\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"r_year\",\"type\":{\"type\":\"long\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"notification\",\"type\":\"boolean\"},{\"name\":\"idmb_rating\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<Movie> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Movie> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Movie> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Movie> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Movie> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Movie to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Movie from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Movie instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Movie fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int id;
  private java.lang.String name;
  private java.time.Instant created_on;
  private java.lang.String type;
  private java.lang.String synopsis;
  private java.lang.String mpa_rating;
  private java.lang.String image;
  private java.time.Instant r_year;
  private boolean notification;
  private int idmb_rating;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Movie() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param created_on The new value for created_on
   * @param type The new value for type
   * @param synopsis The new value for synopsis
   * @param mpa_rating The new value for mpa_rating
   * @param image The new value for image
   * @param r_year The new value for r_year
   * @param notification The new value for notification
   * @param idmb_rating The new value for idmb_rating
   */
  public Movie(java.lang.Integer id, java.lang.String name, java.time.Instant created_on, java.lang.String type, java.lang.String synopsis, java.lang.String mpa_rating, java.lang.String image, java.time.Instant r_year, java.lang.Boolean notification, java.lang.Integer idmb_rating) {
    this.id = id;
    this.name = name;
    this.created_on = created_on.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.type = type;
    this.synopsis = synopsis;
    this.mpa_rating = mpa_rating;
    this.image = image;
    this.r_year = r_year.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.notification = notification;
    this.idmb_rating = idmb_rating;
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
    case 3: return type;
    case 4: return synopsis;
    case 5: return mpa_rating;
    case 6: return image;
    case 7: return r_year;
    case 8: return notification;
    case 9: return idmb_rating;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null,
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null,
      null,
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
    case 3: type = value$ != null ? value$.toString() : null; break;
    case 4: synopsis = value$ != null ? value$.toString() : null; break;
    case 5: mpa_rating = value$ != null ? value$.toString() : null; break;
    case 6: image = value$ != null ? value$.toString() : null; break;
    case 7: r_year = (java.time.Instant)value$; break;
    case 8: notification = (java.lang.Boolean)value$; break;
    case 9: idmb_rating = (java.lang.Integer)value$; break;
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
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.String getType() {
    return type;
  }


  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.String value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'synopsis' field.
   * @return The value of the 'synopsis' field.
   */
  public java.lang.String getSynopsis() {
    return synopsis;
  }


  /**
   * Sets the value of the 'synopsis' field.
   * @param value the value to set.
   */
  public void setSynopsis(java.lang.String value) {
    this.synopsis = value;
  }

  /**
   * Gets the value of the 'mpa_rating' field.
   * @return The value of the 'mpa_rating' field.
   */
  public java.lang.String getMpaRating() {
    return mpa_rating;
  }


  /**
   * Sets the value of the 'mpa_rating' field.
   * @param value the value to set.
   */
  public void setMpaRating(java.lang.String value) {
    this.mpa_rating = value;
  }

  /**
   * Gets the value of the 'image' field.
   * @return The value of the 'image' field.
   */
  public java.lang.String getImage() {
    return image;
  }


  /**
   * Sets the value of the 'image' field.
   * @param value the value to set.
   */
  public void setImage(java.lang.String value) {
    this.image = value;
  }

  /**
   * Gets the value of the 'r_year' field.
   * @return The value of the 'r_year' field.
   */
  public java.time.Instant getRYear() {
    return r_year;
  }


  /**
   * Sets the value of the 'r_year' field.
   * @param value the value to set.
   */
  public void setRYear(java.time.Instant value) {
    this.r_year = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'notification' field.
   * @return The value of the 'notification' field.
   */
  public boolean getNotification() {
    return notification;
  }


  /**
   * Sets the value of the 'notification' field.
   * @param value the value to set.
   */
  public void setNotification(boolean value) {
    this.notification = value;
  }

  /**
   * Gets the value of the 'idmb_rating' field.
   * @return The value of the 'idmb_rating' field.
   */
  public int getIdmbRating() {
    return idmb_rating;
  }


  /**
   * Sets the value of the 'idmb_rating' field.
   * @param value the value to set.
   */
  public void setIdmbRating(int value) {
    this.idmb_rating = value;
  }

  /**
   * Creates a new Movie RecordBuilder.
   * @return A new Movie RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.Movie.Builder newBuilder() {
    return new com.kafkastreams.movie.commons.avro.Movie.Builder();
  }

  /**
   * Creates a new Movie RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Movie RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.Movie.Builder newBuilder(com.kafkastreams.movie.commons.avro.Movie.Builder other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.Movie.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.Movie.Builder(other);
    }
  }

  /**
   * Creates a new Movie RecordBuilder by copying an existing Movie instance.
   * @param other The existing instance to copy.
   * @return A new Movie RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.Movie.Builder newBuilder(com.kafkastreams.movie.commons.avro.Movie other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.Movie.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.Movie.Builder(other);
    }
  }

  /**
   * RecordBuilder for Movie instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Movie>
    implements org.apache.avro.data.RecordBuilder<Movie> {

    private int id;
    private java.lang.String name;
    private java.time.Instant created_on;
    private java.lang.String type;
    private java.lang.String synopsis;
    private java.lang.String mpa_rating;
    private java.lang.String image;
    private java.time.Instant r_year;
    private boolean notification;
    private int idmb_rating;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.Movie.Builder other) {
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
      if (isValidValue(fields()[3], other.type)) {
        this.type = data().deepCopy(fields()[3].schema(), other.type);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.synopsis)) {
        this.synopsis = data().deepCopy(fields()[4].schema(), other.synopsis);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.mpa_rating)) {
        this.mpa_rating = data().deepCopy(fields()[5].schema(), other.mpa_rating);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.image)) {
        this.image = data().deepCopy(fields()[6].schema(), other.image);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.r_year)) {
        this.r_year = data().deepCopy(fields()[7].schema(), other.r_year);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.notification)) {
        this.notification = data().deepCopy(fields()[8].schema(), other.notification);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.idmb_rating)) {
        this.idmb_rating = data().deepCopy(fields()[9].schema(), other.idmb_rating);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
    }

    /**
     * Creates a Builder by copying an existing Movie instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.Movie other) {
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
      if (isValidValue(fields()[3], other.type)) {
        this.type = data().deepCopy(fields()[3].schema(), other.type);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.synopsis)) {
        this.synopsis = data().deepCopy(fields()[4].schema(), other.synopsis);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.mpa_rating)) {
        this.mpa_rating = data().deepCopy(fields()[5].schema(), other.mpa_rating);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.image)) {
        this.image = data().deepCopy(fields()[6].schema(), other.image);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.r_year)) {
        this.r_year = data().deepCopy(fields()[7].schema(), other.r_year);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.notification)) {
        this.notification = data().deepCopy(fields()[8].schema(), other.notification);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.idmb_rating)) {
        this.idmb_rating = data().deepCopy(fields()[9].schema(), other.idmb_rating);
        fieldSetFlags()[9] = true;
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
    public com.kafkastreams.movie.commons.avro.Movie.Builder setId(int value) {
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
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearId() {
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
    public com.kafkastreams.movie.commons.avro.Movie.Builder setName(java.lang.String value) {
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
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearName() {
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
    public com.kafkastreams.movie.commons.avro.Movie.Builder setCreatedOn(java.time.Instant value) {
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
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearCreatedOn() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.String getType() {
      return type;
    }


    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder setType(java.lang.String value) {
      validate(fields()[3], value);
      this.type = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearType() {
      type = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'synopsis' field.
      * @return The value.
      */
    public java.lang.String getSynopsis() {
      return synopsis;
    }


    /**
      * Sets the value of the 'synopsis' field.
      * @param value The value of 'synopsis'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder setSynopsis(java.lang.String value) {
      validate(fields()[4], value);
      this.synopsis = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'synopsis' field has been set.
      * @return True if the 'synopsis' field has been set, false otherwise.
      */
    public boolean hasSynopsis() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'synopsis' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearSynopsis() {
      synopsis = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'mpa_rating' field.
      * @return The value.
      */
    public java.lang.String getMpaRating() {
      return mpa_rating;
    }


    /**
      * Sets the value of the 'mpa_rating' field.
      * @param value The value of 'mpa_rating'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder setMpaRating(java.lang.String value) {
      validate(fields()[5], value);
      this.mpa_rating = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'mpa_rating' field has been set.
      * @return True if the 'mpa_rating' field has been set, false otherwise.
      */
    public boolean hasMpaRating() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'mpa_rating' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearMpaRating() {
      mpa_rating = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'image' field.
      * @return The value.
      */
    public java.lang.String getImage() {
      return image;
    }


    /**
      * Sets the value of the 'image' field.
      * @param value The value of 'image'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder setImage(java.lang.String value) {
      validate(fields()[6], value);
      this.image = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'image' field has been set.
      * @return True if the 'image' field has been set, false otherwise.
      */
    public boolean hasImage() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'image' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearImage() {
      image = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'r_year' field.
      * @return The value.
      */
    public java.time.Instant getRYear() {
      return r_year;
    }


    /**
      * Sets the value of the 'r_year' field.
      * @param value The value of 'r_year'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder setRYear(java.time.Instant value) {
      validate(fields()[7], value);
      this.r_year = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'r_year' field has been set.
      * @return True if the 'r_year' field has been set, false otherwise.
      */
    public boolean hasRYear() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'r_year' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearRYear() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'notification' field.
      * @return The value.
      */
    public boolean getNotification() {
      return notification;
    }


    /**
      * Sets the value of the 'notification' field.
      * @param value The value of 'notification'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder setNotification(boolean value) {
      validate(fields()[8], value);
      this.notification = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'notification' field has been set.
      * @return True if the 'notification' field has been set, false otherwise.
      */
    public boolean hasNotification() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'notification' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearNotification() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'idmb_rating' field.
      * @return The value.
      */
    public int getIdmbRating() {
      return idmb_rating;
    }


    /**
      * Sets the value of the 'idmb_rating' field.
      * @param value The value of 'idmb_rating'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder setIdmbRating(int value) {
      validate(fields()[9], value);
      this.idmb_rating = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'idmb_rating' field has been set.
      * @return True if the 'idmb_rating' field has been set, false otherwise.
      */
    public boolean hasIdmbRating() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'idmb_rating' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.Movie.Builder clearIdmbRating() {
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Movie build() {
      try {
        Movie record = new Movie();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.String) defaultValue(fields()[1]);
        record.created_on = fieldSetFlags()[2] ? this.created_on : (java.time.Instant) defaultValue(fields()[2]);
        record.type = fieldSetFlags()[3] ? this.type : (java.lang.String) defaultValue(fields()[3]);
        record.synopsis = fieldSetFlags()[4] ? this.synopsis : (java.lang.String) defaultValue(fields()[4]);
        record.mpa_rating = fieldSetFlags()[5] ? this.mpa_rating : (java.lang.String) defaultValue(fields()[5]);
        record.image = fieldSetFlags()[6] ? this.image : (java.lang.String) defaultValue(fields()[6]);
        record.r_year = fieldSetFlags()[7] ? this.r_year : (java.time.Instant) defaultValue(fields()[7]);
        record.notification = fieldSetFlags()[8] ? this.notification : (java.lang.Boolean) defaultValue(fields()[8]);
        record.idmb_rating = fieldSetFlags()[9] ? this.idmb_rating : (java.lang.Integer) defaultValue(fields()[9]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Movie>
    WRITER$ = (org.apache.avro.io.DatumWriter<Movie>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Movie>
    READER$ = (org.apache.avro.io.DatumReader<Movie>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










