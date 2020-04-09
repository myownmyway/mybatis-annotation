create database annotation;##创建数据库
use annotation;##切换数据库为annotation
select database();##查看当前数据是否为annotation
show tables;##查看当前数据库annotation都有哪些表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`         int auto_increment primary key,
    `username`   varchar(50),
    `password`   varchar(50),
    `mobile_num` varchar(15)
);
desc user;##查看表结构
INSERT INTO `user`
VALUES ('1', 'admin001', '123456', '13507660631');
INSERT INTO `user`
VALUES ('2', 'admin002', '123456', '13507660632');
INSERT INTO `user`
VALUES ('3', 'admin003', '123456', '13507660633');
INSERT INTO `user`
VALUES ('4', 'admin004', '123456', '13507660634');
INSERT INTO `user`
VALUES ('5', 'admin005', '123456', '13507660635');
INSERT INTO `user`
VALUES ('6', 'admin006', '123456', '13507660636');
INSERT INTO `user`
VALUES ('7', 'admin007', '123456', '13507660637');
INSERT INTO `user`
VALUES ('8', 'admin008', '123456', '13507660638');
INSERT INTO `user`
VALUES ('9', 'admin010', '123456', '13507660639');
INSERT INTO `user`
VALUES ('10', 'admin010', '123456', '13607660631');
INSERT INTO `user`
VALUES ('11', 'admin011', '123456', '13607660632');
INSERT INTO `user`
VALUES ('12', 'admin012', '123456', '13607660633');
INSERT INTO `user`
VALUES ('13', 'admin013', '123456', '13607660634');
INSERT INTO `user`
VALUES ('14', 'admin014', '123456', '13607660635');
INSERT INTO `user`
VALUES ('15', 'admin', '123456', '13507660636');
show index from user;##当前表都有哪些索引
explain select * from user ;##查看当前sql的执行计划