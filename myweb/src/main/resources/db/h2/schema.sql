DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL IDENTITY,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `itemguolv`;
CREATE TABLE `itemguolv` (
  `ObjName` varchar(50) DEFAULT NULL,
  `bSell` tinyint(1) DEFAULT NULL,
  `bStore` tinyint(1) DEFAULT NULL,
  `bDrop` tinyint(1) DEFAULT NULL,
  `iQiangHuaCishu` int DEFAULT NULL,
  `iMaSu` int DEFAULT NULL,
  `iFangyu` int DEFAULT NULL,
  `iGongji` int DEFAULT NULL,
  `iShenshangliuliang` int DEFAULT NULL,
  `iWujiangji` int DEFAULT NULL,
  `iLev` int DEFAULT NULL,
  `bLev_gt` tinyint(1) DEFAULT NULL
);
