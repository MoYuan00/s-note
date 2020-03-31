const indexMethods = {
    getRemoteClazz() {
        const me = this;
        remoteJs.getRemoteClazz().then(msg => {
            console.log("成功:");
            console.log(msg);
            if(!msg.data.data){
                bootoastUtil.toast("说实话，我发现 你是不是 没有 登录 偷偷 黑进来的！！！", 'warn')
            }
            me.clazzList = msg.data.data || [];
        }).catch(msg => {
            console.log("失败:");
            bootoastUtil.toast("获取错啦，请重试一下 ！！！！", 'error')

        });

    },
    getRemoteAllNote() {
        const me = this;
        remoteJs.getRemoteAllNote().then(msg => {
            console.log("成功:");
            console.log(msg.data);
            if(!msg.data.data){
                bootoastUtil.toast("说实话，我发现 你是不是 没有 登录 偷偷 黑进来的！！！", 'warn')
            }
            me.noteList = msg.data.data || [];
        }).catch(msg => {
            console.log("失败:");
            bootoastUtil.toast("获取错啦，请重试一下 ！！！！", 'error')
        });
    },
    changeSelectClazz(index) {
        this.clazzSelectedIndex = index;
        console.log("改变选中的类型: " + this.clazzSelectedIndex)
    },
    selectNote(note) {
        this.selectedNote = note;
    },
    clickNewNote() {
        localJs.editNote.set(null);
        location.href = "newNote.html";
    },
    // 获取 登录 的 用户 的信息
    selectLoginUser() {
        var me = this;
        remoteJs.selectLoginUser().then(msg => {
            console.log("成功");
            console.log(msg);
            if (msg.data.data) {
                me.user = msg.data.data;
            }else{
                bootoastUtil.toast("说实话，我发现 你是不是 没有 登录 偷偷 黑进来的！！！", 'warn')
                // 没有登陆 跳转
                window.location.href = 'login.html';
            }
        }).catch(msg => {
            console.log("失败");
            console.log(msg);
            bootoastUtil.toast("获取错啦，请重试一下 ！！！！", 'error')
        })
    },
    logout() {
        remoteJs.logout().then(msg => {
            console.log("成功")
            console.log(msg)
            if (msg.data.data) {
                location.href = 'login.html';
            }
        }).catch(msg => {
            console.log("失败")
            console.log(msg)
        });
    },
    updatePW(){
        remoteJs.updatePassword(this.updatePassword).then(msg=>{
            console.log("成功");
            console.log(msg);
            if (msg.data.state) {
                bootoastUtil.toast("密码修改成功啦！", 'success')
            }else{
                bootoastUtil.toast("密码修改失败 # # # ！", 'warn')
            }
            $('#updatePasswordModal1').modal('hide')// 关闭窗口
        }).catch(msg=>{
            console.log("失败");
            console.log(msg);
            bootoastUtil.toast("密码修改 错误 啦，请重试一下 ！！！！", 'error')
        });
    }
};