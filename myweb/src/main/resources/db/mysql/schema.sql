DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `itemguolv`;
CREATE TABLE `itemguolv` (
  `ObjName` varchar(50) NOT NULL DEFAULT '',
  `bSell` boolean NOT NULL DEFAULT FALSE,
  `bStore` boolean NOT NULL DEFAULT FALSE,
  `bDrop` boolean NOT NULL DEFAULT FALSE,
  `iQiangHuaCishu` int NOT NULL DEFAULT 0,
  `iMaSu` int NOT NULL DEFAULT 0,
  `iFangyu` int NOT NULL DEFAULT 0,
  `iGongji` int NOT NULL DEFAULT 0,
  `iShenshangliuliang` int NOT NULL DEFAULT 0,
  `iWujiangji` int NOT NULL DEFAULT 0,
  `iLev` int NOT NULL DEFAULT 0,
  `bLev_gt` boolean NOT NULL DEFAULT FALSE,
  `type` varchar(50) NOT NULL DEFAULT '',
  `subType` varchar(50) NOT NULL DEFAULT '',
  `index` int NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
