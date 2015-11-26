SELECT * 
FROM book
FOR XML RAW
------------------------------------------
SELECT book.*
FROM book AS book
WHERE book.bid='b1'
FOR XML AUTO
------------------------------------------
SELECT book.*
FROM book AS book
WHERE book.bid='b1'
FOR XML AUTO, ELEMENTS
------------------------------------------
SELECT 	1		AS Tag,
	NULL		AS Parent,
	NULL		AS [booklist!1],
	NULL		AS [book!2]
UNION ALL
SELECT 	2,
	1,
	NULL,
	title
FROM book
FOR XML EXPLICIT
------------------------------------------
SELECT 	1		AS Tag,
	NULL		AS Parent,
	NULL		AS [booklist!1],
	NULL		AS [book!2!bid],
	NULL		AS [book!2!kind],
	NULL		AS [book!2]
UNION ALL
SELECT 	2,
	1,
	NULL,
	bid,
	kind,
	title
FROM book
FOR XML EXPLICIT
------------------------------------------
SELECT 	1		AS Tag,
	NULL		AS Parent,
	NULL		AS [booklist!1],
	NULL		AS [book!2!bid],
	NULL		AS [book!2!kind],
	NULL		AS [book!2!title!element],
	NULL		AS [book!2!publisher!element],
	NULL		AS [book!2!price!element]
UNION ALL
SELECT 	2, 1, NULL, bid, kind, title, publisher, price
FROM book
WHERE bid='b1'
FOR XML EXPLICIT
-------------------------------------------
