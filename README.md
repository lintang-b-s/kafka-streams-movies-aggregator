
# kafka-streams-movies-aggregator
transform normalized movies data from multiple kafka topics(send by cdc postgres) into denormalized movies data, then send it to movies-output and consumed by es connector. Then the data stored/updarted in elasticsearch index.


### Prequisite
1. download elasticseaerch-sink-connector version 14.0.6 in https://www.confluent.io/hub/confluentinc/kafka-connect-elasticsearch
   copy and paste zip file into docker/kafka-connect directory
2. 
2. download zip file in https://drive.google.com/drive/folders/1zQD_gCFQ8yK2V-7K46a2gqxhh2gu3XDJ?usp=sharing 
 , copy and paste all json files in root project directory
3. download & install apache maven https://maven.apache.org/download.cgi



### run the application in docker:
 ```
     1. ./mvnw  package -DskipTests
     2. docker compose up -d

       wait for all container running & kafka-connect loaded all plugin 
     3. bash create-topics-2.sh
     4. bash kafka-connect-2.sh
     5. bash connect-health-2.sh
     6. docker-compose -f docker-compose-app.yml up -d, wait until all container up & running (5-10 minutes, due to building multistage image movie-search), building & creating container movie-service,movie-streams, and movie-search
     7. python3 insertMovieToMovieService.py, wait for 10-15 minutes, wait until "done" message printed. inserting movies data  with releases between 2020-2023 to postgresql from movie-service
     8. docker-compose -f docker-compose-stream.yml up -d, wait about 5-6 minutes for the data stream to process
     9. import postman collection file in config/movie-test-stream.postman_collection.json
    10. test the query for movies with releases between 2020-2023(ex. Oppenheimer, Dune,etc. Not all movies available)  using the movie-elasticsearch(port 8080) folder in the postman collection (dont search by query release year due to a timestamp stream conversion failure)
    
 ```




### run the application locally:
 ```
     1. ./mvnw  package -DskipTests
     2. docker compose up -d
   
       wait for all container running & kafka-connect loaded all plugin 
     3. bash create-topics-2.sh
     4. bash kafka-connect-2.sh
     5. bash connect-health-2.sh
     6. run movie-service application
     7. import postman collection file in config/movie-test-stream.postman_collection.json
     8. run movie-streams application
     9.  go to localhost:9001 to see message in each topic
     10. test query with elasticserach index "movieswiki" in localhost:9200
     11. python3 insertMovieToMovieService.py, wait for 12 minutes. inserting movies data to postgresql
     13. test the query for movies with releases between 2020-2023(ex. Oppenheimer, Dune ,etc. Not all movies available)  using the movie-elasticsearch(port 8080) folder in the postman collection (dont search by query release year due to a timestamp stream conversion failure)
 ```


# Architecture

![Alt text](https://res.cloudinary.com/tutorial-lntng/image/upload/v1692195083/untitled_1_jwagup.png "Architecture")


