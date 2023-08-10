
# director

docker run --tty \
           --network kafka-streams-movies-aggregator_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.creators



docker run --tty \
           --network kafka-streams-movies-aggregator_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.actors



docker run --tty \
           --network kafka-streams-movies-aggregator_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.movies


docker run --tty \
           --network kafka-streams-movies-aggregator_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t postgresql.tenflix.categories




