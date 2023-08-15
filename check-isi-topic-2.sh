docker run --tty \
           --network kafka-streams-movies-aggregator-2_default \
           confluentinc/cp-kafkacat:7.0.10 \
           kafkacat -b kafka:9092 -C -K: \
              -s key=i -s value=avro \
                       -r http://schema-registry:8081 \
                    -f '\nKey (%K bytes): %k\t\nValue (%S bytes): %s\n\Partition: %p\tOffset: %o\n--\n' \
                    -t movies-output

#send to elasticsearch ?
