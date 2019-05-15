# retailapp
spring boot app of bill discount for retail user

PreRequiste
Latest Gradle and Jdk must be in the system path

Steps to run locally:
1. Unzip the folder and go to the root of project
2. Run gradlew clean build

It will Generate a jar file name RetailApplication in build/lib folder

3. Run following command to run java -jar RetailApplication.jar
4. application can be accessed through http://localhost:8080
5. APi to calculate discount is http://localhost:8080/getDiscountedBill
6. Request format is as below:

Format: 
{
"customerType":<EMPLOYEE | AFFILIATE | USER | OTHERS >,
	"shoppedItemList": [{"itemType":< GROCERY | OTHERS >,	"itemPrice":<Non Negative Double Value>}]	
}

Example:
{
"customerType":"EMPLOYEE",
	"shoppedItemList": [{"itemType":"GROCERY",	"itemPrice":"10"},
			{"itemType":"GROCERY", "itemPrice":"10.0"},
			{"itemType":"OTHERS", "itemPrice":"200.5"}
			]	
}
