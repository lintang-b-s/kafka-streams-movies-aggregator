
import json
import requests
import sys

addMovieUrl = "http://localhost:8200/api/v1/movie-service/movies"
addVideourl = "http://localhost:8200/api/v1/movie-service/videos"
addActorUrl = "http://localhost:8200/api/v1/movie-service/actors"
addDirectorUrl = "http://localhost:8200/api/v1/movie-service/creators"
addCategoryUrl = "http://localhost:8200/api/v1/movie-service/categories"

fMap = "movies-data.json"
fVideo = "video-data.json"
fActor = "actors-data.json"
fCategory= "categories-data.json"
fDirector = "directors-data.json"

headers = {'Content-type': 'application/json', 'Accept': '*/*'}

# add actor
print("don't exit terminal!!!!, wait for 10 minutes, wait until done message printed!!, if exit must do following command: docker compose down, delete all docker volumes, and repeat command in readme again ")
with open(fActor, "r", encoding='utf-8') as f:
    actor_list = json.load(f)
    for idx,actor in enumerate(actor_list):
        rActor = requests.post(addActorUrl, data=json.dumps(actor), headers=headers)


# insert director
with open(fDirector, "r", encoding='utf-8') as f:
    director_list = json.load(f)
    for idx, director in enumerate(director_list):
        rDirector = requests.post(addDirectorUrl, data=json.dumps(director), headers=headers)

with open(fCategory, "r", encoding='utf-8') as f:
    category_list = json.load(f)
    for idx, category in enumerate(category_list):
        rCategory = requests.post(addCategoryUrl, data=json.dumps(category), headers=headers)

varchar = slice(254)

# insert movie
with open(fMap, "r", encoding='utf-8') as f:
    my_list = json.load(f)

    for idx, movie in enumerate(my_list):
        rMap = requests.post(addMovieUrl, data=json.dumps(movie), headers=headers)


# insert video
with open(fVideo, "r", encoding='utf-8') as f:
    video_list = json.load(f)
    for idx,video in enumerate(video_list):
        reqVideo = requests.post(addVideourl, data=json.dumps(video), headers=headers)


print("done!!!")
