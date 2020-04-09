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