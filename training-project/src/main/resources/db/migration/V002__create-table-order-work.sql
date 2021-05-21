create table order_work (
	id bigint not null auto_increment,
	user_id bigint not null,
	description text not null,
	price decimal(10,2) not null,
	status varchar(20) not null,
	open_date datetime not null,
	end_date datetime,

	primary key (id)

);

alter table order_work add constraint fk_order_work_user
foreign key (user_id) references user (id);