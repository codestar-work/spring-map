use caltex;
create table users (
  id         serial,
  email      nvarchar(200) unique,
  password   varchar(2048),
  name       nvarchar(2048)
);

insert into users(name, email, password)
  values('User', 'user@codestar.work', sha2('password', 256));
