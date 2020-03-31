const bootoastUtil = {
    toast(msg, type_){
        bootoast.toast({
            message: msg,
            type: type_,
            position: 'right-top',
            icon: null,
            timeout: true,
            animationDuration: 300,
            dismissible: true
        });
    },
    toastBottomRight(msg, type_){
        bootoast.toast({
            message: msg,
            type: type_,
            position: 'right-bottom',
            icon: null,
            timeout: true,
            animationDuration: 300,
            dismissible: true
        });
    }
};