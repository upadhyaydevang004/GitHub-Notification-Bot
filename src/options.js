let setGitToken = document.getElementById('setGitToken');
var tokenValue = "";

function verifyToken(givenToken) {
    url = base_url + "/notifications";
    httpGetAsync(url, givenToken, button_press_callback, false);
}

var button_press_callback = function (response, pass) {
    if(pass){
        localStorage.gitToken = tokenValue;
        localStorage.check_box = "true";
        //console.log("local Storage checkbox is set");
        document.getElementById("enableNot").checked =true;
        //console.log("calling update updateNotifications");
        updateNotifications(); 
    }
    else{
        document.getElementById("errorBox").style.display = "block";
    }
}

setGitToken.onclick = async function() {
    tokenValue = document.getElementById("gitHubToken").value;
    verifyToken(tokenValue);
}