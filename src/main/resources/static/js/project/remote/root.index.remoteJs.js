const rootIndexRemoteJs = {
  login(user) {
    return axiosInstance.post("../user/loginByRoot", JSON.stringify(user));
  },
  // 获取是否是管理员登录
  isRootUserLogined() {
    return axiosInstance.get("../user/root/isLogin");
  },
};
