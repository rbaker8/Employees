insert into employee values ();
select @ceo := scope_identity();
insert into property (employee_id, key, value) values (@ceo, 'title', 'CEO');
insert into property (employee_id, key, value) values (@ceo, 'name', 'Richard Baker');
insert into property (employee_id, key, value) values (@ceo, 'phone', '503-267-6279');
insert into property (employee_id, key, value) values (@ceo, 'email', 'jobs@richabaker.com');
insert into property (employee_id, key, value) values (@ceo, 'website', 'richabaker.com');

insert into employee (supervisor_id) values (@ceo);
select @vpsales := scope_identity();
insert into property (employee_id, key, value) values (@vpsales, 'title', 'Vice President of Sales');
insert into property (employee_id, key, value) values (@vpsales, 'name', 'Joe Doe VP');

insert into employee(supervisor_id) values (@vpsales);
select @nasales := scope_identity();
insert into property (employee_id, key, value) values (@nasales, 'title', 'Regional Director of Sales');
insert into property (employee_id, key, value) values (@nasales, 'name', 'Jane Doe DR');
insert into property (employee_id, key, value) values (@nasales, 'region', 'North America');

insert into employee(supervisor_id) values (@nasales);
select @salesrep1 := scope_identity();
insert into property (employee_id, key, value) values (@salesrep1, 'title', 'Sales Representative');
insert into property (employee_id, key, value) values (@salesrep1, 'name', 'Jack Sales Rep');

insert into employee(supervisor_id) values (@vpsales);
select @eusales := scope_identity();
insert into property (employee_id, key, value) values (@eusales, 'title', 'Regional Director of Sales');
insert into property (employee_id, key, value) values (@eusales, 'region', 'Europe');

insert into employee (supervisor_id) values (@ceo);
select @vpp := scope_identity();
insert into property (employee_id, key, value) values (@vpp, 'title', 'Vice President of People');

insert into employee (supervisor_id) values (@ceo);
select @vpm := scope_identity();
insert into property (employee_id, key, value) values (@vpm, 'title', 'Vice President of Marketing');

insert into employee(supervisor_id) values (@vpm);
select @namarketing := scope_identity();
insert into property (employee_id, key, value) values (@namarketing, 'title', 'Regional Director of Marketing');
insert into property (employee_id, key, value) values (@namarketing, 'region', 'North America');

insert into employee(supervisor_id) values (@vpm);
select @eumarketing := scope_identity();
insert into property (employee_id, key, value) values (@eumarketing, 'title', 'Regional Director of Marketing');
insert into property (employee_id, key, value) values (@eumarketing, 'region', 'Europe');