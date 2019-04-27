


# Design: Milestone 1

### TOPIC: GitHub Notification Bot

### Problem Statement

One of the issues while developing software using GitHub is not being notified or missing notifications about updates in the repository. Due to the complexities of modern agile software development, developers have to manage multiple tools parallelly. This may cause them to miss important notifications that are relevant to them and the overall development of the project.

Missing notifications can lead to problems that slow down the development process and hamper production software quality. Irregular git pulls may lead to merge conflicts which can be difficult to resolve. These conflicts can sometimes slow down development process as resolving them is tedious and time consuming. Also, in a project it is important to be immediately notified about issues being created as sometimes these issues might be security/scalability vulnerability bugs. Thus, making it important to resolve them promptly. In addition to these, it is also important to know the tasks being completed while working parallely on a project so that the future tasks can be planned accordingly.

### Solution Description

The GitHub Notification bot will be an extension to Google Chrome, which is the most popular web browser. This extension will be linked to a GitHub account and will provide regular updates for it. The notification bot will interact with GitHub APIs every 30 seconds and will display unread notifications. The bot will help all the collaborators to stay tuned with the changes made to their repositories. This will improve the quality of software and speed up the process of development by timely resolution of merge conflicts and by apt announcement of issues.

To interact with the bot, the user first needs to install and add the extension to the web browser. The user then needs to provide "Personal Access Token" created from GitHub Account only for the first time. In action, the bot will populate notifications to the user as a list in a drop down when the user clicks the extension icon. The message-title in the dropdown will be a hyperlink to the notification. The notification will include the details regarding any commits, pull requests or issues related to those repositories.

### Use Cases

###### USE CASE: Synchronising GitHub with bot
1. Preconditions<br>
User must have the extension installed.<br>
2. Main Flow<br>
User will provide correct credential (personal access token) to access the content of GitHub. [S1]<br>
3. Sub Flow<br>
[S1] Notifications of the updates in the repository will be displayed.<br>
4. Alternative Flow<br>
[E1] Incorrect credentials entered<br>

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

### Desgin Sketches
#### Wireframes
###### Figure 1
<p align="center">
<img align="center" width="550" src="https://media.github.ncsu.edu/user/11941/files/71890e00-3121-11e9-9835-331d88a82628">
</p>
<br>
The figure describes the initial setup of the bot once it is installed on the chrome browser. The user then enters its details which includes the personal access token from the GitHub and proceeds to the next step by saving the information.

######  Figure 2
<p align="center">
<img align="center" width="550" src="https://media.github.ncsu.edu/user/11941/files/a006e900-3121-11e9-9653-11a5b6c99827">
</p>
The figure above shows how the notifications from the user's GitHub account will be displayed on the browser through the bot. The notification will include information regarding the changes (pull requests, commits, etc.) along with the date and time of the commit. An option to remove all the notifications is also provided to the user through a Mark All Read button.

######  Figure 3
<p align="center">
<img align="center" width="550" src="https://media.github.ncsu.edu/user/11941/files/a39a7000-3121-11e9-8307-2ced799ca39b">
</p>
The image above is a sample page to which a user will be redirected based upon the notification clicked through the bot. The user can view his notification and it's details on GitHub through this process.

##### StoryBoard
<p align="center">
<img align="center" src="https://media.github.ncsu.edu/user/11941/files/ae550500-3121-11e9-8d4a-3644a18bf63e">
</p>

### Architecture Design
#### Component Diagram
<p align="center">
<img align="center" src="https://media.github.ncsu.edu/user/11941/files/a8f7ba80-3121-11e9-91f1-5f87e7f969e8">
</p>

Above Component Diagram explains different components in bot architecture and explains mapping between them. Arrow descriptions are as follows:<br>
1. User provides Personal Access Token which serves as authentication with the GitHub account<br>
2. Bot shows notifications to the user by interacting with GitHub API<br>
3. Bot makes rest call to GitHub API to fetch notifications or to mark all notifications read<br>
4. GitHub API sends JSON response based on request sent by the bot<br>
5. Bot stores Personal Access Token to browser local storage for future use<br>
6. Personal Access Token is retrieved from local storage for each new user session<br>

#### Component Level Description

###### User <br>
User is responsible for setting up the notification bot extension and trigger functionalities provided by the bot.<br>
###### GitHub API <br>
This component will get requests from the bot and then will respond them accordingly. [GitHub Notifications API](https://developer.github.com/v3/activity/notifications/) returns the list of unread notifications for a user account in JSON format.<br>
###### Web Browser (Google Chrome) <br>
Web browser is the component in which the user interacts with the bot and storage is maintained<br>
###### Local Storage <br>
[This component](https://developer.chrome.com/extensions/storage) is a sub-part of web browser and is responsible for storing the personal access token entered by the user. It provides persistent storage for chrome applications. The data stored in local storage is available even when browser is closed and reopened. Local storage can be accessed using the [local storage API](https://developer.mozilla.org/en-US/docs/Web/API/Web_Storage_API#localStorage).<br>
###### Bot (Chrome Extension) <br>
This is the most important component of the architecture responsible which acts as a gateway between User and GitHub API. All the logic resides in this component. This component also resides in web browser.<br>

#### Activity Diagram
<p align="center">
<img align="center" src="https://media.github.ncsu.edu/user/11941/files/ec9ef400-3122-11e9-841f-403f170eb22e">
</p>
The above diagram illustrates the flow of control between the components for each user action. It depicts how the bot’s components interact with each other to complete a given task. 

#### Constraints for Architecture:<br>
1. There can be only one GitHub account per system.<br>
2. Personal Access Token should not be visual in the UI.<br>
3. Bot should not make any changes to the GitHub account unless triggered by user.<br>

#### Design Pattern
For building the chrome extension we will be using the [MVC](https://developer.chrome.com/apps/app_frameworks) design pattern. The reason for this choice is for the separation of presentation, control and model components. This will assist us in developing these components independently and their easy maintainence. 
