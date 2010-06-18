CKEDITOR.editorConfig = function( config )
{
  config.toolbar = 'MyToolbar';

  config.toolbar_MyToolbar =
  [
      ['NewPage','Preview'],
      ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Scayt'],
      ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
      ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
      '/',
      ['Styles','Format'],
      ['Bold','Italic','Strike'],
      ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
      ['Link','Unlink','Anchor']
  ];

};
