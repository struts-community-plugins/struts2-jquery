CKEDITOR.editorConfig = function (config) {

    config.plugins = 'dialogui,dialog,about,a11yhelp,basicstyles,blockquote,clipboard,panel,floatpanel,menu,contextmenu,resize,button,toolbar,elementspath,list,indent,enterkey,entities,popup,filebrowser,floatingspace,listblock,richcombo,format,htmlwriter,horizontalrule,wysiwygarea,image,fakeobjects,link,magicline,maximize,pastetext,pastefromword,removeformat,sourcearea,specialchar,menubutton,scayt,stylescombo,tab,table,tabletools,undo,wsc';
    config.extraPlugins = 'onchange';

    config.toolbar = 'MyToolbar';

    config.toolbar_MyToolbar =
        [
            ['NewPage', 'Preview'],
            ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Scayt'],
            ['Undo', 'Redo', '-', 'Find', 'Replace', '-', 'Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak'],
            '/',
            ['Styles', 'Format'],
            ['Bold', 'Italic', 'Strike'],
            ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', 'Blockquote'],
            ['Link', 'Unlink', 'Anchor']
        ];

};
