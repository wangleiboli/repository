DROP TABLE IF EXISTS `itemguolv`;
CREATE TABLE `itemguolv` (
  `ObjName` varchar(20) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
