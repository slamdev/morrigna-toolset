package com.github.slamdev.morrigna.toolset.integration;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import static javafx.scene.Cursor.*;

public class RegionResizer {

    private static final int RESIZE_MARGIN = 4;

    private Region region;

    private Direction direction;

    private boolean initMinHeight;

    private enum Direction {
        LEFT, RIGHT, TOP, BOTTOM;
    }

    public void enableResizing(Region region) {
        this.region = region;
        region.setOnMousePressed(this::mousePressed);
        region.setOnMouseDragged(this::mouseDragged);
        region.setOnMouseMoved(this::mouseOver);
        region.setOnMouseReleased(this::mouseReleased);
    }

    private void mousePressed(MouseEvent event) {
        if (isInDraggableZoneE(event)) {
            direction = Direction.LEFT;
        } else if (isInDraggableZoneS(event)) {
            direction = Direction.BOTTOM;
        } else if (isInDraggableZoneN(event)) {
            direction = Direction.TOP;
        } else if (isInDraggableZoneW(event)) {
            direction = Direction.RIGHT;
        } else {
            return;
        }
        if (!initMinHeight) {
            region.setMinHeight(region.getHeight());
            region.setMinWidth(region.getWidth());
            initMinHeight = true;
        }
    }

    private void mouseDragged(MouseEvent event) {
        if (direction == Direction.BOTTOM) {
            region.setMinHeight(event.getY());
        } else if (direction == Direction.LEFT) {
            region.setMinWidth(event.getX());
        } else if (direction == Direction.TOP) {
            double prevMin = region.getMinHeight();
            region.setMinHeight(region.getMinHeight() - event.getY());
            if (region.getMinHeight() < region.getPrefHeight()) {
                region.setMinHeight(region.getPrefHeight());
                region.setTranslateY(region.getTranslateY() - (region.getPrefHeight() - prevMin));
                return;
            }
            if (region.getMinHeight() > region.getPrefHeight() || event.getY() < 0) {
                region.setTranslateY(region.getTranslateY() + event.getY());
            }
        } else if (direction == Direction.RIGHT) {
            double prevMin = region.getMinWidth();
            region.setMinWidth(region.getMinWidth() - event.getX());
            if (region.getMinWidth() < region.getPrefWidth()) {
                region.setMinWidth(region.getPrefWidth());
                region.setTranslateX(region.getTranslateX() - (region.getPrefWidth() - prevMin));
                return;
            }
            if (region.getMinWidth() > region.getPrefWidth() || event.getX() < 0) {
                region.setTranslateX(region.getTranslateX() + event.getX());
            }
        }
    }

    private void mouseOver(MouseEvent event) {
        if (isInDraggableZoneS(event) || direction == Direction.BOTTOM) {
            region.setCursor(S_RESIZE);
        } else if (isInDraggableZoneE(event) || direction == Direction.LEFT) {
            region.setCursor(E_RESIZE);
        } else if (isInDraggableZoneN(event) || direction == Direction.TOP) {
            region.setCursor(N_RESIZE);
        } else if (isInDraggableZoneW(event) || direction == Direction.RIGHT) {
            region.setCursor(W_RESIZE);
        } else {
            region.setCursor(DEFAULT);
        }
    }

    private void mouseReleased(MouseEvent event) {
        initMinHeight = false;
        direction = null;
        region.setCursor(DEFAULT);
    }

    private boolean isInDraggableZoneN(MouseEvent event) {
        return event.getY() < RESIZE_MARGIN;
    }

    private boolean isInDraggableZoneW(MouseEvent event) {
        return event.getX() < RESIZE_MARGIN;
    }

    private boolean isInDraggableZoneS(MouseEvent event) {
        return event.getY() > (region.getHeight() - RESIZE_MARGIN);
    }

    private boolean isInDraggableZoneE(MouseEvent event) {
        return event.getX() > (region.getWidth() - RESIZE_MARGIN);
    }
}
