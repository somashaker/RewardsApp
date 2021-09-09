DROP TABLE IF EXISTS rewardprogram;

CREATE TABLE rewardprogram (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(250) NOT NULL,
  reward_points int,
  amount_spent int NOT NULL,
  transaction_date date default CURRENT_DATE(),
  trn_month int
);

insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Madhu',90,120,parsedatetime('2021-06-01', 'yyyy-MM-dd'),06);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Madhu',100,150,parsedatetime('2021-05-20', 'yyyy-MM-dd'),05);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Madhu',200,200,parsedatetime('2021-05-20', 'yyyy-MM-dd'),05);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Madhu',250,300,parsedatetime('2021-04-20', 'yyyy-MM-dd'),04);

insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Malcolm',80,120,parsedatetime('2021-06-01', 'yyyy-MM-dd'),06);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Malcolm',100,150,parsedatetime('2021-05-20', 'yyyy-MM-dd'),05);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Malcolm',200,200,parsedatetime('2021-05-20', 'yyyy-MM-dd'),05);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Malcolm',250,300,parsedatetime('2021-04-20', 'yyyy-MM-dd'),04);

insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Adam',40,120,parsedatetime('2021-06-01', 'yyyy-MM-dd'),06);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Adam',50,140,parsedatetime('2021-05-20', 'yyyy-MM-dd'),05);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Adam',60,160,parsedatetime('2021-05-20', 'yyyy-MM-dd'),05);
insert into rewardprogram (customer_name,reward_points,amount_spent,transaction_date,trn_month)values('Adam',70,180,parsedatetime('2021-04-20', 'yyyy-MM-dd'),04);
