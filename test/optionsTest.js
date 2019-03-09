const assert = require('chai').assert;
const verifyToken = require('../options');
const fetchToken = require('../options');

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
