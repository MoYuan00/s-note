const methods = {
    // 当 保存修改
    saveChangeLocal(){
        this.selectedNote.updateTime = Date.now();
        this.changeOperate(this.selectedNote.id, operateTypes.update);
        this.saveNoteList();
    },
    favorite(note) {
        note.favorite = !note.favorite;
        this.saveChangeLocal();
    },
    // 保存笔记
    saveNoteList() {
        console.log("saveNoteList 保存笔记!");
        localStorage.setItem(itemStr, JSON.stringify(this.noteList));
    },
    // 新建笔记
    newNote() {
        const time = Date.now();
        const note = {
            id: String(time),
            title: 'New Note' + this.noteList.length,
            content: 'make **note** in here',
            createTime: time,
            updateTime: time,
            favorite: false
        }
        this.noteList.push(note);
        this.changeOperate(note.id, operateTypes.insert);
        console.log("新增笔记" + note.title);
        // 切换 到新建的那个上
        this.selectNote(note);
    },
    // 选中笔记
    selectNote(note) {
        console.log("选中" + note.title);
        this.selectedId = note.id;
        // 自适应=编辑器高度
        // var textarea = document.getElementById('edit-textarea');
        // makeExpandingArea(textarea);
    },

    // 保存到服务器
    saveRemote() {
        var me = this;
        console.log(me.noteList);
        console.log(me.operations);
        axios({
            url: '/note/save',
            method: 'post',
            data: JSON.stringify({noteList: me.noteList, noteOperateList: me.operations}),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(msg => {
            console.log("成功");
            console.log(msg);
            if(msg.data.data){// 同步成功
                this.operations.slice(0, this.operations.length);// 删除所有的的未操作
            }
        }).catch(msg => {
            console.log("失败");
            console.log(msg)
        });
    },
    // 从云端获取
    getRemote() {
        var me = this;
        console.log(me.noteList);
        axios({
            url: '/note/get',
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(msg => {
            console.log("成功");
            console.log(msg);
            me.noteList = msg.data.data;
        }).catch(msg => {
            console.log("失败");
            console.log(msg)
        });
    },
    // 从本地删除笔记
    deleteNoteLocal(note) {
        const index = this.noteList.indexOf(note);// 查找
        if (index >= 0) {
            this.noteList.splice(index, 1);// 删除
            this.changeOperate(note.id, operateTypes.delete);
            // 删除后 选中最后一个，如果没有就不选择
            if(this.noteList.length > 0){
                this.selectNote(this.noteList[this.noteList.length - 1]);
            }
            // 删除之后 保存
            this.saveNoteList();
        }
    },
    // 获取登陆 的 userId
    getLoginUserId(){
        axios({
            url: '/user/getLoginUserId',
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(msg => {
            console.log("/user/getLoginUserId 成功");
            console.log(msg);
        }).catch(msg => {
            console.log("/user/getLoginUserId 失败");
            console.log(msg)
        });
    },
    /**
     * 修改操作
     * @param noteId 要修改的 笔记编号
     * @param operateType 要修改为什么操作
     */
    changeOperate(noteId, operateType){
        // 如果要 修改 的笔记 没有记录
        var oldOpIndex = this.operations.findIndex(op => op.id === noteId);
        var oldOperation = null;
        if(oldOpIndex >= 0) oldOperation = this.operations[oldOpIndex];
        console.log("noteId " + noteId + "oldOpIndex" + oldOpIndex + "  oldOperation" + oldOperation)
        const newOperation = {operateType: operateType, id: noteId};
        switch (operateType) {
            case operateTypes.delete:
                console.log("delete");
                if(oldOperation){
                    console.log("delete oldOpIndex");
                        // 如果 以前有insert 和 delete操作， 删除此操作，并且不添加 delete操作
                    this.operations.splice(oldOpIndex, 1);
                    // 如果以前是update，那么就 添加 delete操作
                    if(oldOperation.operateType == operateTypes.update){
                        this.operations.push(newOperation);
                    }
                }else{
                    this.operations.push(newOperation);
                }
                break;
            case operateTypes.insert:
                console.log("insert");
                this.operations.push(newOperation);
                break;
            case operateTypes.update:
                if(!oldOperation){// 如果以前没有操作 就 添加update
                    console.log("update");
                    this.operations.push(newOperation);
                }
                break;
        }
    }
};