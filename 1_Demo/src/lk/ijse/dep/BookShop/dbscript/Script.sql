





//////////////////////////////////////////////////////
CREATE database `BOOKSHOP`;
use BOOKSHOP;


CREATE TABLE Customer(
  cId VARCHAR(10) not null,
  cName VARCHAR(30),
  cTele VARCHAR(15),

  CONSTRAINT PRIMARY KEY(cId)
);

CREATE TABLE Author(
  aId VARCHAR(10) not null,
  aName VARCHAR(30),
  aEmail VARCHAR(30),
  CONSTRAINT PRIMARY KEY(aId)
);

CREATE TABLE Publisher(
  pId VARCHAR(10) not null,
  pName VARCHAR(30),
  pEmail VARCHAR(30),
  CONSTRAINT PRIMARY KEY(pId)


);



CREATE TABLE Book(
  bId VARCHAR(10) not NULL ,
  bName VARCHAR(30),
  bAmount DECIMAL(10,2),
  bQtyOnHand INT(10),
  aId VARCHAR(10)not null ,
  pId VARCHAR(10) not null,

  CONSTRAINT PRIMARY KEY(bId),
  CONSTRAINT FOREIGN KEY(aId) REFERENCES Author(aId)  ON Delete Cascade On update cascade,
  CONSTRAINT FOREIGN KEY(pId) REFERENCES Publisher(pId)  ON Delete Cascade On update cascade
);

CREATE TABLE OrderBook(
  oId VARCHAR(10) NOT NULL,
  oDate DATE,
  customerId VARCHAR(10) NOT NULL,
  CONSTRAINT PRIMARY KEY (oId),

  CONSTRAINT FOREIGN KEY(customerId) REFERENCES Customer(cId) ON Delete Cascade On update cascade
);

CREATE TABLE Payment(
  id VARCHAR(10) NOT NULL,

  price decimal(10,2),
  oId VARCHAR(10) NOT NULL,

  CONSTRAINT PRIMARY KEY (id),

  CONSTRAINT FOREIGN KEY(oId) REFERENCES OrderBook(oId) ON Delete Cascade On update cascade
);

CREATE TABLE OrderDetail(
  orderId VARCHAR(10) NOT NULL,
  bId VARCHAR(10) NOT NULL,
  qty INT(10),
  unitPrice DECIMAL(10,2),
  CONSTRAINT PRIMARY KEY (orderId,bId),
  CONSTRAINT FOREIGN KEY (orderId) REFERENCES OrderBook(oId)  ON Delete Cascade On update cascade,
  CONSTRAINT FOREIGN KEY (bId) REFERENCES Book(bId)  ON Delete Cascade On update cascade
);






