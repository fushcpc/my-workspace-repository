CKEDITOR.dialog.add('insertCode', function(editor){
    
    return {
        title: '插入代码',
        resizable: CKEDITOR.DIALOG_RESIZE_BOTH,
        minWidth: 720,
        minHeight: 480,
        contents: [{
            id: 'cb',
            name: 'cb',
            label: 'cb',
            title: 'cb',
            elements: [{
                type: 'select',
                label: '语种',
                id: 'lang',
                required: true,
                'default': 'java',
                items: [['Java', 'java'], ['XML', 'xml'], ['Html', 'xhtml'], ['JavaScript', 'js'], ['SQL', 'sql'],['ActionScript3', 'as3'], ['C#', 'csharp'],['CSS', 'css']]
            }, {
                type: 'textarea',
                style: 'width:700px;height:420px',
                label: 'Code',
                id: 'code',
                rows: 20,
                'default': ''
            }]
        }],
        onOk: function(){
            code = this.getValueOf('cb', 'code');
            lang = this.getValueOf('cb', 'lang');
            html = code;
            editor.insertHtml("<pre class=\"brush:" + lang + ";\">" + html + "</pre>");
        }
    };
});
