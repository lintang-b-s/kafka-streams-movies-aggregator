curl -i -X POST http://localhost:8083/connectors \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -d @config/debezium-postgres2.json

echo
curl -i -X PUT http://localhost:9200/movies \
  -H 'Content-Type: application/json' \
    -H 'Accept: application/json' \
  -d @config/movie-mapping.json

echo
curl -i -X PUT http://localhost:9200/movieswiki \
  -H 'Content-Type: application/json' \
    -H 'Accept: application/json' \
  -d @config/movie-mapping.json

echo
curl -i -X POST http://localhost:8083/connectors \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -d @config/movie-elasticsearch.json
