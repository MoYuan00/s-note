const localJs = {
    editNote:{
        /**
         * 获取后会立即清空
         * @returns {string}
         */
        get(){
            const id = localStorage.getItem("editNoteId");
            return id;
        },
        set(noteId){
            localStorage.setItem("editNoteId", noteId);
        },
    }
};