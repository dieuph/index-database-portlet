create table IDXDB_Entity (
	entityId LONG not null primary key,
	classNameId LONG,
	packagePath VARCHAR(75) null,
	entityName VARCHAR(300) null
);