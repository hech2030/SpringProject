#  SpringProject

Important : 
Change you connection string in src/java/resources/application.propreties
At least, userName and password must be changed!!


Create database called MyApp


then execute this query:

create table AEM_AdEntityModel(
	Id bigint identity(1,1) primary key,
	Title varchar(150),
	CreateDate Datetime,
	ObjectLocation varchar(max),
	IsDeleted bit,
	Details varchar(max),
	Price decimal(18,10),
	TargetNumber varchar(max)
)

insert into AEM_AdEntityModel values ('test titre','2021-03-18','object loc',0,'details','20.01','53033545');

Ads table is created, you can check the values when running the server then call http://localhost:8080/api/v1/MainApp/home/ on you browser.
