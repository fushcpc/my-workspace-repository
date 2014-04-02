/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	config.toolbar = 'MyToolbar';
	config.toolbar_MyToolbar = [ [ 'Source', 'insertCode', 'Bold', 'Italic',
			'Underline', 'Strike', 'JustifyLeft', 'JustifyCenter',
			'JustifyRight', 'Link', 'Unlink', 'Image', 'Table',
			'HorizontalRule', 'Smiley', 'FontSize', 'TextColor', 'BGColor',
			'Maximize' ] ];
	config.enterMode=2;  
	config.shiftEnterMode=1;
};
//CKEDITOR.EnterMode = 'br' ;    
//CKEDITOR.ShiftEnterMode = 'p' ;