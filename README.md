Java Spring RestAPI Application

Perform the following steps to run the project:
open this project in any IDE(IntelliJ/Eclipse).
Update the Hibernate.properties file.
Build the project.
Run project as Maven Project with a goal as maven clean install.
Run the tomcat server and run the project.

Run the following API calls on Postman to check the endpoints is working:

Create a Student Data: Post Request
http://localhost:8080/demo_war_exploded/student/create

{
   "studentName": "Mayur",
   "studentId": "ST_1"
}
Delete a Student Data: Delete Request

http://localhost:8080/demo_war_exploded/student/delete

{
   "studentName": "Mayur",
   "studentId": "ST_1"
}

Update student Data: Patch Request
http://localhost:8080/demo_war_exploded/student/update

{
   "studentName": "Mayur",
   "studentId": "ST_1"
}

Show all student data: Get Request
http://localhost:8080/demo_war_exploded/student/showAll

