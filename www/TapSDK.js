var exec = require('cordova/exec');

module.exports = {
    updateGame(onCancel) {
        exec(onCancel, ()=>{}, 'TapSDK', 'updateGame', []);
    },
}