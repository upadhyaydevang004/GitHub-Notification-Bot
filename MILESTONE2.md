
# Milestone 2

### TOPIC: GitHub Notification Bot 

### Use Cases

###### USE CASE: Synchronising GitHub with bot
1. Preconditions<br>
User must have the extension installed.<br>
2. Main Flow<br>
User will provide correct credential (personal access token) to access the content of GitHub. [S1]<br>
3. Sub Flow<br>
[S1] Correct crendentails of the user account will allow the user to view notifications.<br>
4. Alternative Flow<br>
[E1] User will not be able to view the notifications<br>

###### USE CASE: Enable or Disable notifications
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

###### USE CASE: Viewing the content of the notification
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

###### USE CASE: Listing unread notifications
1. Preconditions<br>
User must have the chrome extension installed.<br>
User must have setup the Personal identification token in the Chrome extension.<br>
2. Main Flow<br>
The bot will fetch the unread notifications[S1] for an account from GitHub and populate the drop-down view[S2] with a list of those unread notifications.<br>
3. Sub Flows<br>
[S1] Bot will call the notifications API every 30 seconds and fetch the list of notifications.<br>
[S2] Using the returned json array from the API, the bot will populate the drop-down view using relevant key-value pairs.<br>
4. Alternative Flow<br>
[E1] The Github token is not valid so the API returns a 401 error and bot displays an appropriate message.<br>

## Data Mocking:

In actual implementation, GitHub notification bot will interact with GitHub notification API. For Milestone 2, the response from API is mocked using txt file containing JSON string.<br>
Sample JSON string received from GitHub notification API is given below <br>

[{"id":"71264","unread":true,"reason":"mention","updated_at":"2019-02-28T02:19:40Z","last_read_at":null,"subject":{"title":"Selenium testing of view notification feature","url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/issues/20","latest_comment_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/issues/comments/45006","type":"Issue"},"repository":{"id":73598,"node_id":"MDEwOlJlcG9zaXRvcnk3MzU5OA==","name":"csc510-project","full_name":"bbdeshpa/csc510-project","private":true,"owner":{"login":"bbdeshpa","id":11919,"node_id":"MDQ6VXNlcjExOTE5","avatar_url":"https://avatars.github.ncsu.edu/u/11919?","gravatar_id":"","url":"https://github.ncsu.edu/api/v3/users/bbdeshpa","html_url":"https://github.ncsu.edu/bbdeshpa","followers_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/followers","following_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/following{/other_user}","gists_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/gists{/gist_id}","starred_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/starred{/owner}{/repo}","subscriptions_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/subscriptions","organizations_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/orgs","repos_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/repos","events_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/events{/privacy}","received_events_url":"https://github.ncsu.edu/api/v3/users/bbdeshpa/received_events","type":"User","site_admin":false,"ldap_dn":"CN=bbdeshpa,OU=People,DC=wolftech,DC=ad,DC=ncsu,DC=edu"},"html_url":"https://github.ncsu.edu/bbdeshpa/csc510-project","description":null,"fork":false,"url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project","forks_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/forks","keys_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/keys{/key_id}","collaborators_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/collaborators{/collaborator}","teams_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/teams","hooks_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/hooks","issue_events_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/issues/events{/number}","events_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/events","assignees_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/assignees{/user}","branches_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/branches{/branch}","tags_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/tags","blobs_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/git/blobs{/sha}","git_tags_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/git/tags{/sha}","git_refs_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/git/refs{/sha}","trees_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/git/trees{/sha}","statuses_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/statuses/{sha}","languages_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/languages","stargazers_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/stargazers","contributors_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/contributors","subscribers_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/subscribers","subscription_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/subscription","commits_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/commits{/sha}","git_commits_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/git/commits{/sha}","comments_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/comments{/number}","issue_comment_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/issues/comments{/number}","contents_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/contents/{+path}","compare_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/compare/{base}...{head}","merges_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/merges","archive_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/{archive_format}{/ref}","downloads_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/downloads","issues_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/issues{/number}","pulls_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/pulls{/number}","milestones_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/milestones{/number}","notifications_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/notifications{?since,all,participating}","labels_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/labels{/name}","releases_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/releases{/id}","deployments_url":"https://github.ncsu.edu/api/v3/repos/bbdeshpa/csc510-project/deployments"},"url":"https://github.ncsu.edu/api/v3/notifications/threads/71264","subscription_url":"https://github.ncsu.edu/api/v3/notifications/threads/71264/subscription"}]

#### Data Mocking Process:<br>
* To keep some randomness, we are using two sample text files for data mocking “json_rep_content_1.txt” and “json_rep_content_2.txt”.
* A function “getRandomInt()” is created to give a random value  from 1 to 10. If the value is even, JSON string will be read from “json_rep_content_1.txt” else from “json_rep_content_2.txt”
* Read file locally in JavaScript:<br>
 * To read a file locally, we are using “chrome.runtime.getURL” functionality which takes relative “file_path” as an argument and returns fully-qualified URL. 
 * fully-qualified URL obtained in above step is passed as an input to “fetch()” method which returns “Promise” response object.
 * “text()” method is called on the promise response object (Eg. response.text()) to convert the response object into the json string

#### Mocking Code Flow Description: <br>
All the mocking functionality is implemented in Background.js <br>
The flow will be as follows: <br>
updateNotifications() -> fetchNotifications_mock() -> readTextFile(file_path) -> fetch(url) <br>

###### Explanation:
* updateNotifications() calls fetchNotifications_mock() to get the mock data which is used by bot functions <br>
* fetchNotifications_mock() selects a file in random and call readTextFile() with that file <br>
* readTextFile() calls fetch() method to read data from that file. <br>

## Unit Testing
Unit Testing is a level of software testing where individual units/ components of a software are tested. The purpose is to validate that each unit of the software performs as designed. A unit is the smallest testable part of any software. It usually has one or a few inputs and usually a single output. In procedural programming, a unit may be an individual program, function, procedure, etc. In object-oriented programming, the smallest unit is a method.  <br>
In this project unit testing is carried out using Mocha, a JavaScript Test Framework. It runs on Node.js. During the testing assert statement is provided using a separate library called Chai. There are three key elements while carrying out unit testing using **Mocha and Chai** <br>
* **assert** helps to determine the status of the test, it determines the success or failure of the test.
* **describe** is a function which holds the collection of tests. It takes two parameters, first one is the meaningful name to functionality under test and second one is the function which contains one or multiple tests.
* **it** is a function again which is actually a test itself and takes two parameters, first parameter is name to the test and second parameter is function which holds the body of the test. <br>

For the setup of mocha on a system, the development dependencies must be added to the **package.json** file. This will be carried out using the command *sudo npm install chai --save-dev mocha*. In the same file the value of test must be changed to **"mocha"**. This will set up the environment for mocha.

The tests are written for two functions **fetchToken()** and **verifyToken()** which are in the **options.js** file. The tests will be written in a different folder called **test** which will be placed along with the source folder (src). The file where the testing code is written is saved as **optionsTest.js**. All the other tests will be written and stored in the test folder. <br>
To run the tests the following command must executed- <br>
*sudo npm run test*<br>

![Unit-Test-Image](https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/screenshot_testing.png)


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
WORKSHEET.md : https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/WORKSHEET.md <br>

## Screencast <br>
MileStone2 Screencast: https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/MileStone2.mp4 <br>




 
