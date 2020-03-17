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
INSERT INTO megacode.image(id,type_image_id,application_id,path,comments_image,title_imaghe) VALUES (1,1,1,'','Image Test 1', 'Image #1');
INSERT INTO megacode.image(id,type_image_id,application_id,path,comments_image,title_imaghe) VALUES (2,1,1,'','Image Test 2', 'Image #2');
INSERT INTO megacode.image(id,type_image_id,application_id,path,comments_image,title_imaghe) VALUES (3,1,1,'','Image Test 3', 'Image #3');

-- Labels
INSERT INTO megacode.label (id,app_id,code,label_es,label_en) VALUE (1,1,'megacode.taskmanager.title','Megacode','Megacode');
