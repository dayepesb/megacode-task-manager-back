DELETE FROM megacode.label;
DELETE FROM megacode.image;
DELETE FROM megacode.type_image;
DELETE FROM megacode.application;

-- applications
INSERT INTO megacode.application(id,name) VALUE (1,'task-manager');
INSERT INTO megacode.application(id,name) VALUE (2,'online-judge');

-- type images
INSERT INTO megacode.type_image(id,name_type,comments) VALUE (1,'principal-page',null);
INSERT INTO megacode.type_image(id,name_type,comments) VALUE (2,'user-profile',null);

-- images
INSERT INTO megacode.image(id,type_image_id,application_id,path,comments_image,title_imaghe) VALUES (1,1,1,'images/general/BCC35C16846159B80A8897FF20803BC2-slide_1.png','', 'App Megacode');
-- Labels
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (1,1,'megacode.taskmanager.title','Megacode','Megacode');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (2,1,'megacode.kanban.title','Kanban','Kanban');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (3,1,'megacode.kanban.description','Maneja las historias de usuario y las incidencias en un solo espacio verificando el estado de cada tarea.','Manage user stories and incidents in a single space, checking the status of each task.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (4,1,'megacode.profile.title','Perfil','Profile');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (5,1,'megacode.profile.description','Conectate con tu perfil a varias plataformas. Completa y edita tu información basica.','Connect with your profile to various platforms. Complete and edit your basic information.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (6,1,'megacode.principal.page.user.title','Supervisa tus proyectos','Monitor your projects');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (7,1,'megacode.principal.page.user.description','Puedes monitorear los proyectos en los que eres administrador y eres desarrollador, destacando los poryectos mas recurrentes. Tambien puedes ver las invitaciones pendientes para unirte a proyectos.','You can monitor the projects in which you are an administrator and a developer, highlighting the most recurring projects. You can also see pending invitations to join projects.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (8,1,'megacode.define.flow.title','Define El Flujo','Define The Flow');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (9,1,'megacode.define.flow.description','Puedes agregar o quitar el flujo de trabajo de las tareas como quieras.','You can add or remove the task workflow as you like.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (10,1,'megacode.app.title','Continua El trabajo Desde Cualquier Parte','Work Continues From Anywhere');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (11,1,'megacode.app.description','Ahora puedes continuar el trabajo descargando la app de megacode y supervisar los proyectos en que haces parte.','Now you can continue the work by downloading the megacode app and supervising the projects you are part of.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (12,1,'megacode.label.home','Home','Home');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (13,1,'megacode.authentication.login','Login','Login');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (14,1,'megacode.authentication.register','Registrate','Register');

INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (15,1,'megacode.placeholder.name','Nombre', 'Name');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (16,1,'megacode.placeholder.lastname','Apellido', 'Lastname');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (17,1,'megacode.placeholder.username','Nombre de Usuario', 'Username');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (18,1,'megacode.placeholder.email','Correo Electronico', 'Email');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (19,1,'megacode.placeholder.password','Contraseña','Password');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (20,1,'megacode.label.signin','Sign in','Sign in');

INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (21,1,'megacode.form.error','Eroor en el formulario','Form Error');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (22,1,'megacode.form.name.empty','El nombre no puede estar vacio','The name cannot be empty.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (23,1,'megacode.form.lastname.empty','El apellido no puede estar vacio','The lastname cannot be empty.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (24,1,'megacode.form.username.empty','El nombre de usuario no puede estar vacio','The username cannot be empty.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (25,1,'megacode.form.email.empty','El correo electronico no puede estar vacio','The email connot bew empty.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (26,1,'megacode.form.email.invalid','El formato del correo no es correcto','The email format is not correct.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (27,1,'megacode.form.password.empty','La contraseña no puede estar vacia','The password cannot be empty.');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (28,1,'megacode.form.password.invalid','La contraseña debe tener una mayuscula, una minuscula, un numero y debe tener minimo 8 caracteres','The password must have a capital letter, a lower case, number and must have a minimum of 8 characters');
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (29,1,'megacode.form.username.exist','El nombre de usuario ya existe.','Username already exist.');

--INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (20,1,'megacode.','','');