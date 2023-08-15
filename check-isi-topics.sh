
# director

docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
              -s key=s -s value=avro \
                       -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.creators


echo
docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
            -s key=s -s value=avro \
                                  -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.actors



echo
docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
            -s key=s -s value=avro \
                      -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.videos

echo
docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
            -s key=s -s value=avro \
                      -r http://schema-registry:8081 \
                    -f '\nKey (%S bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.movie_actor
echo
docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K:  -r http://schema-registry:8081 -s avro -o beginning   \
                    -t postgresql.tenflix.movie_actor


echo
kcat -b localhost:29092 -C -K:  -r http://localhost:8081 -s key=s -s value=avro -o beginning   \
                    -t postgresql.tenflix.movie_actor
echo
docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
            -s key=s -s value=avro \
                      -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.movie_category


echo
docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
            -s key=s -s value=avro \
                      -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.movie_tag


echo
docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
            -s key=s -s value=avro \
                      -r http://schema-registry:8081 \
                    -f '\nKey (%S bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.movie_creator


echo
docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
           -s key=s -s value=avro \
            -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.movies

docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
              -s key=s -s value=avro \
                       -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.categories


docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
              -s key=s -s value=avro \
                       -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.movie_category




docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
           -s key=s -s value=avro \
            -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t movies-output
