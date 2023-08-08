# kafka-streams-movies-aggregator
transform normalized movies data from multiple kafka topics(send by cdc postgres) into denormalized movies data, then send it to movies-output and consumed by es connector. Then the data stored/updarted in elasticsearch index
