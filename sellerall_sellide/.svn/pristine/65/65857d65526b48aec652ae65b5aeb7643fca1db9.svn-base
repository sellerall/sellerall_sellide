set sql_safe_updates=0;

insert into tb_user_info (user_id, user_pwd, user_name, user_email, crt_name, role, upt_name) 
values ('superuser','$2a$10$/Zm7nvfpmaKcOMnKeqnys.7YQrfeGT1Od9keyuduCLUgs33mJ9Kdi','superuser', 'younghun@fromtodaycorp.com', 'superuser', 'SUPER', 'superuser');

insert into tb_rank_info (role, auth_code, sort_ordr, use_yn, note,crt_name, upt_name) values 
('SUPER','00000011',1,'y','루트관리자','superuser','superuser'),
('ADMIN','00000001',2,'y','관리자','superuser','superuser'),
('USER','00110000',3,'y','일반유저(셀리드)','superuser','superuser'),
('GUEST','00000000',4,'y','손님','superuser','superuser'),
('SELLIDE','00111100',5,'y','셀리드,에이드 사용자','superuser','superuser'),
('AID','00001100',6,'y','에이드 사용자','superuser','superuser'),
('SCOUT','11000000',7,'y','스카우터 사용자','superuser','superuser');

INSERT INTO `tb_menu_mst` VALUES 
(1,1,'사용자관리','/sys/usermanage',1,'00000011','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:27:58'),
(2,1,'메뉴관리','/sys/menumanage',2,'00000011','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:08:46'),

(3,2,'B2B 수집','/aid/crawler',1,'00001111','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:28:07'),
(4,2,'B2B 상태','/aid/status',2,'00001111','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:28:07'),

(5,3,'상품관리','/sellide/productmanage',1,'00110011','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:28:07'),
(6,3,'주문관리','/sellide/ordermanage',2,'00110011','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:09:37'),
(7,3,'고객문의관리','/sellide/customerinquiry',3,'00110011','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:09:41'),
(8,3,'환경설정','/sellide/preferences',4,'00110011','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:09:46'),

(9,4,'준비중1','/scout/temp1',1,'11000011','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:09:50'),
(10,4,'준비중2','/scout/temp2',2,'11000011','Y',NULL,'superuser','2020-11-10 13:46:24','superuser','2020-12-13 22:10:03');

