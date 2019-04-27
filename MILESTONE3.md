# Milestone 3

### TOPIC: GitHub Notification Bot 

### Use Cases

#### USE CASE: Synchronising GitHub with bot
1. Preconditions<br>
User must have the extension installed.<br>
2. Main Flow<br>
User will provide correct credential (personal access token) to access the content of GitHub. [S1]<br>
3. Sub Flow<br>
[S1] Correct crendentails of the user account will allow the user to view notifications.<br>
4. Alternative Flow<br>
[E1] User will not be able to view the notifications<br>

###### Implementation Description ###### 
Bot calls the [List Notifications API](https://developer.github.com/v3/activity/notifications/#list-your-notifications) to check the response code using the entered personal access token as authorization header. If it recieves a 200 response code from the API, it accepts the token, stores it in the local storage and directs to the list notifications popup, else it displays an error message. If the an token is present in the local storage, the bot has a background process that periodically calls the [List Notifications API](https://developer.github.com/v3/activity/notifications/#list-your-notifications) to list the unread notifications.
###### API specifications ######
1. URL: */notifications*<br>
2. HTTP Method: *GET*<br>
3. Request Headers: *Authorization: token {your-personal-access-token}*<br>
4. Response Status Code: *200 OK* <br>

#### USE CASE: Enable or Disable notifications
1. Preconditions<br>
User must have Notification bot extension enabled in the Google Chrome web browser.<br>
User must have signed in to the GitHub account through this extension<br>
2. Main Flow<br>
Flow 1: User will enable the GitHub notifications [S1]. Bot will start popping up the GitHub notifications to the user [S2]<br>
Flow 2: User will disable the GitHub notifications [S3]. Bot will stop showing the GitHub notifications to the user [S4]<br>
3. Sub Flows<br>
[S1] User will check option to enable GitHub notifications<br>
[S2] Bot will stop calling the GitHub notification API<br>
[S3] User will uncheck option to enable GitHub notifications<br>
[S4] Bot will start calling the GitHub notification API to fetch details<br>
4. Alternative Flows<br>
[E1] User will not check or uncheck any option. By default, GitHub notifications will be enabled<br>
###### Implementation Description ###### 
Local storage has a boolean variable for the Enable notifications checkbox in the list notifications popup. The value of the variable is synchronized with the state of the checkbox. If the checkbox is disabled then the bot clears the list of notifications form the popup and sets it's corresponding value to false. The background task checks the value of the variable to decide if list notifications API has to be called or not. The notifications can be re enabled by simply enabling the checkbox again.
<br>

#### USE CASE: Viewing the content of the notification
1. Preconditions<br>
User must have the chrome extension installed.<br>
User must have setup the Personal identification token in the Chrome extension.<br>
2. Main Flow<br>
User will click on the chrome extension icon to see the unread notifications[S1] and will click on desired notification[S2] to navigate[S2] to their corresponding GitHub account[S3].<br>
3. Sub Flows<br>
[S1] Bot would open a drop-down menu with unread notifications in it.<br>
[S2] The bot would provide notifications that are hyperlinked to the corresponding change (commit in the repositories, branch, issues etc) in the GitHub account.<br>
[S3] The bot would open a relevant section in the GitHub account.<br>
4. Alternative Flows<br>
[E1] No unread notification is there in the system.<br>
###### Implementation Description ###### 
The response of the [List Notifications API](https://developer.github.com/v3/activity/notifications/#list-your-notifications) contains the correpsponsding URL for the notification. This url is used as a hyperlink for the notification text in the listivew of the popup. Once the hyperlink is clicked it opens the notification URL in a new tab.
<br>

#### USE CASE: Mark all notifications as read
1. Preconditions<br>
User must have the chrome extension installed.<br>
User must have setup the Personal identification token in the Chrome extension.<br>
2. Main Flow<br>
The bot will clear the current notifications from the popup[S1] and update the status of the present notifications in the view as Read[S2]<br>
3. Sub Flows<br>
[S1] Bot will remove all the list items in the list notifications UI<br>
[S2] Bot will send a PUT request to github to update the status of the notifications as read<br>

###### API specifications ######
1. URL: */notifications*<br>
2. HTTP Method: *PUT*<br>
3. Request Headers: *Authorization: token {your-personal-access-token}*<br>
4. Response Status Code: *202 Accepted* <br>
###### Implementation Description ###### 
Clicking the Mark All as Read button will trigger a PUT request to GitHub [Mark as Read API](https://developer.github.com/v3/activity/notifications/#mark-as-read) in order to update the status of the notifications and will clear all list items from the current list notifications view.
<br>

## Unit Testing
Unit Testing is a level of software testing where individual units/ components of a software are tested. The purpose is to validate that each unit of the software performs as designed. A unit is the smallest testable part of any software. It usually has one or a few inputs and usually a single output. In procedural programming, a unit may be an individual program, function, procedure, etc. In object-oriented programming, the smallest unit is a method.  <br>
In this project unit testing is carried out using Mocha, a JavaScript Test Framework. It runs on Node.js. During the testing assert statement is provided using a separate library called Chai. There are three key elements while carrying out unit testing using **Mocha and Chai** <br>
* **assert** helps to determine the status of the test, it determines the success or failure of the test.
* **describe** is a function which holds the collection of tests. It takes two parameters, first one is the meaningful name to functionality under test and second one is the function which contains one or multiple tests.
* **it** is a function again which is actually a test itself and takes two parameters, first parameter is name to the test and second parameter is function which holds the body of the test. <br>

For the setup of mocha on a system, the development dependencies must be added to the **package.json** file. This will be carried out using the command *sudo npm install chai --save-dev mocha*. In the same file the value of test must be changed to **"mocha"**. This will set up the environment for mocha.



## Selenium Implementation 

#### Dealing with Chrome extension:

Selenium is a great way to automate browser testing but the browser extensions are embedded add-ons rather than regular HTML files. As a result we can’t directly simulate user clicks, inspect elements, or run other such activities for chrome extensions.

We used Selenium on a browser extension by first finding out the location of extension’s pages and then switching their scope to webUI. Consequently, we were able to interact with browser extension as DOM elements.

For selenium testing, we had our extension in .crx format. First, we extracted the unique ID of the .crx Chrome Extension. Then, we extracted the names of different source files of .crx extension. There are various web resources from where we can view the source files of .crx extension. After knowing the source files and unique ID of the extension, we had the resources to navigate to the appropriate pages in the chrome extension. 

URL for accessing a  specific page in the extension would look like: 
chrome-extension://UNIQUEID/SPECIFICPAGE.html.


#### Working:

We created a maven repository. In its pom.xml file we added appropriate dependencies. The dependencies added are Selenium-API, Selenium-Driver, TestNG, selenium-chrome-driver and selenium-java. Then, we used Selenium WebDrive to open the instance of chrome. Consequently, chrome browser was launched and it navigated to chrome extension's webpage.

Detailed architecture of Web driver interacting with selenium script and interaction of Web driver and actual browse:
<p align = "center">
 <img align="center" width = "550" src = "https://media.github.ncsu.edu/user/11941/files/252d6d00-41b9-11e9-90d6-d166af9a5cae"> 
</p>

#### Implementing implicit wait and explicit wait

This time, our github bot would call the github notification API after every fixed intervals. So, we also implemented impicit and explicit wait in combination with previosuly implemented Thread.sleep() to make the testing process more robust and reliable.

The implicit wait will tell to the web driver to wait for certain amount of fixed time before it throws a "No Such Element Exception". The default setting is 0. Once we set the time, web driver will wait for that time before throwing an exception.

The explicit wait is used to tell the Web Driver to wait for certain conditions (Expected Conditions) or the maximum time exceeded before throwing an "ElementNotVisibleException" exception. The explicit wait is an intelligent kind of wait, but it can be applied only for specified elements.

Idealy it is preferred to use explicit wait over implicit wait and implicit wait over Thread.sleep() to make the testing more reliable. But we have used the combination of all three in our implementation.

#### TestNG plugin:

We added TestNG plugin to the eclipse since we can’t run selenium script as normal java program. ’Public static void main (psvm)’ is the entry point of any java program. But selenium script doesn’t have psvm and has to be run as TestNG suite.

#### TestNG class:

Configuration information for a TestNG class: 

@BeforeSuite: The annotated method will be run before all tests in this suite have run. <br>
@AfterSuite: The annotated method will be run after all tests in this suite have run.<br> 
@BeforeTest: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run. <br>
@AfterTest: The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run. <br>
@BeforeGroups: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.<br> 
@AfterGroups: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked. <br>
@BeforeClass: The annotated method will be run before the first test method in the current class is invoked. <br>
@AfterClass: The annotated method will be run after all the test methods in the current class have been run. <br>
@BeforeMethod: The annotated method will be run before each test method. <br>
@AfterMethod: The annotated method will be run after each test method.<br>

In our project, we created three @Test annotations with each test method (Test_Case1, Test_case2, Test_case3) covering one use-case. We also created @BeforeMethod which is invoked before every @test Method and launches the chrome browser each time and a use case is covered. <br>


## Task Tracking <br>
[WORKSHEET.md](https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/WORKSHEET.md)
The “WORKSHEET.md“ consists of all the tasks carried out throughout the project. Our team had decided to complete the implementation which consisted of GitHub API interaction of every use case in three sprints. <br>
The first sprint covered synchronising the GitHub with our bot. The user would be given access to the notifications from their repository after entering a valid personal access token. The unit tests and selenium tests have been completed for this use case.<br>
The second sprint covered viewing the notification content after correct credentials (personal access token) has been added. This stage consists of two more sections which were covered in the last sprint. Unit and Selenium testing is covered for this sprint.<br>
The third sprint covered the use case where a user can remove all the notification content after he/ she has read them. This is through the “Mark All Read” checkbox on the bot. This section also contained options for enabling and disabling notifications. This sprint also consisted of creating a screencast and writing a report.<br>


## Screencast <br>
Screencase can be viewed [here](https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/MileStone3.mp4).
