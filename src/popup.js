//on body load function to show insert/notifications UI
document.body.onload = function(){
  gitTokenValue = localStorage["gitToken"];
  

  if (localStorage.getItem("gitToken") == null) {
    document.getElementById("notification_list").style.display = "none";
    document.getElementById("mark_all_read").style.display = "none";
    document.getElementById("errorBox").style.display = "none";
    document.getElementById("enableDisableBox").style.display = "none";
  } else {
    document.getElementById("loginDetails").style.display = "none";
    document.getElementById("enableDisableBox").style.display = "block";
    if(localStorage["check_box"]!="true")
    {
      document.getElementById("enableNot").checked =false;
       document.getElementById("mark_all_read").style.display = "none";
      NoUnreadNotificationsList("You have disabled the notifications");
    }
    else
    {
    document.getElementById("enableNot").checked =true;
    document.getElementById("mark_all_read").style.display = "block";
    showNotifications(localStorage.notificationsJson);
    }  
  }
}

//update notifications UI with notifications json object
function showNotifications(NotificationsJson) {
 var notifications = JSON.parse(NotificationsJson);
 if (notifications == null) {
    NoUnreadNotificationsList("No Unread Notifications");
  } else {
      chrome.browserAction.setBadgeBackgroundColor({color:"green"});
      chrome.browserAction.setBadgeText({text:(notifications.length).toString()});
     for(var i=0;i< notifications.length;i++){
      newLI = document.createElement("li");
      newAnch = document.createElement("a");

      var txt = notifications[i].subject.type+": "+notifications[i].subject.title;
      newText = document.createTextNode(txt);

      newAnch.appendChild(newText);
      newAnch.setAttribute('href', filterURL(notifications[i].subject.url));
      newLI.appendChild(newAnch);
      notification_list.appendChild(newLI);
    }

  }
}

//function to open the notification in new tab
document.getElementsByTagName("BODY")[0].onclick = function(e) {
  e = e || event      
  var target = e.target || e.srcElement    
  if (target.nodeName != 'A') return        
    var href = target.href    
  chrome.tabs.create({url: href});
  return false;   
}

//Empty function to set notifications as read
function markNoitificationsAsRead(){
  localStorage.notificationsJson = null;
}

//To remove all child elements
function NoUnreadNotificationsList(textToShow){
  document.getElementById("notification_list").innerHTML = "";
  newText = document.createTextNode(textToShow);
  document.getElementById("notification_list").appendChild(newText);
  document.getElementById("notification_list").style.color = "blue";
  document.getElementById("notification_list").style.fontSize = "medium";
}

//Commenting mark all read for testing
document.getElementById("mark_all_read").onclick = function(){
  markNoitificationsAsRead();
  chrome.browserAction.setBadgeText({text:""});
  NoUnreadNotificationsList("No Unread Notifications");
}

document.getElementById("enableNot").onclick = function(){
 if(localStorage["check_box"] == "true")
 {
  localStorage.check_box = "false";
 }
else
{ 
  localStorage.check_box = "true";
  
}
location.reload();
}

//to change api URL to broswer URL
function filterURL(url){
  return url.replace(/api\/v3\/repos\//,"");
}