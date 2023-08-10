
# kafka-streams-movies-aggregator
transform normalized movies data from multiple kafka topics(send by cdc postgres) into denormalized movies data, then send it to movies-output and consumed by es connector. Then the data stored/updarted in elasticsearch index


1. download postgres-connector-jar java 8 in https://jdbc.postgresql.org/download/
   copy and paste jar file to "docker/kafka-connect/jars" directory


2. download elasticseaerch-sink-connector version 14.0.6 in https://www.confluent.io/hub/confluentinc/kafka-connect-elasticsearch
   copy and paste zip file into docker/kafka-connect directory


3. download jdbc connector version 10.7.1 in https://www.confluent.io/hub/confluentinc/kafka-connect-jdbc
   copy and paste zip file into docker/kafka-connect directory



    > docker compose up -d
    > bash create-topics.sh
    > bash kafka-connect.sh
    > bash connect-health.sh
    > run movie-service application
    > import postman  & test add actor,category,...,movies
    > bash check-isi-topics.sh


