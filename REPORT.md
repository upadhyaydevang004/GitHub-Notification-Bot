# MILESTONE 5

## Screencast of the final demo of the GitHub Notification bot
https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/FINAL_PRESENTATION.mp4


## PROBLEM

One of the issues while developing software using GitHub is not being notified or missing important notifications regarding updates in the repository. Due to the complexities of modern agile software development, developers have to manage multiple tools parallelly. This may cause them to miss important notifications that are relevant to them and the overall development of the project.

Missing notifications can lead to problems that slow down the development process and hamper production software quality. Irregular git pulls may lead to merge conflicts which can be difficult to resolve. These conflicts can sometimes slow down development process as resolving them is tedious and time consuming. Also, in a project it is important to immediately be  notified about issues being created as sometimes these issues might be security/scalability vulnerability bugs. Thus, making it important to resolve them promptly. In addition to these, it is also important to know the tasks being completed while working parallelly on a project so that the future tasks can be planned accordingly.

## FEATURES

### [1] Synchronising GitHub with bot 

This feature included several steps that consisted of installing the extension and providing a correct personal access token in order to access the notifications from GitHub. The bot can be added from the "Chrome Web Store" or by downloading the code from the GitHub repo and then installing it from the extensions page.

<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/extension.png">
</p>
<br>
<br>

<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/chrome_store.png">
</p>
<br>
<br>

Once the user has installed the bot, he/she will be prompted to enter an access token. 

<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/first_page.png">
</p>
<br>
<br>

If the user has entered an invalid personal access token, the user will not be provided access to the GitHub repository.

<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/invalid.png">
</p>
<br>
<br>

### [2] Viewing the content of notifications

Once the user has logged in, he/she will be able to view the notifications on the content of the extension. 

<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/noti.jpeg">
</p>
<br>
<br>


### [3] Enable/ Disable notifications

A checkbox would be provided to the user, in case he/she would want an option to disable and re-enable the notifications.   

<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/enable.jpg">
</p>
<br>
<br>


If the user has not checked on the "Enable Notifications" checkbox, that is disabled them, he/she will not be shown any new updated from their GitHub repository.


<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/disabled.png">
</p>
<br>
<br>

### [4] Mark All Read 

A button "Mark All Read" will be provided to the user which he/she can use to remove all the notifications from the page. This will automatically clear all the notifications on the GitHub page too.

<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/basic.png">
</p>
<br>
<br>

### [5] Upgrading version of the bot

If the developers make any change to the version of the bot in the "manifest.json" file of the repository, the user will be prompted the update the bot from the chrome store. This way, the user can always be up to date with the application. 

<p align="center">
<img align="center" src="https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/version.png">
</p>
<br>
<br>


## REFLECTION

The development process of the bot was carried out in several stages. The detailed information of all stages are given below-

### Scope 

To begin defining the scope of our project we all sat together to decide one issue we wanted to tackle using software. We decided we wanted to address the problem of developers missing important project related notifications. Once the problem was finalised, we individually researched different approaches and later came together to brainstorm out findings. After several iterations we came up with the idea of creating a GitHub Notification Bot. 
This process helped us realise the importance of considering and evaluating everyones ideas and approaches as they cumulatively helped us in improving the scope and bringing clarity in what we were planning to develop.

### Task Planning and Development

The next stage Before each sprint we all evaluated the objective of the milestone and broke the task into smaller subtasks. We then keeping our calendars, task difficulty and technology strengths in mind, assigned each task to one of the team members. We had our tasks equally distributed and planned out. Equal distribution of work ensured that the entire burden of development didn’t fall on one person and we all learnt the core concepts of the technology and the process used to build it. 

We discussed how of our individual components will communicate by creating creating models for the request data and deciding the function signatures beforehand. This process helped us in debugging as we knew exactly what the expected output of each function will be. Overall the development process gave us insights on how a real world project works and how to collaborate in team. It taught us how to decide the scope, plan the tasks and implement the desired software. From a technology perspective  we learnt about the various Chrome APIs provided by Google and asynchronous programming using Js.

### Testing

To test we created some mock scenarios and the team member assigned with the task of development of the tests created them. We did both selenium testing and unit testing of each build. Testing ensured that each build was running as expected and there there were no bugs. Testing helped us realise the importance of writing good test cases as whenever we had errors we could easily identify and fix them. It also familiarised us with technologies like Mocha, Chai and Selenium. 

## LIMITATIONS

The limitations of the project are as follows:

[1] Once the user is logged in, by providing the credential (personal access token), he/she will not be able to log out of the application. The only way that is possible is by remove the extension from chrome and adding it again. This will prompt the user to enter the token again.

[2] The bot has currently been developed only for the Google Chrome web browser.

[3] The bot has currently been developed only for the NCSU GitHub accounts.

## FUTURE WORK

### [1] Session Management

Session management is one of the most important plan that can be added to a web application. Through this the user will be able to save the token they entered and can be used for any session they want to. We would want to add a "Logout" button, which will sign out the user for privacy purpose.

### [2] Extending project to other web browsers

We would also in the future, want to make this application available to other web browsers such as "Mozilla Firefox" or "Safari".

### [3] Extending project to any GitHub account
In the future we will extend our bot to work for types all GitHub and GitHub Enterprise accounts.







