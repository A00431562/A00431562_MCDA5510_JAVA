use transactions;

create table if not exists transaction (							
ID int(11) not null,
NameOnCard varchar(256),
CardNumber varchar(16),
UnitPrice decimal(10,0),
Quantity int(11),
TotalPrice decimal(10,0),
ExpDate varchar(16),
CreatedOn datetime,
CreatedBy varchar(45),
primary key (ID)
) engine=innodb;

select * from transaction;


ALTER TABLE transaction
ADD COLUMN CreditType varchar(18) AFTER CreatedBy;


