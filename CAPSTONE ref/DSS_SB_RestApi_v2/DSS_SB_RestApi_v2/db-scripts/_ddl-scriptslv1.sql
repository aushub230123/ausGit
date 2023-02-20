-- DDL SCRIPTS
drop database DSSDbCap;
create database DSSDbCap;
USE DSSDbCap;
CREATE TABLE actors (
  actor_id int NOT NULL auto_increment,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
   gender varchar(255) NOT NULL,
   age int NOT NULL,
  about varchar(255) NOT NULL,
  actor_url varchar(255),
  PRIMARY KEY (actor_id)
) ;

CREATE TABLE movies (
  movie_id int NOT NULL auto_increment,
  actor_id int NOT NULL,
  movie_name varchar(255) NOT NULL,
  cost int NOT NULL,
  duration int NOT NULL,
  genre_id int NOT NULL,
  overview varchar(500) DEFAULT NULL,
  release_year int NOT NULL,
  movie_url varchar(255) NOT NULL,
  PRIMARY KEY (movie_id),
  FOREIGN KEY (ACTOR_ID) REFERENCES ACTORS(ACTOR_ID)
);

# DROP TABLE REVIEWS;
CREATE TABLE reviews (
  review_id int NOT NULL auto_increment,
  movie_id int NOT NULL,
  date_posted varchar(10) NOT NULL,
  description varchar(500) NOT NULL,
  rating int NOT NULL,
  PRIMARY KEY (review_id),
  FOREIGN KEY (MOVIE_ID) REFERENCES MOVIES(MOVIE_ID)
) ;

drop table users;
CREATE TABLE users (
  user_id int NOT NULL auto_increment,
  password varchar(250) NOT NULL,
  email varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  phone varchar(15) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE (email)
);

create table genres (genre_id int NOT NULL auto_increment,
  name varchar(50) NOT NULL,
   UNIQUE (name),
   PRIMARY KEY (genre_id)
   );

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
);
INSERT INTO `hibernate_sequence` VALUES (1);

-- DML SCRIPTS
INSERT INTO actors (first_name,last_name,gender,age,about) VALUES 
('Ganges','Ahmad','Male','16','Ever green');
INSERT INTO actors (first_name,last_name,gender,age,about) VALUES 
('Shankar','S','Male','16','Mr.Cool'),
('Irene','Irene','Female','16','Miss pretty'),
('Joseph','h','Male','16','Miss pretty'),
('Ben','Irene','Female','16','Miss pretty');

-- SELECT SCRIPTS
# select * from reviews;

-- INSERT
insert into movies( actor_id , movie_name , cost , duration , genre_id , overview , release_year , movie_url)
  values (1,'TEST MOVIE',100,2,1,'The movie of the year',2022,'/');
# select * from movies;

insert into movies( movie_name,actor_id , duration , genre_id , overview ,movie_url , cost , release_year ) values

('Disney Princess Enchanted Tales: Follow Your Dreams',1,2,1,'Princess Aurora and Princess Jasmine learn valuable life lessons in two short stories.','/assets/DisneyPrincessEnchanted.jpg',100,2004),
('Lightyear',2,3,1,'Legendary Space Ranger Buzz Lightyear embarks on an intergalactic adventure alongside a group of ambitious recruits and his robot companion Sox.','/assets/LightYear.jpg',100,2003),
('Nope',3,3,1,'Residents in a lonely gulch of inland California bear witness to an uncanny, chilling discovery.','/assets/Nope.jpg',100,2005),
('Turning Red',2,3,2,'Thirteen-year-old Mei is experiencing the awkwardness of being a teenager with a twist – when she gets too excited, she transforms into a giant red panda.','/assets/TurningRed.jpg',100,2004),
('She Hulk',4,2,2,'Jennifer Walters navigates the complicated life of a single, 30-something attorney who also happens to be a green 6-foot-7-inch superpowered hulk.','/assets/SheHulk.jpg',100,2005),
('The Princess',3,4,1,'A beautiful, strong-willed young royal refuses to wed the cruel sociopath to whom she is betrothed and is kidnapped and locked in a remote tower of her father’s castle. With her scorned, vindictive suitor intent on taking her father’s throne, the princess must protect her family and save the kingdom.','/assets/ThePrincess.jpg',100,2004),
('Thirteen Lives',1,3,1,'Based on the true nail-biting mission that captivated the world. Twelve boys and the coach of a Thai soccer team explore the Tham Luang cave when an unexpected rainstorm traps them in a chamber inside the mountain. Entombed behind a maze of flooded cave tunnels, they face impossible odds. A team of world-class divers navigate through miles of dangerous cave networks to discover that finding the boys is only the beginning.','/assets/ThirteenLives.jpg',100,2002),
('Enchanto',5,3,2,'The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family last hope.','/assets/Enchanto.jpg',100,2002),
('Sonic the Hedgehog 2',2,2,1,'After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations. Sonic teams up with his own sidekick, Tails, and together they embark on a globe-trotting journey to find the emerald before it falls into the wrong hands.','/assets/SonicTheHedgehog.jpg',100,2005),
('The Sea Beast' ,3,3,2,'The life of a legendary sea monster hunter is turned upside down when a young girl stows away on his ship.','/assets/TheSeaBeast.jpg',100,2002);

insert into reviews ( movie_id , date_posted ,description , rating)values
(1,'2002-12-14','Excellect',5),
(1,'2010-09-07','Excellect',5);
# select * from reviews;

delete from users;
insert into users (user_id,name , email ,phone,password )values( 1,'Tulip','admin@gmail.com','98765432','1a1dc91c907325c69271ddf0c944bc72');
# select * from users;
update movies set release_year = 2000 where movie_id = 1;

# select * from genres;
insert into genres
values(1,'Action Genre'),
(2,'Animation Genre'),
(3,'Comedy Genre'),
(4,'Crime Genre'),
(5,'Drama Genre'),
(6,'Experimental Genre'),
(7,'Fantasy Genre'),
(8,'Historical Genre'),
(9,'Horror Genre'),
(10,'Romance Genre'),
(11,'Science Fiction Genre'),
(12,'Thriller Genre'),
(13,'Western Genre'),
(14,'Other Genres');

select * from users;
select * from actors;
select * from movies;
select * from genres;
select * from reviews;
