# java-exam
To run the application:
1. Pull the changes to your local editor for java.
2. run mvn clean install
3. Then right click on the JavaCodingExamApplication to run the application.
4. Go to http://localhost:8080/api/v1/account, to create an account.
5. http://localhost:8080/api/v1/account/{customerNumber} to get the created account
6. Sample Payload for POST:
{
    "customerName": "Test",
    "customerMobile": "12345523423",
    "customerEmail": "test@email.com",
    "address1": "testadress1fffdfadsfa",
    "address2": "testadress2",
    "accountType": "Y"
}
