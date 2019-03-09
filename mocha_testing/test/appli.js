async function fetchToken() {
    const url = chrome.runtime.getURL('correct_token.txt');

    const correctToken = await fetch(url)
    return correctToken.text();
}

async function verifyToken(givenToken){
    //Fetch data from token.txt into variable correctToken
    var correctToken = await fetchToken();
    if (correctToken == givenToken) {
        return true;
    } else {
        return false;
    }
}

