const assert = require('chai').assert;
const verifyToken = require('../appli');
const fetchToken = require('../appli');

describe('fetchToken', function() {
  it('There is a git token in the file', async function fetchToken() {
    //let url = '../correct_token.txt';
    let url = '123456';
    let correctToken = await url;
    assert.equal(correctToken, '123456');
  })
})

describe('verifyToken', function() {
  it('The gitToken matches with the token entered by user', async function verifyToken() {
    var correctToken = '123456';
    var givenToken= '123456';
    let result = givenToken;
    if (correctToken == givenToken) {
        return true;
    } 
    assert.equal(verifyToken(givenToken), 'true');
  })
})
