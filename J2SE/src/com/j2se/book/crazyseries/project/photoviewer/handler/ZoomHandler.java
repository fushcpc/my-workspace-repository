package com.j2se.book.crazyseries.project.photoviewer.handler;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.j2se.book.crazyseries.project.photoviewer.ViewerFrame;

public class ZoomHandler implements ViewHandler {

    private final boolean       isZoomIn;

    private final static double ZOOM_RANGE = 0.5;

    public ZoomHandler(boolean isZoomIn) {
        this.isZoomIn = isZoomIn;
    }

    @Override
    public void handle(ViewerFrame frame) {
        Icon icon = frame.getPhotoLabel().getIcon();
        if (icon != null) {
            double range = isZoomIn ? 1 + ZOOM_RANGE : 1 - ZOOM_RANGE;
            ImageIcon imageIcon = (ImageIcon) icon;
            Image image = imageIcon.getImage().getScaledInstance((int) (icon.getIconWidth() * range), (int) (icon.getIconHeight() * range), Image.SCALE_DEFAULT);
            frame.getPhotoLabel().setIcon(new ImageIcon(image));
        }

    }

}
