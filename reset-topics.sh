# eksekusi command dibawah, jika ingin membaca topic  dari awal di kakfa streams

docker exec -t zookeeper kafka-streams-application-reset --bootstrap-servers kafka:9092 --force \
  --application-id movies-application --input-topics postgresql.tenflix.actors,postgresql.tenflix.categories,postgresql.tenflix.creators,postgresql.tenflix.movie_actor,postgresql.tenflix.movie_category,postgresql.tenflix.movie_creator,postgresql.tenflix.movie_tag,postgresql.tenflix.movies,postgresql.tenflix.tags,postgresql.tenflix.videos
