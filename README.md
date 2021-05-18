# Mobile_Programming


## Task
Laboratory work task:

Cover at least 3 Business Logic Modules with Unit Tests. Use only build in platform frameworks for tests. For iOS it is XCTest, for Android it is JUnit.
Unit tests are tests which check if some specific class behaves in the right way. Please don't test UI or Network Requests with unit tests.
Don't use concrete implementation of classes which are injected to your tested module, Use mocks and stubs in order to fake behavior of injected modules. Unit tests should be written and run isolated, this means that you must not to have Network Requests in your Unit Tests, Mock your API service and inject it inside your business logic module at start of test if you need it inside tested module.

Select and add at least one test of next categories:

1. Integration tests - Tests which check integration of several modules of your app or platform. In context of mobile app these can be tests where you perform network requests to real or mocked API and check app API layer behavior, these test can include testing of serialization and deserialization, check of requests components, check of returned API response.

2. UI tests (a.k.a Automation Tests) - Tests which perform real user action of interaction with UI elements in automated way. Actually it is a code which press buttons and interact with your app

 3. Snapshot tests - Tests which perform screenshot of your app and compare it with previously recorded reference image. These tests check if you don't break your UI accidentally during development. For this type of test you will need some third party frameworks, just google it, there are a lot of examples on github.  

## Implementation

Added unit tests for the next modules:
* authentication
* feed
* feedImage

All tests pass besides 2 unit tests. The error appeares because verify function gives an error because the parameter of updateUI is different from the object it expects. Even though all the fields are the same, it sees them as different objects and fails. Needs inpection.
[Something similar found here](https://stackoverflow.com/questions/25213897/test-failure-message-in-mockito-arguments-are-different-wanted/25214246)

Added an UI test ```test_validateEditText()```, to check when writing text into the username editText. Executed it on the phone.

## Demo
![Alt Text](https://github.com/dgaponcic/Mobile_Programming/blob/lab3/demo.gif)
