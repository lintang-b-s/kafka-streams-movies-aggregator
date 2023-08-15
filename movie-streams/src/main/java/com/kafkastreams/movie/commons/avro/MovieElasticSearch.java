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
public class MovieElasticSearch extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6109498890441128431L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MovieElasticSearch\",\"namespace\":\"com.kafkastreams.movie.commons.avro\",\"fields\":[{\"name\":\"title\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"genre\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"synopsis\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"releaseYear\",\"type\":{\"type\":\"long\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"image\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"rating\",\"type\":\"float\"},{\"name\":\"director\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"cast\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"url\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"movieId\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<MovieElasticSearch> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MovieElasticSearch> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<MovieElasticSearch> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<MovieElasticSearch> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<MovieElasticSearch> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this MovieElasticSearch to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a MovieElasticSearch from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a MovieElasticSearch instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static MovieElasticSearch fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String title;
  private java.util.List<java.lang.String> genre;
  private java.lang.String synopsis;
  private java.time.Instant releaseYear;
  private java.lang.String image;
  private float rating;
  private java.util.List<java.lang.String> director;
  private java.util.List<java.lang.String> cast;
  private java.util.List<java.lang.String> url;
  private int movieId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MovieElasticSearch() {}

  /**
   * All-args constructor.
   * @param title The new value for title
   * @param genre The new value for genre
   * @param synopsis The new value for synopsis
   * @param releaseYear The new value for releaseYear
   * @param image The new value for image
   * @param rating The new value for rating
   * @param director The new value for director
   * @param cast The new value for cast
   * @param url The new value for url
   * @param movieId The new value for movieId
   */
  public MovieElasticSearch(java.lang.String title, java.util.List<java.lang.String> genre, java.lang.String synopsis, java.time.Instant releaseYear, java.lang.String image, java.lang.Float rating, java.util.List<java.lang.String> director, java.util.List<java.lang.String> cast, java.util.List<java.lang.String> url, java.lang.Integer movieId) {
    this.title = title;
    this.genre = genre;
    this.synopsis = synopsis;
    this.releaseYear = releaseYear.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.image = image;
    this.rating = rating;
    this.director = director;
    this.cast = cast;
    this.url = url;
    this.movieId = movieId;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return title;
    case 1: return genre;
    case 2: return synopsis;
    case 3: return releaseYear;
    case 4: return image;
    case 5: return rating;
    case 6: return director;
    case 7: return cast;
    case 8: return url;
    case 9: return movieId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null,
      null,
      null,
      null,
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
    case 0: title = value$ != null ? value$.toString() : null; break;
    case 1: genre = (java.util.List<java.lang.String>)value$; break;
    case 2: synopsis = value$ != null ? value$.toString() : null; break;
    case 3: releaseYear = (java.time.Instant)value$; break;
    case 4: image = value$ != null ? value$.toString() : null; break;
    case 5: rating = (java.lang.Float)value$; break;
    case 6: director = (java.util.List<java.lang.String>)value$; break;
    case 7: cast = (java.util.List<java.lang.String>)value$; break;
    case 8: url = (java.util.List<java.lang.String>)value$; break;
    case 9: movieId = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'title' field.
   * @return The value of the 'title' field.
   */
  public java.lang.String getTitle() {
    return title;
  }


  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.String value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'genre' field.
   * @return The value of the 'genre' field.
   */
  public java.util.List<java.lang.String> getGenre() {
    return genre;
  }


  /**
   * Sets the value of the 'genre' field.
   * @param value the value to set.
   */
  public void setGenre(java.util.List<java.lang.String> value) {
    this.genre = value;
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
   * Gets the value of the 'releaseYear' field.
   * @return The value of the 'releaseYear' field.
   */
  public java.time.Instant getReleaseYear() {
    return releaseYear;
  }


  /**
   * Sets the value of the 'releaseYear' field.
   * @param value the value to set.
   */
  public void setReleaseYear(java.time.Instant value) {
    this.releaseYear = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
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
   * Gets the value of the 'rating' field.
   * @return The value of the 'rating' field.
   */
  public float getRating() {
    return rating;
  }


  /**
   * Sets the value of the 'rating' field.
   * @param value the value to set.
   */
  public void setRating(float value) {
    this.rating = value;
  }

  /**
   * Gets the value of the 'director' field.
   * @return The value of the 'director' field.
   */
  public java.util.List<java.lang.String> getDirector() {
    return director;
  }


  /**
   * Sets the value of the 'director' field.
   * @param value the value to set.
   */
  public void setDirector(java.util.List<java.lang.String> value) {
    this.director = value;
  }

  /**
   * Gets the value of the 'cast' field.
   * @return The value of the 'cast' field.
   */
  public java.util.List<java.lang.String> getCast() {
    return cast;
  }


  /**
   * Sets the value of the 'cast' field.
   * @param value the value to set.
   */
  public void setCast(java.util.List<java.lang.String> value) {
    this.cast = value;
  }

  /**
   * Gets the value of the 'url' field.
   * @return The value of the 'url' field.
   */
  public java.util.List<java.lang.String> getUrl() {
    return url;
  }


  /**
   * Sets the value of the 'url' field.
   * @param value the value to set.
   */
  public void setUrl(java.util.List<java.lang.String> value) {
    this.url = value;
  }

  /**
   * Gets the value of the 'movieId' field.
   * @return The value of the 'movieId' field.
   */
  public int getMovieId() {
    return movieId;
  }


  /**
   * Sets the value of the 'movieId' field.
   * @param value the value to set.
   */
  public void setMovieId(int value) {
    this.movieId = value;
  }

  /**
   * Creates a new MovieElasticSearch RecordBuilder.
   * @return A new MovieElasticSearch RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder newBuilder() {
    return new com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder();
  }

  /**
   * Creates a new MovieElasticSearch RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MovieElasticSearch RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder newBuilder(com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder(other);
    }
  }

  /**
   * Creates a new MovieElasticSearch RecordBuilder by copying an existing MovieElasticSearch instance.
   * @param other The existing instance to copy.
   * @return A new MovieElasticSearch RecordBuilder
   */
  public static com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder newBuilder(com.kafkastreams.movie.commons.avro.MovieElasticSearch other) {
    if (other == null) {
      return new com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder();
    } else {
      return new com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder(other);
    }
  }

  /**
   * RecordBuilder for MovieElasticSearch instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MovieElasticSearch>
    implements org.apache.avro.data.RecordBuilder<MovieElasticSearch> {

    private java.lang.String title;
    private java.util.List<java.lang.String> genre;
    private java.lang.String synopsis;
    private java.time.Instant releaseYear;
    private java.lang.String image;
    private float rating;
    private java.util.List<java.lang.String> director;
    private java.util.List<java.lang.String> cast;
    private java.util.List<java.lang.String> url;
    private int movieId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.genre)) {
        this.genre = data().deepCopy(fields()[1].schema(), other.genre);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.synopsis)) {
        this.synopsis = data().deepCopy(fields()[2].schema(), other.synopsis);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.releaseYear)) {
        this.releaseYear = data().deepCopy(fields()[3].schema(), other.releaseYear);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.image)) {
        this.image = data().deepCopy(fields()[4].schema(), other.image);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.rating)) {
        this.rating = data().deepCopy(fields()[5].schema(), other.rating);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.director)) {
        this.director = data().deepCopy(fields()[6].schema(), other.director);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.cast)) {
        this.cast = data().deepCopy(fields()[7].schema(), other.cast);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.url)) {
        this.url = data().deepCopy(fields()[8].schema(), other.url);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.movieId)) {
        this.movieId = data().deepCopy(fields()[9].schema(), other.movieId);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
    }

    /**
     * Creates a Builder by copying an existing MovieElasticSearch instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafkastreams.movie.commons.avro.MovieElasticSearch other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.genre)) {
        this.genre = data().deepCopy(fields()[1].schema(), other.genre);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.synopsis)) {
        this.synopsis = data().deepCopy(fields()[2].schema(), other.synopsis);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.releaseYear)) {
        this.releaseYear = data().deepCopy(fields()[3].schema(), other.releaseYear);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.image)) {
        this.image = data().deepCopy(fields()[4].schema(), other.image);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.rating)) {
        this.rating = data().deepCopy(fields()[5].schema(), other.rating);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.director)) {
        this.director = data().deepCopy(fields()[6].schema(), other.director);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.cast)) {
        this.cast = data().deepCopy(fields()[7].schema(), other.cast);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.url)) {
        this.url = data().deepCopy(fields()[8].schema(), other.url);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.movieId)) {
        this.movieId = data().deepCopy(fields()[9].schema(), other.movieId);
        fieldSetFlags()[9] = true;
      }
    }

    /**
      * Gets the value of the 'title' field.
      * @return The value.
      */
    public java.lang.String getTitle() {
      return title;
    }


    /**
      * Sets the value of the 'title' field.
      * @param value The value of 'title'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setTitle(java.lang.String value) {
      validate(fields()[0], value);
      this.title = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'title' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearTitle() {
      title = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'genre' field.
      * @return The value.
      */
    public java.util.List<java.lang.String> getGenre() {
      return genre;
    }


    /**
      * Sets the value of the 'genre' field.
      * @param value The value of 'genre'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setGenre(java.util.List<java.lang.String> value) {
      validate(fields()[1], value);
      this.genre = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'genre' field has been set.
      * @return True if the 'genre' field has been set, false otherwise.
      */
    public boolean hasGenre() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'genre' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearGenre() {
      genre = null;
      fieldSetFlags()[1] = false;
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
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setSynopsis(java.lang.String value) {
      validate(fields()[2], value);
      this.synopsis = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'synopsis' field has been set.
      * @return True if the 'synopsis' field has been set, false otherwise.
      */
    public boolean hasSynopsis() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'synopsis' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearSynopsis() {
      synopsis = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'releaseYear' field.
      * @return The value.
      */
    public java.time.Instant getReleaseYear() {
      return releaseYear;
    }


    /**
      * Sets the value of the 'releaseYear' field.
      * @param value The value of 'releaseYear'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setReleaseYear(java.time.Instant value) {
      validate(fields()[3], value);
      this.releaseYear = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'releaseYear' field has been set.
      * @return True if the 'releaseYear' field has been set, false otherwise.
      */
    public boolean hasReleaseYear() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'releaseYear' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearReleaseYear() {
      fieldSetFlags()[3] = false;
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
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setImage(java.lang.String value) {
      validate(fields()[4], value);
      this.image = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'image' field has been set.
      * @return True if the 'image' field has been set, false otherwise.
      */
    public boolean hasImage() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'image' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearImage() {
      image = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'rating' field.
      * @return The value.
      */
    public float getRating() {
      return rating;
    }


    /**
      * Sets the value of the 'rating' field.
      * @param value The value of 'rating'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setRating(float value) {
      validate(fields()[5], value);
      this.rating = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'rating' field has been set.
      * @return True if the 'rating' field has been set, false otherwise.
      */
    public boolean hasRating() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'rating' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearRating() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'director' field.
      * @return The value.
      */
    public java.util.List<java.lang.String> getDirector() {
      return director;
    }


    /**
      * Sets the value of the 'director' field.
      * @param value The value of 'director'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setDirector(java.util.List<java.lang.String> value) {
      validate(fields()[6], value);
      this.director = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'director' field has been set.
      * @return True if the 'director' field has been set, false otherwise.
      */
    public boolean hasDirector() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'director' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearDirector() {
      director = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'cast' field.
      * @return The value.
      */
    public java.util.List<java.lang.String> getCast() {
      return cast;
    }


    /**
      * Sets the value of the 'cast' field.
      * @param value The value of 'cast'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setCast(java.util.List<java.lang.String> value) {
      validate(fields()[7], value);
      this.cast = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'cast' field has been set.
      * @return True if the 'cast' field has been set, false otherwise.
      */
    public boolean hasCast() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'cast' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearCast() {
      cast = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'url' field.
      * @return The value.
      */
    public java.util.List<java.lang.String> getUrl() {
      return url;
    }


    /**
      * Sets the value of the 'url' field.
      * @param value The value of 'url'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setUrl(java.util.List<java.lang.String> value) {
      validate(fields()[8], value);
      this.url = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'url' field has been set.
      * @return True if the 'url' field has been set, false otherwise.
      */
    public boolean hasUrl() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'url' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearUrl() {
      url = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'movieId' field.
      * @return The value.
      */
    public int getMovieId() {
      return movieId;
    }


    /**
      * Sets the value of the 'movieId' field.
      * @param value The value of 'movieId'.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder setMovieId(int value) {
      validate(fields()[9], value);
      this.movieId = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'movieId' field has been set.
      * @return True if the 'movieId' field has been set, false otherwise.
      */
    public boolean hasMovieId() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'movieId' field.
      * @return This builder.
      */
    public com.kafkastreams.movie.commons.avro.MovieElasticSearch.Builder clearMovieId() {
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MovieElasticSearch build() {
      try {
        MovieElasticSearch record = new MovieElasticSearch();
        record.title = fieldSetFlags()[0] ? this.title : (java.lang.String) defaultValue(fields()[0]);
        record.genre = fieldSetFlags()[1] ? this.genre : (java.util.List<java.lang.String>) defaultValue(fields()[1]);
        record.synopsis = fieldSetFlags()[2] ? this.synopsis : (java.lang.String) defaultValue(fields()[2]);
        record.releaseYear = fieldSetFlags()[3] ? this.releaseYear : (java.time.Instant) defaultValue(fields()[3]);
        record.image = fieldSetFlags()[4] ? this.image : (java.lang.String) defaultValue(fields()[4]);
        record.rating = fieldSetFlags()[5] ? this.rating : (java.lang.Float) defaultValue(fields()[5]);
        record.director = fieldSetFlags()[6] ? this.director : (java.util.List<java.lang.String>) defaultValue(fields()[6]);
        record.cast = fieldSetFlags()[7] ? this.cast : (java.util.List<java.lang.String>) defaultValue(fields()[7]);
        record.url = fieldSetFlags()[8] ? this.url : (java.util.List<java.lang.String>) defaultValue(fields()[8]);
        record.movieId = fieldSetFlags()[9] ? this.movieId : (java.lang.Integer) defaultValue(fields()[9]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MovieElasticSearch>
    WRITER$ = (org.apache.avro.io.DatumWriter<MovieElasticSearch>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MovieElasticSearch>
    READER$ = (org.apache.avro.io.DatumReader<MovieElasticSearch>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










