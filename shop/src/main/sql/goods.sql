CREATE TABLE `goods` (
  `goodsNo` int NOT NULL AUTO_INCREMENT,
  `goodsImage` mediumblob NOT NULL,
  `goodsNm` varchar(30) NOT NULL,
  `goodsPrice` int NOT NULL,
  `goodsCategory` enum('닭가슴살','샐러드','소세지/핫바','쉐이크') NOT NULL DEFAULT '닭가슴살',
  `goodsExplain` text NOT NULL,
  PRIMARY KEY (`goodsNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci