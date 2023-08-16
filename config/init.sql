
drop table if exists actors;
drop table if exists  categories ;
drop table if exists  creators ;
drop table if exists  movie_actor ;
drop table if exists  movie_category ;
drop table if exists  movie_creator ;
drop table if exists  movie_outbox ;
drop table if exists  movie_tag ;
drop table if exists  movies ;
drop table if exists  tags ;
drop table if exists  videos  ;

-- on delete cascade on update cascade in movies-videos
-- on update cascade on delete restrict in all movies-*

-- create function last_updated_on created_on
CREATE FUNCTION trigger_set_timestamp()
    RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;



-- create sequence

CREATE SEQUENCE  movies_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE  movies_id_seq OWNER TO netflik;




CREATE SEQUENCE  actors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE  actors_id_seq OWNER TO netflik;

CREATE SEQUENCE  creators_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE  creators_id_seq OWNER TO netflik;

CREATE SEQUENCE  categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE  categories_id_seq OWNER TO netflik;

CREATE SEQUENCE  tags_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE  tags_id_seq OWNER TO netflik;

CREATE SEQUENCE  videos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE  videos_id_seq OWNER TO netflik;




-- create table

create table  movies (
   id integer DEFAULT nextval('movies_id_seq'::regclass) NOT NULL,
   idmb_rating integer NOT NULL,
   image character varying(255),
   mpa_rating character varying(255),
   name character varying(255),
   r_year TIMESTAMP(6),
   synopsis text,
   type character varying(255),
   notification boolean ,
   created_on TIMESTAMP WITH TIME ZONE not null ,
   last_updated_on TIMESTAMP WITH TIME ZONE not null
);


create table  movie_actor (
        movie_id integer not null ,
        actor_id integer not null ,
        created_on TIMESTAMP WITH TIME ZONE not null default  now() ,
        last_updated_on TIMESTAMP WITH TIME ZONE not null default  now()
);

create table  actors (
       id integer default nextval('actors_id_seq'::regclass) not null ,
       name  character varying(255) not null ,
       created_on TIMESTAMP WITH TIME ZONE not null ,
       last_updated_on TIMESTAMP WITH TIME ZONE not null
);



create table  creators (
     id integer default nextval('creators_id_seq'::regclass) not null ,
     name  character varying(255) not null ,
     created_on TIMESTAMP WITH TIME ZONE not null ,
     last_updated_on TIMESTAMP WITH TIME ZONE not null
);

create table  movie_creator (
  movie_id integer not null ,
  creator_id integer not null ,
  created_on TIMESTAMP WITH TIME ZONE not null default  now() ,
  last_updated_on TIMESTAMP WITH TIME ZONE not null default  now()
);


create table  categories (
   id integer default nextval(' categories_id_seq'::regclass) not null ,
   name  character varying(255) not null ,
   created_on TIMESTAMP WITH TIME ZONE not null  ,
   last_updated_on TIMESTAMP WITH TIME ZONE not null
);

create table  movie_category (
       movie_id integer not null ,
       category_id integer not null,
       created_on TIMESTAMP WITH TIME ZONE not null default  now() ,
       last_updated_on TIMESTAMP WITH TIME ZONE not null default  now()
);


create table  tags (
     id integer default nextval(' tags_id_seq'::regclass) not null ,
     name  character varying(255) not null ,
     created_on TIMESTAMP WITH TIME ZONE not null  ,
     last_updated_on TIMESTAMP WITH TIME ZONE not null
);


create table  movie_tag (
      movie_id integer not null ,
      tag_id integer not null,
      created_on TIMESTAMP WITH TIME ZONE not null default  now() ,
      last_updated_on TIMESTAMP WITH TIME ZONE not null default  now()
);


create table  videos (
   id integer default nextval(' videos_id_seq'::regclass) not null,
   length integer not null,
   public_id character varying(255)  ,
   synopsis text  ,
   title character varying(255)  ,
   url  character varying(255)  ,
   movie_id integer,
   created_on TIMESTAMP WITH TIME ZONE not null  ,
   last_updated_on TIMESTAMP WITH TIME ZONE not null
);


create table   movie_outbox (
      id bigint not null ,
      aggregateid character varying(255) not null ,
      aggregatetype character varying(255) not null ,

      created_time TIMESTAMP(6),
      payload text not null ,
      type character varying(255) not  null

);


--  add primary key

alter table ONLY  movie_actor
    ADD CONSTRAINT movie_actor_pkey PRIMARY KEY (movie_id, actor_id);

alter table ONLY  movie_creator
    ADD CONSTRAINT movie_creator_pkey PRIMARY KEY (movie_id, creator_id);

alter table ONLY  movie_category
    ADD CONSTRAINT movie_category_pkey PRIMARY KEY (movie_id, category_id);

alter table ONLY  movie_tag
    ADD CONSTRAINT movie_tag_pkey PRIMARY KEY (movie_id, tag_id);




alter table ONLY  movies
    ADD CONSTRAINT movies_pkey PRIMARY KEY (id);

alter table ONLY  actors
    ADD CONSTRAINT actors_pkey PRIMARY KEY (id);

alter table ONLY  creators
    ADD CONSTRAINT creators_pkey PRIMARY KEY (id);

alter table ONLY  categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);

alter table ONLY  tags
    ADD CONSTRAINT tags_pkey PRIMARY KEY (id);

alter table only  videos
    add constraint videos_pkey primary key (id);

alter table only  movie_outbox
    add constraint movie_outbox_pkey primary key(id);





--  add foreign key
alter table ONLY  movie_actor
    add constraint movie_actor_actor_id foreign key(actor_id) references  actors(id) on update cascade on delete restrict;

alter table ONLY  movie_actor
    add constraint movie_actor_movie_id foreign key(movie_id) references  movies(id) on update cascade on delete restrict;

alter table ONLY  movie_creator
    add constraint movie_creator_creator_id foreign key(creator_id) references  creators(id) on update cascade on delete restrict;


alter table ONLY  movie_creator
    add constraint movie_creator_movie_id foreign key(movie_id) references  movies(id) on update cascade on delete restrict;


alter table ONLY  movie_category
    add constraint movie_category_movie_id foreign key(movie_id) references  movies(id) on update cascade on delete restrict;


alter table ONLY  movie_category
    add constraint movie_category_category_id foreign key(category_id) references  categories(id) on update cascade on delete restrict;



alter table ONLY  movie_tag
    add constraint movie_tag_movie_id foreign key(movie_id) references  movies(id) on update cascade on delete restrict;


alter table ONLY  movie_tag
    add constraint movie_tag_tag_id foreign key(tag_id) references  tags(id) on update cascade on delete restrict;


alter table only  videos
    add constraint videos_movie_id foreign key(movie_id) references  movies(id) on update cascade on delete cascade;


-- create trigger
create trigger set_timestamp_movie_actor
before
update on movie_actor
execute procedure trigger_set_timestamp();

create trigger set_timestamp_movie_creator
before
update on movie_creator
execute procedure trigger_set_timestamp();

create trigger set_timestamp_movie_category
before
update on movie_category
execute procedure trigger_set_timestamp();

create trigger set_timestamp_movie_tag
before
update on  movie_tag
execute procedure trigger_set_timestamp();


