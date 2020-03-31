/**
 * index页面的 远程访问js代码
 */
let indexRemoteJs = {
    getAllUserNotes(){
        // axios.post(url[, data[, config]])
        return axiosInstance.get('note/getAllUserNotes');
    }
};