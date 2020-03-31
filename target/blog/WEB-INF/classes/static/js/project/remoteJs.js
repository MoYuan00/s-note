const remoteJs = {
    /**
     * 获取 clazz列表
     */
    getRemoteClazz() {
        var path = 'clazz/select';
        return axios({
            url: path,
            method: 'GET'
        });
    },
    /**
     *     获取 note列表
     */
    getRemoteAllNote() {
        const me = this;
        var path = 'note/get';
        return axios({
            url: path,
            method: 'GET'
        });
    },
    /**
     *     获取 note列表
     */
    getRemoteAllWastedNote() {
        const me = this;
        var path = 'note/getWasted';
        return axios({
            url: path,
            method: 'GET'
        });
    },
    /**
     * 保存一个笔记
     * @param note 笔记对象
     */
    insertNote(note) {
        return axios({
            url: 'note/insert',
            method: 'post',
            data: JSON.stringify(note),
            headers: {
                'Content-Type': 'application/json'
            }
        });
    },
    /**
     * 修改一个笔记
     * @param note 笔记对象
     */
    updateNote(note) {
        return axios({
            url: 'note/update',
            method: 'post',
            data: JSON.stringify(note),
            headers: {
                'Content-Type': 'application/json'
            }
        });
    },
    /**
     * 删除一个 笔记
     * @param id
     */
    deleteNote(id) {
        return axios({
            url: 'note/delete' + "?id=" + id,
            method: 'post',
        });
    },
    insertClazzReturn(clazz) {
        return axios({
            url: 'clazz/insertReturn',
            method: 'post',
            data: JSON.stringify(clazz),
            headers: {
                'Content-Type': 'application/json'
            }
        })
    },
    selectLoginUser() {
        return axios({
            url: 'user/getLoginUser',
            method: 'post',
        })
    },
    logout() {
        return axios({
            url: 'user/logout',
            method: 'post',
        })
    },
    login(user) {
        return axios({
            url: 'user/login',
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(user),
        })
    },
    register(user) {
        return axios({
            url: 'user/register',
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(user),
        });
    },
    deleteClazz(clazzId){
        return axios({
            url: 'clazz/delete?clazzId=' + clazzId,
            method: 'get',
        })
    },
    updateClazz(clazz){
        return axios({
            url: 'clazz/update',
            method: 'post',
            data: JSON.stringify(clazz),
            headers: {
                'Content-Type': 'application/json'
            },
        })
    },
    recoveryNote(id){
        return axios({
            url: 'note/recovery?id=' + id,
            method: 'get',
        })
    },
    updatePassword(password){
        return axios({
            url: 'user/updatePassword',
            method: 'post',
            data: 'password=' + password,
        });
    }
};