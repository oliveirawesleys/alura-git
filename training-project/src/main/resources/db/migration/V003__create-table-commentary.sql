create table commentary (
	id bigint not null auto_increment,
    order_work_id bigint not null,
    description text not null,
    date_send datetime not null,

    primary key (id)
);

alter table commentary add constraint fk_commentary_order_work
foreign key (order_work_id) references order_work (id);