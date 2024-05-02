create table users
(
    id serial primary key
);

create table user_user_roles
(
    user_id      int not null references users ON DELETE CASCADE,

    user_role_id int,
    primary key (user_id, user_role_id)
);

create table user_roles
(
    id   int primary key,
    name varchar(32)
);



create table names
(
    id          int not null primary key references users ON DELETE CASCADE,
    first_name  varchar(128),
    second_name varchar(128),
    third_name  varchar(128)
);

create table info
(
    id          int not null primary key references users ON DELETE CASCADE,
    sex         char,
    births_date date,
    job         varchar(128)
);


create table contact_info
(
    id        int not null primary key references users ON DELETE CASCADE,
    address   varchar(256),
    telephone bigint,
    email     varchar(32)
);


create table biochemical_results
(
    id                     serial primary key,
    id_user                int not null references users ON DELETE set null,
    date_time_get_material date,
    date_time_added_result date,
    ALT                    float,
    AST                    float,
    creatinin              float,
    mochevina              float,
    bilirubin_obsh         float,
    bilirubin_priamoi      float,
    bilirubin_nepriamoi    float,
    cholestirin            float,
    glucose                float
);

create table OAK_results
(
    id                          serial primary key,
    id_user                     int not null references users ON DELETE set null,
    date_time_get_material      date,
    date_time_added_result      date,
    RBC                         int,
    WBC                         int,
    trobocitis                  int,
    hb                          float,
    hematocrit                  float,
    cp                          float,
    reticulocitis               int,
    SOE                         float,
    palochkoydernie_granulociti float,
    segmentoydernie_granulociti float,
    eosinofiles                 float,
    basofiles                   float,
    limfocites                  float,
    monocites                   float,
    metolmielocites             float,
    mielocites                  float
);



insert into users default
values;
insert into users default
values;
insert into users default
values;
insert into users default
values;
insert into users default
values;
insert into users default
values;


insert into names (id, first_name, second_name, third_name)
values (1, 'Александр', 'Бессонов', 'Викторович'),
       (2, 'Николай', 'Ковтун', 'Владимирович'),
       (3, 'Мария', 'Ковтун', 'Андреевна'),
       (4, 'Олег', 'Ковалев', 'Игоревич'),
       (5, 'Борис', 'Чумаян', 'Андреевич'),
       (6, 'Серегей', 'Татьсян', 'Сереевич');


insert into contact_info(id, address, telephone, email)
values (1, 'г.Ростов-на-Дону, ул Пушкина, д 4,кв 2', 89993334422, 'email@email.com'),
       (2, 'г.Ростов-на-Дону, ул Ленина, д 2,кв 3', 89995552222, 'addres@email.com'),
       (3, 'г.Ростов-на-Дону, ул Нагибина, д 123,кв 5', 8999324432, 'email2@email.com'),
       (4, 'г.Ростов-на-Дону, ул Беляева, д 23,кв 45', 89993332322, 'email4@email.com'),
       (5, 'г.Ростов-на-Дону, ул Орбитальная, д 144,кв 6', 89991344822, 'email123@email.com'),
       (6, 'г.Ростов-на-Дону, ул Обсерваторная, д 41', 89121344822, 'email123уу@email.com');

insert into biochemical_results (id_user, ALT, AST, creatinin, mochevina, bilirubin_obsh, bilirubin_priamoi,
                                 bilirubin_nepriamoi, cholestirin, glucose)
values (1, 41.2, 26.0, 99.4, 3.9, 22.4, 6.3, 13.34, 4.1, 5.1),
       (2, 44.2, 25.1, 89.5, 4.2, 43.2, 4.2, 14.54, 5.8, 4.1),
       (3, 40.3, 23.0, 97.2, 3.6, 21.3, 5.1, 15.76, 6.9, 1.1),
       (4, 41.5, 24.7, 110.8, 3.3, 22.5, 6.2, 18.23, 2.5, 6.1),
       (5, 45.6, 20.8, 120.5, 3.7, 49.7, 5.4, 37.12, 4.5, 20.1),
       (6, 39.5, 21.9, 104.9, 2.2, 32.1, 4.3, 13.43, 7.3, 5.1),
       (4, 44.2, 22.5, 95.7, 4.54, 24.2, 8.2, 16.24, 9.2, 6.1);

insert into OAK_results (id_user, RBC, WBC, trobocitis, hb, hematocrit, cp, reticulocitis, SOE,
                         palochkoydernie_granulociti, segmentoydernie_granulociti, eosinofiles, basofiles,
                         limfocites, monocites, metolmielocites, mielocites)
values (1, 3.8, 5, 200, 120, 41, 95, 0.1, 5, 4, 47, 5, 0, 24, 1, 0, 0),
       (2, 3.8, 2, 250, 160, 44, 91, 0.2, 1, 4, 41, 4, 1, 22, 4, 0, 0),
       (3, 3.6, 5, 256, 110, 42, 87, 0.3, 10, 4, 49, 2, 2, 25, 5, 0, 0),
       (4, 3.3, 4, 225, 130, 41, 88, 6, 5, 20, 46, 3, 0, 26, 3, 0, 0),
       (4, 2.2, 5, 259, 111, 43, 89, 0.1, 5, 50, 48, 2, 1, 21, 2, 0, 0),
       (5, 4.1, 3, 245, 90, 45, 99, 0.5, 5, 4, 44, 1, 1, 22, 1, 0, 0),
       (6, 1.5, 5, 307, 60, 41, 70, 0.1, 5, 3, 48, 1, 5, 21, 0, 0, 0);

insert into info (id, sex, births_date, job)
values (1, 'M', '1996-12-17', 'Програмист'),
       (2, 'M', '1996-12-24', 'Врач'),
       (3, 'M', '1996-06-13', 'Экономист'),
       (4, 'M', '1996-03-31', 'Продавец'),
       (5, 'M', '1997-07-08', 'Програмист'),
       (6, 'M', '1995-09-22', 'Металорезчик');



select *
from names;

select *
from users;
select *
from contact_info;


select *
from biochemical_results;



select *
from users;

select *
from users
         join contact_info ci on users.id = ci.id
         join names n on users.id = n.id
         join info i2 on users.id = i2.id;

truncate table biochemical_results;



select address,
       telephone,
       email,
       first_name,
       second_name,
       third_name,
       sex,
       births_date,
       job,
       user_role_id,
       ur.id,
       ur.name
from users
         join contact_info ci on users.id = ci.id
         join names n on users.id = n.id
         join info i2 on users.id = i2.id
         left join user_user_roles uur on users.id = uur.user_id
         left outer join user_roles ur on uur.user_role_id = ur.id
where user_id = 4;

