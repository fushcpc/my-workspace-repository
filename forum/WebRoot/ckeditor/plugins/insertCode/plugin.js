/*
Copyright (c) 2003-2009, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.plugins.add('insertCode', {
	requires : [ 'dialog' ],
	init : function(a) {
		a.addCommand('insertCode', new CKEDITOR.dialogCommand('insertCode'));
		a.ui.addButton('insertCode', {
			label : a.lang.insertCode.toolbar,
			command : 'insertCode',
			icon : this.path + 'images/insertCode.gif'
		});
		CKEDITOR.dialog.add('insertCode', this.path + 'dialogs/insertCode.js');
	}
});
