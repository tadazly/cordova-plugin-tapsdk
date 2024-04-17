declare namespace TapSDK {
    /**
     * 自行判断版本号后，确定需要强更时调用
     * @param onCancel 用户取消更新回掉
     * @example TapSDK.updateGame(()=>log('user canceled'));
     */
    function updateGame(onCancel?: () => void): void;
}