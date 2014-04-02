package com.j2se.book.crazyseries.project.photoviewer.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

import com.j2se.book.crazyseries.project.photoviewer.ViewHandlerFactory;
import com.j2se.book.crazyseries.project.photoviewer.ViewerFrame;
import com.j2se.book.crazyseries.project.photoviewer.handler.ViewHandler;

public class ViewAction extends AbstractAction {
    private final ViewerFrame frame;

    public ViewAction(String name, ViewerFrame frame) {
        super(name);
        this.frame = frame;
    }

    public ViewAction(String name, Icon icon, ViewerFrame frame) {
        // super(name,icon);
        putValue(Action.SMALL_ICON, icon);
        putValue(Action.SHORT_DESCRIPTION, name);
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (String) getValue(Action.NAME);
        if (name == null) {
            name = (String) getValue(Action.SHORT_DESCRIPTION);
        }
        ViewHandler handler = ViewHandlerFactory.getHandler(name);
        if (handler != null) {
            handler.handle(frame);
        }
    }
}
