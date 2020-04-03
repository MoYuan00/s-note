const rootUserRemoteJs = {
    getUsers(user){
        return axiosInstance.get('../user/selectUseRoot');
    }
}