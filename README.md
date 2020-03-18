# Online-Store

Steps to run Online-Store APP:

	1. Go to https://github.com/sudhirlthr/Online-Store.git
	2. Clone or download the project
	
	2.a. In case of download : (Please install lombok if not installed) Extract the downloaded zip.
		a. Open Eclipse (STS) and click File option in top left corner, click import.
		b. Choose "Maven" -> existing Maven Project
		c. Click finish.
		d. Just to be sure right click on Project and on Maven click update project.
		e. Go to step 3.


	2.b In case of Clone:
		a. Open Eclipse (STS) and click File option in top left corner, click import.
		b. Choose GIT -> Projects from GIT -> Next button-> Clone URI-> Give "https://github.com/sudhirlthr/Online-Store.git" into URI field -> Click Next(You will see master check option) -> Next button->  Next button -> Choose Import as General project-> Finish.
		c. Give git Url: https://github.com/sudhirlthr/Online-Store.git and then click next untill you click finish button.
		b. Clean and Build.

	3. 
		a. Open console or cmd go to project location (cd Online-Store/src/main/js/).
		f. type "sudo npm install --save bootstrap" and press enter to install bootstrap locally and finally run command "npm start".
		h. start Boot project from IDE by clean and build.
		i. You can see App localhost:4200/


	4. go to "localhost:8080/register" to register as a user. Give a First and last name and email(should be valid where you will get link to set your password).
	5. Check your mail and open it to browser and set password.
	6. Go to  "localhost:8080/greeting" and it will take you to Login page where you have to give your email as username and password.
	7. After login go to localhost:4200/ (in case if you didnt open else refresh it), here you can see some of items for sale and you can purchase and will get discount as per customer type (which you gave during registration).
