create table idxdb_Entity (
	entityId LONG not null primary key,
	packagePath VARCHAR(75) null,
	entityName VARCHAR(300) null
);