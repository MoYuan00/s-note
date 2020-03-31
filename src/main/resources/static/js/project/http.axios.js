/**
 * 对axios 再进行封装
 */
const axiosInstance = axios.create({
    baseURL: '',
    timeout: 4000,
    maxContentLength: 5000,
    headers: { 'X-Custom-Header': 'foobar' },
    // `transformResponse` 在传递给 then/catch 前，允许修改响应数据
    // transformResponse: [function (data) {
    //     // 对 data 进行任意转换处理
    //     return data;
    // }],
});

/**
    拦截器
    在请求或响应被 then 或 catch 处理前拦截它们。
    // 移除： axios.interceptors.request.eject(myInterceptor);
*/

// 添加请求拦截器
axiosInstance.interceptors.request.use((config) => {
    // 在发送请求之前做些什么
    if (config.method == 'post') {// 如果是 post 请求， 那么将请求格式改为 json 
        config.headers['Content-Type'] = 'application/json';
    }
    console.group('请求 ' + config.url);
    console.log( ' 请求类型:' + config.method);
    console.groupEnd();
    return config;
}, (error) => {
    // 对请求错误做些什么
    console.group('request 请求错误！');
    if (error.response) {
        // 请求已发出，但服务器响应的状态码不在 2xx 范围内
        console.log(error.response.data);
        console.log(error.response.status);
        console.log(error.response.headers);
    } else {
        // Something happened in setting up the request that triggered an Error
        console.log('Error', error.message);
    }
    console.groupEnd();
    return Promise.reject(error);
});

// 添加响应拦截器
axiosInstance.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    console.group('响应 ' + response.config.url + ' 成功')
    console.log(response);
    console.groupEnd()
    return response;
}, function (error) {
    // 对响应错误做点什么
    console.group();
    console.log('响应错误！')
    console.log(error.data);
    console.log(error.config);
    console.groupEnd();
    return Promise.reject(error);
});