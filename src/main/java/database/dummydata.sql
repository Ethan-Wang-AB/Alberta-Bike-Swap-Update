
INSERT INTO `absdb`.`event` VALUES (1, 'Calgary event','www.youtube.com/calgary');
INSERT INTO `event` VALUES (2, 'Lethbridge event','www.youtube.com/lethbridge');
INSERT INTO `event` VALUES (3, 'Edmonton event','www.youtube.com/edmonton');


INSERT INTO `state` VALUES (1, 'AB');

INSERT INTO `city` VALUES (1, 'Calgary',1);
INSERT INTO `city` VALUES (2, 'Lethbridge',1);
INSERT INTO `city` VALUES (3, 'Edmonton',1);

INSERT INTO `address` VALUES (1, 'Calgary downtown',1);
INSERT INTO `address` VALUES (2, 'Lethbridge downtown',2);
INSERT INTO `address` VALUES (3, 'Edmonton downtown',3);

INSERT INTO `diet` VALUES (1, 'no sugar');
INSERT INTO `diet` VALUES (2, 'no meat');
INSERT INTO `diet` VALUES (3, 'gluton free');

INSERT INTO `affiliation` VALUES (1, 'Liberal');
INSERT INTO `affiliation` VALUES (2, 'Conservative');

INSERT INTO `role` VALUES (1,'Admin','hold of the event and the owner of the company',0)
,(2,'Volunteer / Admin Desk','- Supports volunteers and is central point for emergency services (AM/PM)',1)
,(3,'Technician','check the bike',2)
,(4,'Food Volunteer – Calgary Only','- Manages volunteer food and drinks in the break area (AM/PM)',1)
,(5,'Safety / Security','- manages safe access to the venue and monitors for emergency situations (AM/PM)',1)
,(6,'Bike Receiver','- stationed at curb and is the first point of contact for bike Sellers and Donators (AM/PM)',1)
,(7,'Screener','- knows bikes and is able to identify bikes that will not pass the tech check (AM/PM)',1)
,(8,'Bike Tech','- follows the Swap checklist to ensure bikes are safe and not worn out (AM/PM)',1)
,(9,'Scribe','- touches nearly every bike at the swap by recording serial numbers, makes, models, colour (AM/PM)',1)
,(10,'Placer','- moves bikes from the staging racks to the sales racks and places them by type (AM/PM)',1)
,(11,'Dream Fulfillment (Sales)','- helps people find their perfect bike (PM)',3)
,(12,'Line Manager','- chats with happy people who found their perfect bike, directs people to the cash-only line. (PM)',3)
,(13,'Gatekeeper','- keeps the checkout line near the computers moving (PM)',3)
,(14,'Data Tracker','- loves to organize paper and understands efficiency and data completeness (AM/PM)',3)
,(15,'Rack Admin','- manages / collects rack fees and AMA data (AM 8 AM - 2PM)',4)
,(16,'Computer Op','- inputs seller data, processes sales data for receipts (AM/PM)',1)
,(17,'Transaction Support','- reviews paperwork with Seller & Buyers (AM/PM)',1)
,(18,'Floater','- Gets to do a little of everything (AM/PM)',1)
,(19,'NEW! Day of the event social media wiz',' - in Facebook, Twitter, and Instagram (must pass spelling tst)',1)
,(20,'Seller','Selling bikes',1)
,(21,'Buyer',' buying bikes',1);

INSERT INTO `faq` VALUES (1, '1st question','who is the owner','Laura',1,1,1);
INSERT INTO `faq` VALUES (2, '2nd question','where is the event','3 cities',1,1,2);
INSERT INTO `faq` VALUES (3, '3rd question','will it happen in 2022','not sure',1,1,3);

INSERT INTO `safety` VALUES (1, 'Fire safety','Important to take care of','www.safety.com',1,1,1);
INSERT INTO `safety` VALUES (2, 'Theft','Take care of your money','www.call311.com',1,1,2);
INSERT INTO `safety` VALUES (3, 'Extreme Weather Notice','Be healthy','www.weather.com',1,1,3);


INSERT INTO `event_date` VALUES (1,1,1,'2022-04-19','2022-04-20','8:00-17:00', '8:00-17:00',0),(2,2,2,'2022-04-19','2022-04-20','8:00-17:00', '8:00-17:00',0),(3,3,3,'2022-04-19','2022-04-20','8:00-17:00', '8:00-17:00',0);



INSERT INTO `user` (`email`,`name`,`password`,`role_id`,`cell_number`,`address_id`,`diet_id`,`shirt_size`,affiliation_id)
	VALUES ('cprg352.test.sait+admin@gmail.com','admin', '12345678', 1,'4036781234',1,1,1,1);
	
INSERT INTO `user` (`email`,`name`,`password`,`role_id`,`cell_number`,`address_id`,`diet_id`,`shirt_size`,affiliation_id,ticket)
	VALUES ('cprg352.test.sait+seller2@gmail.com','seller', '12345678', 6,'4036781234',1,1,1,1,1123456789);
	


INSERT INTO `user` (`email`,`name`,`password`,`role_id`,`cell_number`,`address_id`,`diet_id`,`shirt_size`,affiliation_id)
	VALUES ('cprg352.test.sait+buyer@gmail.com','buyer', '12345678', 7,'4036781234',1,1,1,1);

INSERT INTO `user` (`email`,`name`,`password`,`role_id`,`cell_number`,`address_id`,`diet_id`,`shirt_size`,affiliation_id)
	VALUES ('cprg352.test.sait+technician@gmail.com','technician', '12345678', 3,'4036781234',1,1,1,1);
	
INSERT INTO `user` (`email`,`name`,`password`,`role_id`,`cell_number`,`address_id`,`diet_id`,`shirt_size`,affiliation_id)
	VALUES ('cprg352.test.sait+foodprovider@gmail.com','food provider', '12345678', 5,'4036781234',1,1,1,1);





INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (1,1);
INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (2,1);
INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (3,1);


INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (1,2);
INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (1,3);
INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (1,4);


INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (2,3);
INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (2,4);
INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (2,5);

INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (3,2);
INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (3,3);
INSERT INTO `event_date_user` (`event_date_id`,`user_id`) VALUES (3,5);

INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('123456789A',2,500.5,1,0,'Calgary-22-1',true,'assets/img/bikes/bike001.jpg');
   
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456789',3,857.2,1,0,'Calgary-33-1',true,'assets/img/bikes/bike002.jpg');

INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456480',3,999.2,1,0,'Calgary-33-2',true,'assets/img/bikes/bike003.jpg');
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456309',2,380.2,1,0,'Calgary-33-3',true,'assets/img/bikes/bike004.jpg');
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456239',3,690.2,1,0,'Calgary-33-4',true,'assets/img/bikes/bike005.jpg');
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('1234567011',2,358.5,1,0,'Calgary-22-2',true,'assets/img/bikes/bike011.jpg');
   
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456012',3,357.2,1,0,'Calgary-33-5',true,'assets/img/bikes/bike012.jpg');

INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456006',3,1099.2,1,0,'Calgary-33-6',true,'assets/img/bikes/bike006.jpg');
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456007',2,880.2,1,0,'Calgary-33-7',true,'assets/img/bikes/bike007.jpg');
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456008',3,1290.2,1,0,'Calgary-33-8',true,'assets/img/bikes/bike008.jpg');
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123456009',2,2380.2,1,0,'Calgary-33-9',true,'assets/img/bikes/bike009.jpg');
INSERT INTO `bike` (`bike_index`,`user_id`,`price`,`toSell`,`donate`,`bike_event_tickets`,`checked`,`photo_path`) 
   VALUES('B123452010',3,690.2,1,0,'Calgary-33-10',true,'assets/img/bikes/bike010.jpg');
   
INSERT INTO `trade` VALUES(1,2,3,'2022-3-5',2);

INSERT INTO `trade_desc` VALUES(1,'Ticket-Seller',3);

INSERT INTO `trade_desc` VALUES(2,'Storage-Seller',5);

INSERT INTO `trade_desc` VALUES(3,'Ticket-Buyer',3);

INSERT INTO `trade_others` VALUES(1,1,2);

INSERT INTO `trade_others` VALUES(2,2,2);

INSERT INTO `trade_others` VALUES(3,3,3);

INSERT INTO `announcement` VALUES(1,'1st announcement','This is a test',null,null,DEFAULT);

INSERT INTO `announcement` VALUES(2,'2st announcement','This is for testing',null,null,DEFAULT);