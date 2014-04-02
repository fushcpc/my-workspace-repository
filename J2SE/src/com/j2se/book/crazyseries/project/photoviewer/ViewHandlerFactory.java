package com.j2se.book.crazyseries.project.photoviewer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.j2se.book.crazyseries.project.photoviewer.handler.DeleteHandler;
import com.j2se.book.crazyseries.project.photoviewer.handler.ExistHandler;
import com.j2se.book.crazyseries.project.photoviewer.handler.NavigateHandler;
import com.j2se.book.crazyseries.project.photoviewer.handler.OpenHandler;
import com.j2se.book.crazyseries.project.photoviewer.handler.ViewHandler;
import com.j2se.book.crazyseries.project.photoviewer.handler.ZoomHandler;

public class ViewHandlerFactory {
    private static final Map<String, ViewHandler> handlerMap;
    static {
        Map<String, ViewHandler> map = new HashMap<String, ViewHandler>();
        map.put(ViewerFrame.MENU_ITEM_FILE_OPEN, new OpenHandler());
        map.put(ViewerFrame.MENU_ITEM_TOOL_PREV, new NavigateHandler(Boolean.FALSE));
        map.put(ViewerFrame.MENU_ITEM_TOOL_NEXT, new NavigateHandler(Boolean.TRUE));
        map.put(ViewerFrame.MENU_ITEM_TOOL_ZOOM_IN, new ZoomHandler(Boolean.TRUE));
        map.put(ViewerFrame.MENU_ITEM_TOOL_ZOOM_OUT, new ZoomHandler(Boolean.FALSE));
        map.put(ViewerFrame.MENU_ITEM_TOOL_DELETE, new DeleteHandler());
        map.put(ViewerFrame.MENU_ITEM_FILE_EXIST, new ExistHandler());
        handlerMap = Collections.unmodifiableMap(map);
    }

    private ViewHandlerFactory() {
    }

    public static ViewHandler getHandler(String name) {
        ViewHandler handler = handlerMap.get(name);
        return handler;
    }
}
