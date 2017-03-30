CREATE TABLE "org_user" (
  "id" varchar(36) NOT NULL,
  "audit_flag" varchar(2) DEFAULT NULL,
  "create_date"  timestamp DEFAULT NULL,
  "delete_flag" varchar(1) DEFAULT NULL,
  "update_date" timestamp DEFAULT NULL,
  "email" varchar(30) DEFAULT NULL,
  "mobile" varchar(20) DEFAULT NULL,
  "password" varchar(32) DEFAULT NULL,
  "real_name" varchar(50) DEFAULT NULL,
  "status" numeric(10) DEFAULT NULL,
  "username" varchar(50) DEFAULT NULL,
  "type" numeric(10) DEFAULT '0',
  "current_skin" varchar(16) DEFAULT NULL,
  PRIMARY KEY ("id")
) ;


INSERT INTO org_user (id,audit_flag,create_date,delete_flag,update_date,email,mobile,password,real_name,status,username,type,current_skin) VALUES ('1', null, '2016-08-17 15:17:02', '0', '2017-03-28 17:55:54', null, '13800138000', 'E10ADC3949BA59ABBE56E057F20F883E', '超级管理员', '1', 'admin', '0', 'skin_blue');
INSERT INTO org_role (id,audit_flag,create_date,delete_flag,update_date,code,description,name,no,role_name,status) VALUES ('402881e457f075530157f0791e2f0000', null, '2016-10-23 15:37:31', '0', '2017-03-28 16:37:35', null, '拥有所有的权限', '超级管理员', null, null, null);

INSERT INTO org_resource (id,audit_flag,create_date,delete_flag,update_date,icon,name,order_no,type,url,parent_id) VALUES ('10', null, '2016-08-17 17:06:19', '0', '2016-10-28 17:02:57', '', '权限管理', '10', 'module', '/user/list', null);
INSERT INTO org_resource  (id,audit_flag,create_date,delete_flag,update_date,icon,name,order_no,type,url,parent_id)VALUES ('11', null, '2016-09-07 15:15:58', '0', '2016-10-28 17:03:06', '', '用户列表', '11', 'page', '/user/list', '10');
INSERT INTO org_resource  (id,audit_flag,create_date,delete_flag,update_date,icon,name,order_no,type,url,parent_id) VALUES ('12', null, '2016-09-07 15:17:37', '0', '2016-10-28 17:03:13', '', '角色列表', '12', 'page', '/user/role_list', '10');
INSERT INTO org_resource  (id,audit_flag,create_date,delete_flag,update_date,icon,name,order_no,type,url,parent_id) VALUES ('13', null, '2016-09-18 16:34:14', '0', '2016-10-28 17:03:19', '', '菜单列表', '13', 'page', '/user/menu_list', '10');
INSERT INTO org_resource  (id,audit_flag,create_date,delete_flag,update_date,icon,name,order_no,type,url,parent_id) VALUES ('2c9025ab5b140c22015b140fbbd30000', null, '2017-03-28 16:37:07', '0', '2017-03-28 16:37:07', '', '换肤管理', '20', 'module', '/user/skin/list', null);
INSERT INTO org_resource  (id,audit_flag,create_date,delete_flag,update_date,icon,name,order_no,type,url,parent_id) VALUES ('90', null, '2017-03-17 15:32:19', '0', '2017-03-17 15:32:19', '', '修改密码', '90', 'module', '/user/update_pwd', null);



INSERT INTO org_user_role_rel  (user_id,role_id) VALUES ('1', '402881e457f075530157f0791e2f0000');


INSERT INTO org_role_resource_rel  (role_id,resources_id) VALUES ('402881e457f075530157f0791e2f0000', '10');
INSERT INTO org_role_resource_rel (role_id,resources_id)  VALUES ('402881e457f075530157f0791e2f0000', '11');
INSERT INTO org_role_resource_rel (role_id,resources_id)  VALUES ('402881e457f075530157f0791e2f0000', '12');
INSERT INTO org_role_resource_rel (role_id,resources_id)  VALUES ('402881e457f075530157f0791e2f0000', '13');
INSERT INTO org_role_resource_rel (role_id,resources_id)  VALUES ('402881e457f075530157f0791e2f0000', '2c9025ab5b140c22015b140fbbd30000');
INSERT INTO org_role_resource_rel (role_id,resources_id)  VALUES ('402881e457f075530157f0791e2f0000', '90');