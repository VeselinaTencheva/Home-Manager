
INSERT INTO employee (name)
VALUES
('EmployeeTest'),
('EmployeeTest2');
INSERT INTO building (address,floors,apartments,area,shared_area,tax,employee)
VALUES
('testadres',50,25,500,250,5,1),
('testadres2222',50,25,500,250,5,2);
INSERT INTO month(name)
VALUES
('January'),
('February'),
('March'),
('April'),
('May'),
('June'),
('July'),
('August'),
('September'),
('October'),
('November'),
('December');
INSERT INTO person (name,building)
VALUES
('John',1),
('Peter',2),
('Sara',1),
('Jesica',2);
INSERT INTO payment (person,month,has_Person_Paid)
VALUES
(1,2,true),
(1,5,false),
(2,4,true),
(2,8,false);
INSERT INTO user (username,password,roles,permissions)
VALUES
('testUser','user123','PERSON','READ_PAYMENT'),
('testAdmin','admin123','ADMIN',''),
('testManager','manager123','MANAGER','READ_BUILDING');
