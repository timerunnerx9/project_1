select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_resolved, r.reimb_description, r.reimb_receipt,r.reimb_description, r.reimb_receipt, 
a.user_first_name as au, u.user_first_name as uu, s.reimb_status,t.reimb_type 
from ers_reimbursement r
left join ers_users a on 
(a.ers_user_id = r.reimb_author)
left join ers_users u on
(u.ers_user_id = r.reimb_resolver)
left join ers_reimbursement_status s on
(s.reimb_status_id = r.reimb_status_id )
join ers_reimbursement_type t on
(t.reimb_type_id = r.reimb_type_id)
