delete from movies;

alter table movies auto_increment = 1;


insert into movies (id, name, release_date, rating, genre, producer) values
(1, "Homem-Aranha", "2002-05-17 03:00:00", 4, "Ação", "Sam raimi"),
(2, "Shrek", "2001-06-22 03:00:00", 5, "Fantasia", "Andrew Adamson"),
(3, "Bugador Pexoal", "2001-06-30 03:00:00", 1, "Ação", "Shark Macedo"),
(4, "Interestelar", "2014-11-06 03:00:00", 5, "Ficção Científica", "Christopher Nolan"),
(5, "Corra!", "2017-05-18 03:00:00", 4, "Terror", "Jordan Peele");

