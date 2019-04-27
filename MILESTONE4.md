### Milestone 4: Deployment <br>

We have deployed our chrome extension to Google Chrome Store. The deployment using configuration management tools (e.g., ansible and vagrant) is not applicable for our project. After discussion with the professor, team has come up with two implementations.<br>
* Creation of selenium script to publish the app on chrome store
* Notify the user about the new update available
## (1) Creation of selenium script to publish the app on chrome store
To publish the newer version of the app, developer has to access chrome store account and follow the deployment process. We have completely automated this process using selenium script. Once the developer needs to update the version, the selenium script should be run. The script will then pick the code zip and publish it to the chrome store. <br>

Instructions to run the script(Automate.java in Selenium Testing Project):<br>
Automate.java: https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/Selenium%20Testing/test/src/test/java/test/test/Automate.java
* For first time update, the publishing of app needs to be done manually. Next time onwards, it can be done with the selenium script
* Add testNG plugin to the eclipse IDE where the selenium script is present
* update the script with the credentials of the developer's app account
* Run the script as testNG suite

For the demo of this feature, click the link : https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/Proposal1.mp4

## (2) Notify the user about the new update available
We have created a functionality that checks the version number in the manifest file on the master branch. Incase there is a difference in the version number in the GitHub repo and the locally installed app, the chrome bot notifies the user that the app has been updated by displaying a message "New Update available"<br>
For the demo of this feature, click the link: https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/update_app_notification.mp4

Link to Task Tracking:- https://github.ncsu.edu/bbdeshpa/csc510-project/blob/master/WORKSHEET.md




