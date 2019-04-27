//updateNotifications();
// There is some problem with set interval ..sometimes its loading json..sometimes not..need to check in next milestone

setInterval(updateNotifications, 30000);  // need to make it 30 sec in future
setInterval(checkMasterStatus, 5000); 

var text;
var base_url = "https://github.ncsu.edu/api/v3"

function httpGetAsync(theUrl, token, callback, addAcceptHeader)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4){
        	if(xmlHttp.status == 200){
             callback(xmlHttp.responseText, true);
         }
         else{
             callback("done", false);
         }
     }
 }
 xmlHttp.open("GET", theUrl, true); /* true for asynchronous */
 xmlHttp.setRequestHeader('Authorization','token ' + token);
 if(addAcceptHeader){
    xmlHttp.setRequestHeader('Accept','application/vnd.github.v3.raw');
}
xmlHttp.send();
}

function httpPutAsync(theUrl, token, callback)
{
    var xmlHttp = new XMLHttpRequest();
    
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4){
        	if(xmlHttp.status == 205){
             callback(xmlHttp.responseText, true);
         }
         else{
             callback("done", false);
         }
     }
 }
    xmlHttp.open("PUT", theUrl, true); // true for asynchronous 
    xmlHttp.setRequestHeader('Authorization','token ' + token);
    xmlHttp.send();
}


async function checkMasterStatus(){
    //Note: we will have to enter our personal access token as manifest is not public
    gitToken = localStorage["gitToken"];
    url = base_url + '/repos/bbdeshpa/csc510-project/contents/src/manifest.json';
    if (gitToken) {
	httpGetAsync(url, gitToken, checkMasterStatusCallback, true);
    } 
}

var checkMasterStatusCallback = function(manifestFileInMaster , pass){
    if(pass){
        /* manifest from remote git repo*/
        var manifest_obj = JSON.parse(manifestFileInMaster);
        
        /* manifest from locally running app*/
        var manifestData = chrome.runtime.getManifest();
        if (manifestData.version != manifest_obj["version"]){
            console.log( manifestData.version.toString() + "---" +manifest_obj["version"].toString());
            document.getElementById("updateErrorBox").style.display = "block";
        }
        else{
            console.log("Still Running");
        }
    }
}

async function updateNotifications(){
	
	gitToken = localStorage.gitToken;
	
	if(gitToken != null && localStorage.check_box == "true"){
		url = base_url + "/notifications?all=false";
        if(localStorage.sinceLastNotification!=null){
            url+="&since="+localStorage.sinceLastNotification;
        }
        httpGetAsync(url, gitToken, updateNotificationsCallback, false);	
    }


}

var updateNotificationsCallback = function(newNotifications, pass){
	if(pass){
		oldNotifications = localStorage.notificationsJson;
		if(newNotifications != oldNotifications){
			localStorage.notificationsJson = newNotifications;
			location.reload();
		}
	}
}

