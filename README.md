# GitHub-Notification-Bot-

### Problem Statement

One of the issues while developing software using GitHub is not being notified or missing notifications about updates in the repository. Due to the complexities of modern agile software development, developers have to manage multiple tools parallelly. This may cause them to miss important notifications that are relevant to them and the overall development of the project.

Missing notifications can lead to problems that slow down the development process and hamper production software quality. Irregular git pulls may lead to merge conflicts which can be difficult to resolve. These conflicts can sometimes slow down development process as resolving them is tedious and time consuming. Also, in a project it is important to be immediately notified about issues being created as sometimes these issues might be security/scalability vulnerability bugs. Thus, making it important to resolve them promptly. In addition to these, it is also important to know the tasks being completed while working parallely on a project so that the future tasks can be planned accordingly.

### Solution Description

The GitHub Notification bot will be an extension to Google Chrome, which is the most popular web browser. This extension will be linked to a GitHub account and will provide regular updates for it. The notification bot will interact with GitHub APIs every 30 seconds and will display unread notifications. The bot will help all the collaborators to stay tuned with the changes made to their repositories. This will improve the quality of software and speed up the process of development by timely resolution of merge conflicts and by apt announcement of issues.

To interact with the bot, the user first needs to install and add the extension to the web browser. The user then needs to provide "Personal Access Token" created from GitHub Account only for the first time. In action, the bot will populate notifications to the user as a list in a drop down when the user clicks the extension icon. The message-title in the dropdown will be a hyperlink to the notification. The notification will include the details regarding any commits, pull requests or issues related to those repositories.

#### Constraints for Architecture:<br>
1. There can be only one GitHub account per system.<br>
2. Personal Access Token should not be visual in the UI.<br>
3. Bot should not make any changes to the GitHub account unless triggered by user.<br>

#### Design Pattern
For building the chrome extension we will be using the [MVC](https://developer.chrome.com/apps/app_frameworks) design pattern. The reason for this choice is for the separation of presentation, control and model components. This will assist us in developing these components independently and their easy maintainence. 
