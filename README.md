
# kafka-streams-movies-aggregator
transform normalized movies data from multiple kafka topics(send by cdc postgres) into denormalized movies data, then send it to movies-output and consumed by es connector. Then the data stored/updarted in elasticsearch index.



1. download elasticseaerch-sink-connector version 14.0.6 in https://www.confluent.io/hub/confluentinc/kafka-connect-elasticsearch
   copy and paste zip file into docker/kafka-connect directory




 ```
     1. docker compose up -d
     2. bash create-topics-2.sh
     wait for kafka-connect loaded all plugin
     3. bash kafka-connect-2.sh
     4. bash connect-health-2.sh
     5. run movie-service application
     6. import postman  & test add actor,category,...,movies
     7. run movie-streams application
     8.  go to localhost:9001 to see message in each topic
     9. test query with elasticserach index "movieswiki" in localhost:9200
 ```

