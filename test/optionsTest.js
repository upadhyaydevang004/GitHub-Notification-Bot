const assert = require('chai').assert;
const verifyToken = require('../options');
const fetchToken = require('../options');
const showNotifications = require('../popup')

describe('fetchToken', function() {
  it('There is a git token in the file', async function fetchToken() {
    let url = chrome.runtime.getURL('../correct_token.txt');
    let correctToken = await url;
    assert.equal(correctToken, '123456');
  })
})

describe('verifyToken', function() {
  it('The gitToken matches with the token entered by user', async function verifyToken(givenToken) {
    var correctToken = await fetchToken();
    var givenToken= '123456';
    let result = givenToken;
    if (correctToken == givenToken) {
        return true;
    } else {
        return false;
    } 
    assert.equal(result, 'true');
  })
})

describe('showNotifications', function() {
  it('The notifications are correctly shown after correct token is entered', function showNotifications(NotificationsJson))
	var notifications = JSON.parse(NotificationsJson);
	var correctToken = await fetchToken();
	if ( gitTokenValue = localStorage["gitToken"] ){
		return notifications;
	} else {
		false;
	}
	assert.true(notifications);
  })
})

	