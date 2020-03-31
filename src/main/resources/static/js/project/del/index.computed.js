const computed = {
    translate() {
        return this.selectedNote ? marked(this.selectedNote.content) : '';
    },
    newBtnTitle() {
        return '当前笔记个数: ' + this.noteList.length;
    },
    // 获取选择的笔记
    selectedNote() {
        if(!this.noteList || this.noteList.length <= 0) return;

        var note = this.noteList.find(note => note.id == this.selectedId);
        if(note == null){
            this.selectedId = this.noteList[0].id;
            return this.noteList[0];
        }
        return note;
    }
};