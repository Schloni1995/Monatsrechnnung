use monatsrechnung;
drop table ausgaben;
CREATE TABLE `ausgaben` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(50) DEFAULT NULL,
  `preis` float DEFAULT '0',
  `datum` date DEFAULT NULL,
  `bemerkung` varchar(100) DEFAULT NULL,
  `jasmin` float DEFAULT '0',
  `toni` float DEFAULT '0',
  `frequenz` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idnew_table_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

delete from ausgaben;
insert into ausgaben(position,preis,datum,bemerkung,jasmin,toni,frequenz) 
values('Kaltmiete',260.0,null,'',130.0,130.0,1);
insert into ausgaben(position,preis,datum,bemerkung,jasmin,toni,frequenz) 
values('Nebenkosten',130.0,null,'',65.0,65.0,2);

use monatsrechnung;
SELECT 
    *
FROM
    ausgaben AS a
        LEFT JOIN
    frequency AS f ON a.frequenz = f.id