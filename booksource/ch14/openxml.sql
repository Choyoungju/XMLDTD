CREATE PROCEDURE insertBook @doc VARCHAR(2000)
AS
DECLARE @idoc int
EXEC sp_xml_preparedocument @idoc OUTPUT, @doc
INSERT INTO book(bid, kind, title, publisher, price)
SELECT * FROM OPENXML(@idoc, 'booklist/book', 3) WITH book
EXEC sp_xml_removedocument @idoc

