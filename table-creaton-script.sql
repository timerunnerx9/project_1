CREATE TABLE ers_reimbursement_status(
reimb_status_id NUMERIC PRIMARY KEY NOT NULL,
reimb_status VARCHAR(10),
CHECK (reimb_status in ('PENDING', 'APPROVED','DENIED'))
)


CREATE TABLE ers_reimbursement_type(
reimb_type_id NUMERIC PRIMARY KEY NOT NULL,
reimb_type VARCHAR(10),
CHECK(reimb_type IN('LODGING','TRAVEL','FOOD','OTHER'))
)

CREATE TABLE ers_user_roles(
ers_user_role_id NUMERIC PRIMARY KEY NOT NULL,
user_role VARCHAR(10),
CHECK(user_role in('EMPLOYEE','FINANCE MANAGER')
)
)


CREATE TABLE ers_users(
ers_users_id NUMERIC PRIMARY KEY NOT NULL,
ers_username VARCHAR(50),
ers_password VARCHAR(50),
user_first_name VARCHAR(100),
user_last_name VARCHAR(100),
user_email VARCHAR(150),
user_role_id NUMERIC REFERENCES ers_user_roles(ers_user_role_id),
UNIQUE(ers_username, user_email)
)


CREATE TABLE ers_reimbursement(
reimb_id NUMERIC PRIMARY KEY NOT NULL,
reimb_amount NUMERIC,
reimb_submitted TIMESTAMP,
reimb_resolved TIMESTAMP,
reimb_description VARCHAR(250),
reimb_receipt BOOLEAN,
reimb_author NUMERIC REFERENCES ers_users(ers_users_id),
reimb_resolver NUMERIC REFERENCES ers_users(ers_users_id),
reimb_status_id NUMERIC REFERENCES ers_reimbursement_status(reimb_status_id),
reimb_type_id NUMERIC REFERENCES ers_reimbursement_type(reimb_type_id)
)