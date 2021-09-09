# RewardsApp
This app is used to calculate rewards based on amount spent.

below are the sample endpoints which can be used to test .

http://localhost:9097/calculaterewards?cname=madhu&dollars=120
logic used to calculate rewards is
	2 points for each dollar spent above 100
	1 point for each dollar spent above 50

http://localhost:9097/getrewards?startMonth=APR&endMonth=JUN
 this will return all customers with individual months points and total points

to validate data we can login to H2 console(in-memory database)

http://localhost:9097/h2-console/login.jsp?jsessionid=9a149546eeeb5f1cbada3444cd9b17ac
uname=sa
password= password