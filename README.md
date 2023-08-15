
# kafka-streams-movies-aggregator
transform normalized movies data from multiple kafka topics(send by cdc postgres) into denormalized movies data, then send it to movies-output and consumed by es connector. Then the data stored/updarted in elasticsearch index.



1. download elasticseaerch-sink-connector version 14.0.6 in https://www.confluent.io/hub/confluentinc/kafka-connect-elasticsearch
   copy and paste zip file into docker/kafka-connect directory




 ```
     docker compose up -d
     bash create-topics-2.sh
     bash kafka-connect-2.sh
     bash connect-health-2.sh
     run movie-service application
     import postman  & test add actor,category,...,movies
     bash check-isi-topic-2.sh
 ```

