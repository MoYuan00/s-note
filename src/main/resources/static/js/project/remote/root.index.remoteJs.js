const rootIndexRemoteJs = {
    login(user){
        return axiosInstance.post('../user/loginByRoot',JSON.stringify(user));
    }
}