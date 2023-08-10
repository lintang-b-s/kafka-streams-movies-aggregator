

docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.actors
echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.categories

echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.creators

echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.movie_actor
echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.movie_category
echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.movie_creator
echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.movie_tag
echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.movies
echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.tags
echo
docker exec -t zookeeper kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 2  --topic postgresql.tenflix.videos
echo
