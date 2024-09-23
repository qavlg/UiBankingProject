# UI automation test-cases for the [Banking Project](https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager)

## Manual test-cases are stored [HERE](https://docs.google.com/spreadsheets/d/1D0IhwiGLyyPUL3xowYquBLgv8S3pcT0B-IFh-nxYS-s/edit?usp=sharing)

## The video about how I ran Jenkins [Click here](https://drive.google.com/file/d/1vsWLgO_gSrBcbINdHtLgFLYJLZUs3Dyy/view?usp=sharing)

### *These test-cases checks:*

1.The customer will be added successfully.

2.The customers will be sorted correctly.

3.The customer with the arithmetic mean name will be deleted.

**The project uses 21 Java version.**

*In order to run the ALL tests is necessary input a command into the
terminal(**in this project are implemented parallel test execution**):*

- **./mvnw clean test**  OR **mvn clean test**

*In order to run one of the test's class(such tests as the AddCustomerTest or the CustomerTest) is necessary input a
command into the terminal:*

- **./mvnw clean test -Dtest=<Input the name of the test's class>**

  For instance: **./mvnw clean test -Dtest=CustomerTest**

*In order to run Allure is necessary input a command into the terminal:*

- **./mvnw allure:serve** OR **mvn allure:serve**